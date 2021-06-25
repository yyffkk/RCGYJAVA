package com.api.util.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * pdf替换文字工具类
 *
 * 思路：
 * 1.逐页搜索关键字，逐页匹配
 * 2.先读取一页的所有字符信息，存放到allItems中
 * 3.把一页的字符拼接成字符串，然后匹配关键字，匹配上，记录匹配的第一个字符的MatchItem信息；匹配不是，继续下一页匹配
 * 4.根据匹配字符串的长度和字符的宽高信息画遮罩层，然后替换文字生成新的pdf文件
 *
 * 不足之处：
 * 1.目前只支持单字符串匹配
 * 2.替换之后的文字无法和原pdf中替换掉的文字信息一致（主要有：字体大小、样式等）
 * 3.某些情况下（主要是替换字体的大小）替换之后显示不是太整齐
 * 4.字体大小、样式无法把控
 * 5.无法匹配目标文字在两页中显示的情况（例如：目标文字：替换工具，第一页页尾有替换两字，第二页页首有工具二字）
 *
 */
public class PdfUtils {

//    /**
//     * 测试类
//     * @param args
//     * @throws Exception
//     */
//    public static void main(String[] args) throws Exception{
//        String src = "/Users/AKU001/pdf/模版1.pdf";
//        String dest = "/Users/AKU001/pdf/模版1-副本.pdf";
//        ArrayList<PdfReplaceMap> pdfReplaceMaps = new ArrayList<>();
//
//        //填写需要替换的信息
//        pdfReplaceMaps.add(new PdfReplaceMap("${承租人}","张三"));
//        pdfReplaceMaps.add(new PdfReplaceMap("${承租人身份证号}","331022199811261279"));
//
//        pdfReplace(src,dest,pdfReplaceMaps);
//    }

    /**
     * 根据关键字和pdf路径，全文搜索关键字
     * @param filePath pdf目标路径
     * @param keyword 关键字
     * @return
     * @throws Exception
     */
    public static List<MatchItem> matchAll(String filePath, String keyword) throws Exception {
        List<MatchItem> items = new ArrayList<MatchItem>();
        PdfReader reader = new PdfReader(filePath);
        //获取pdf页数
        int pageSize = reader.getNumberOfPages();
        //逐页匹配关键字
        for(int page = 1;page <= pageSize;page++){
            items.addAll(matchPage(reader,page,keyword));
        }
        return items;
    }

    /**
     * 根据关键字、文档路径、pdf页数寻找特定的文件内容
     * @param reader
     * @param pageNumber 页数
     * @param keyword 关键字
     * @return
     * @throws Exception
     */
    public static List<MatchItem> matchPage(PdfReader reader, Integer pageNumber,String keyword) throws Exception {
        PdfReaderContentParser parse = new PdfReaderContentParser(reader);
        Rectangle rectangle = reader.getPageSize(pageNumber);
        //匹配监听
        KeyWordPositionListener renderListener = new KeyWordPositionListener();
        renderListener.setKeyword(keyword);
        renderListener.setPageNumber(pageNumber);
        renderListener.setCurPageSize(rectangle);
        parse.processContent(pageNumber, renderListener);
        return findKeywordItems(renderListener,keyword);
    }

    /**
     * 找到匹配的关键词块
     * @param renderListener
     * @param keyword
     * @return
     */
    public static List<MatchItem> findKeywordItems(KeyWordPositionListener renderListener,String keyword){
        //先判断本页中是否存在关键词
        List<MatchItem> allItems = renderListener.getAllItems();//所有块LIST
        StringBuffer sbtemp = new StringBuffer("");

        for(MatchItem item : allItems){//将一页中所有的块内容连接起来组成一个字符串。
            sbtemp.append(item.getContent());
        }

        List<MatchItem> matches = renderListener.getMatches();

        //一页组成的字符串没有关键词，直接return
        //第一种情况：关键词与块内容完全匹配的项,直接返回
        if(sbtemp.toString().indexOf(keyword) == -1 || matches.size() > 0){
            return matches;
        }
        //第二种情况：多个块内容拼成一个关键词，则一个一个来匹配，组装成一个关键词
        sbtemp = new StringBuffer("");
        List<MatchItem> tempItems = new ArrayList();
        for(MatchItem item : allItems){
            if(keyword.indexOf(item.getContent()) != -1 ){
                tempItems.add(item);
                sbtemp.append(item.getContent());

                if(keyword.indexOf(sbtemp.toString()) == -1){//如果暂存的字符串和关键词 不再匹配时
                    sbtemp = new StringBuffer(item.getContent());
                    tempItems.clear();
                    tempItems.add(item);
                }

                if(sbtemp.toString().equalsIgnoreCase(keyword)){//暂存的字符串正好匹配到关键词时
                    matches.add(tempItems.get(0));//得到匹配的项
                    sbtemp = new StringBuffer("");//清空暂存的字符串
                    tempItems.clear();//清空暂存的LIST
                    continue;//继续查找
                }
            }else{//如果找不到则清空
                sbtemp = new StringBuffer("");
                tempItems.clear();
            }
        }
        return matches;
    }

    /**
     * 替换目标文字，生成新的pdf文件
     * @param stamper 新生成的pdf
     * @throws Exception
     */
    public static void manipulatePdf(PdfStamper stamper,List<MatchItem> matchItems,String keyWord,String keyWordNew) throws Exception{
        PdfContentByte canvas = null;
        Map<Integer,List<MatchItem>> mapItem = new HashMap<Integer,List<MatchItem>>();
        List<MatchItem> itemList = null;
        for(MatchItem item : matchItems){
            Integer pageNum = item.getPageNum();
            if(mapItem.containsKey(pageNum)){
                itemList = mapItem.get(pageNum);
                itemList.add(item);
                mapItem.put(pageNum,itemList);
            }else{
                itemList = new ArrayList<MatchItem>();
                itemList.add(item);
                mapItem.put(pageNum,itemList);
            }
        }
        //遍历每一页去修改
        for(Integer page : mapItem.keySet()){
            List<MatchItem> items = mapItem.get(page);
            //遍历每一页中的匹配项
            for(MatchItem item : items){
                canvas = stamper.getOverContent(page);
                //因为有横线情况，所以输出文字往上偏移一点
                float x = item.getX();
                float y = item.getY()+2f;
                //因为模版是${xxx}第一位$的字体宽度是中文的一半，所以字体宽度*2
                float fontWidth = item.getFontWidth()*2;
                float fontHeight = item.getFontHeight();

                //开始绘画
                if ("\uF0A3一类人才".equals(keyWord)
                        || "\uF0A3二类人才".equals(keyWord)
                        || "\uF0A3三类人才".equals(keyWord)){
                    //添加三个正方形（当前选择一类人才）
                    //一类人才的框
                    //清除原来的框
                    canvas.saveState();
                    canvas.setColorFill(BaseColor.WHITE);
                    canvas.rectangle(x, y, 8.865448f, 12);
                    canvas.fill();
                    canvas.restoreState();
                    //添加画出的框
                    canvas.setRGBColorStroke(0xFF, 0x00, 0x00);
                    canvas.setLineWidth(0.5f);
                    canvas.rectangle(x, y, 8, 8);
                    canvas.fill();
                    canvas.stroke();
                }else if ("【$签字区】".equals(keyWord)){
                    //添加图片
                    Image image = Image.getInstance(keyWordNew);
                    image.scaleAbsolute(9, 9);//图片大小
                    image.setAbsolutePosition(x, y);
                    canvas.addImage(image);
                } else {
                    canvas.saveState();
                    canvas.setColorFill(BaseColor.WHITE);
                    canvas.rectangle(x, y,fontWidth*keyWord.length(),fontHeight);
                    canvas.fill();
                    canvas.restoreState();
                    //开始写入文本
                    canvas.beginText();
                    BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
                    Font font = new Font(bf,fontWidth,Font.BOLD);
                    //设置字体和大小
                    canvas.setFontAndSize(font.getBaseFont(), fontWidth);
                    //设置字体的输出位置
                    canvas.setTextMatrix(x, y+fontWidth/10+0.5f);
                    //要输出的text
                    canvas.showText(keyWordNew);

                    canvas.endText();
                }
            }
        }
        System.out.println("complete");
    }

    /**
     * 替换pdf中指定文字
     * @param src 目标pdf路径
     * @param dest 新pdf的路径
     * @param pdfReplaceMaps 替换的新旧文字 数组集合
     * @throws Exception
     */
    public static void pdfReplace(String src, String dest, ArrayList<PdfReplaceMap> pdfReplaceMaps) throws Exception{
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));

        if (pdfReplaceMaps != null && pdfReplaceMaps.size()>0){
            for (PdfReplaceMap pdfReplaceMap : pdfReplaceMaps) {
                String keyWord2 = pdfReplaceMap.getOldStr();
                String keyWordNew2 = pdfReplaceMap.getNewStr();
                manipulatePdf(stamper,matchAll(src,keyWord2),keyWord2,keyWordNew2);
            }
        }

        stamper.close();
        reader.close();
    }
}