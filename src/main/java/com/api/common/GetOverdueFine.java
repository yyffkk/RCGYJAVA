package com.api.common;

import com.api.vo.app.AppDailyPaymentDetailsVo;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoFindByIdDailyPayment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 计算滞纳金公共类
 * （计算公式【总支付金额 = 租缴金额*（1+费率/100），每月累乘】）
 * （滞纳金 = 总支付金额 - 租缴金额）
 */
public class GetOverdueFine {
    /**
     * app 计算滞纳金
     * @param appDailyPaymentDetailsVo app 生活缴费详情Vo list 回显
     * @return app 生活缴费详情Vo list 回显
     */
    public static AppDailyPaymentDetailsVo getAppOverdueFine(AppDailyPaymentDetailsVo appDailyPaymentDetailsVo){
        //计算出滞纳金
        if (appDailyPaymentDetailsVo.getStatus() != 3) {//3.全部缴纳
            //当不为全部缴纳时，滞纳金需要计算，否则取数据库的滞纳金
            Date paymentTerm = appDailyPaymentDetailsVo.getPaymentTerm();
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (df.format(date).compareTo(df.format(paymentTerm)) > 0) {
                //当前时间超过缴费期限(计算公式【总支付金额 = 代缴金额*（1+费率/100），每月累乘】)
                Calendar calendar = Calendar.getInstance();
                calendar.clear();
                calendar.setTime(paymentTerm);
                //缴纳期限的年份
                int paymentTermYear = calendar.get(Calendar.YEAR);
                //缴纳期限的月份
                int paymentTermMonth = calendar.get(Calendar.MONTH) + 1;
                //缴纳期限的日期
                int paymentTermDay = calendar.get(Calendar.DAY_OF_MONTH);
                calendar.clear();
                calendar.setTime(date);
                //当前的年份
                int dateYear = calendar.get(Calendar.YEAR);
                //当前的月份
                int dateMonth = calendar.get(Calendar.MONTH) + 1;
                //当前的日期
                int dateDay = calendar.get(Calendar.DAY_OF_MONTH);

                //计算相差多少个月
                int betweenMonth = Math.abs((dateYear - paymentTermYear) * 12 + (dateMonth - paymentTermMonth));
                if (dateDay > paymentTermDay) {
                    //当 当前时间日期 大于 缴纳期限时日期 时，月份+1
                    betweenMonth = betweenMonth + 1;
                }

                //计算出 支付总金额【待缴金额+滞纳金】
                BigDecimal totalPrice = appDailyPaymentDetailsVo.getPaymentPrice();
                //(计算公式【待缴金额*（1+费率/100），每月累乘】)
                for (int i = 0; i < betweenMonth; i++) {
                    //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                    Double rate = Double.valueOf(appDailyPaymentDetailsVo.getRate());
                    totalPrice = totalPrice.multiply(new BigDecimal(1 + rate / 100));
                }
                //滞纳金 = 支付总金额 - 代缴金额
                BigDecimal overdueFine = totalPrice.setScale(2, RoundingMode.HALF_UP).subtract(appDailyPaymentDetailsVo.getPaymentPrice());
                appDailyPaymentDetailsVo.setOverdueFine(overdueFine);
            } else {
                //当前时间不超过缴费期限,滞纳金为0
                appDailyPaymentDetailsVo.setOverdueFine(BigDecimal.ZERO);
            }
        }
        return appDailyPaymentDetailsVo;
    }

    /**
     * 后台 list 计算滞纳金
     * @param voDailyPayment 日常缴费Vo list 回显
     * @return app 日常缴费Vo list 回显
     */
    public static VoDailyPayment getManagelistOverdueFine(VoDailyPayment voDailyPayment){
        //计算出滞纳金
        if (voDailyPayment.getStatus() != 3){//3.全部缴纳
            //当不为全部缴纳时，滞纳金需要计算，否则取数据库的滞纳金
            Date paymentTerm = voDailyPayment.getPaymentTerm();
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (df.format(date).compareTo(df.format(paymentTerm)) > 0){
                //当前时间超过缴费期限(计算公式【总支付金额 = 代缴金额*（1+费率/100），每月累乘】)
                Calendar calendar = Calendar.getInstance();
                calendar.clear();
                calendar.setTime(paymentTerm);
                //缴纳期限的年份
                int paymentTermYear = calendar.get(Calendar.YEAR);
                //缴纳期限的月份
                int paymentTermMonth = calendar.get(Calendar.MONTH)+1;
                //缴纳期限的日期
                int paymentTermDay = calendar.get(Calendar.DAY_OF_MONTH);
                calendar.clear();
                calendar.setTime(date);
                //当前的年份
                int dateYear = calendar.get(Calendar.YEAR);
                //当前的月份
                int dateMonth = calendar.get(Calendar.MONTH)+1;
                //当前的日期
                int dateDay = calendar.get(Calendar.DAY_OF_MONTH);

                //计算相差多少个月
                int betweenMonth = Math.abs((dateYear-paymentTermYear)*12+(dateMonth - paymentTermMonth));
                if (dateDay > paymentTermDay){
                    //当 当前时间日期 大于 缴纳期限时日期 时，月份+1
                    betweenMonth = betweenMonth +1;
                }

                //计算出 支付总金额【待缴金额+滞纳金】
                BigDecimal totalPrice = voDailyPayment.getPaymentPrice();
                //(计算公式【待缴金额*（1+费率/100），每月累乘】)
                for (int i = 0; i < betweenMonth; i++) {
                    //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                    Double rate = Double.valueOf(voDailyPayment.getRate());
                    totalPrice = totalPrice.multiply(new BigDecimal(1+rate/100));
                }
                //滞纳金 = 支付总金额 - 代缴金额
                BigDecimal overdueFine = totalPrice.setScale(2, RoundingMode.HALF_UP).subtract(voDailyPayment.getPaymentPrice());
                voDailyPayment.setOverdueFine(overdueFine);
            }else {
                //当前时间不超过缴费期限,滞纳金为0
                voDailyPayment.setOverdueFine(BigDecimal.ZERO);
            }
        }
        return voDailyPayment;
    }

    /**
     * 后台 findById 计算滞纳金
     * @param byId 日常缴纳表Vo findById 回显
     * @return app 日常缴纳表Vo findById 回显
     */
    public static VoFindByIdDailyPayment getManageFBIOverdueFine(VoFindByIdDailyPayment byId){
        //计算出滞纳金
        if (byId.getStatus() != 3){//3.全部缴纳
            //当不为全部缴纳时，滞纳金需要计算，否则取数据库的滞纳金
            Date paymentTerm = byId.getPaymentTerm();
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (df.format(date).compareTo(df.format(paymentTerm)) > 0){
                //当前时间超过缴费期限(计算公式【总支付金额 = 代缴金额*（1+费率/100），每月累乘】)
                Calendar calendar = Calendar.getInstance();
                calendar.clear();
                calendar.setTime(paymentTerm);
                //缴纳期限的年份
                int paymentTermYear = calendar.get(Calendar.YEAR);
                //缴纳期限的月份
                int paymentTermMonth = calendar.get(Calendar.MONTH)+1;
                //缴纳期限的日期
                int paymentTermDay = calendar.get(Calendar.DAY_OF_MONTH);
                calendar.clear();
                calendar.setTime(date);
                //当前的年份
                int dateYear = calendar.get(Calendar.YEAR);
                //当前的月份
                int dateMonth = calendar.get(Calendar.MONTH)+1;
                //当前的日期
                int dateDay = calendar.get(Calendar.DAY_OF_MONTH);

                //计算相差多少个月
                int betweenMonth = Math.abs((dateYear-paymentTermYear)*12+(dateMonth - paymentTermMonth));
                if (dateDay > paymentTermDay){
                    //当 当前时间日期 大于 缴纳期限时日期 时，月份+1
                    betweenMonth = betweenMonth +1;
                }

                //计算出 支付总金额【待缴金额+滞纳金】
                BigDecimal totalPrice = byId.getPaymentPrice();
                //(计算公式【待缴金额*（1+费率/100），每月累乘】)
                for (int i = 0; i < betweenMonth; i++) {
                    //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                    Double rate = Double.valueOf(byId.getRate());
                    totalPrice = totalPrice.multiply(new BigDecimal(1+rate/100));
                }
                //滞纳金 = 支付总金额 - 代缴金额
                BigDecimal overdueFine = totalPrice.setScale(2, RoundingMode.HALF_UP).subtract(byId.getPaymentPrice());
                byId.setOverdueFine(overdueFine);
            }else {
                //当前时间不超过缴费期限,滞纳金为0
                byId.setOverdueFine(BigDecimal.ZERO);
            }
        }
        return byId;
    }
}
