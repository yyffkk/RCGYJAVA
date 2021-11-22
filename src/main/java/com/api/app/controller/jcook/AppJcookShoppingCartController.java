package com.api.app.controller.jcook;

import com.api.app.service.jcook.AppJcookShoppingCartService;
import com.api.model.jcook.dto.DeleteShoppingCartDTO;
import com.api.model.jcook.dto.InsertShoppingCartDTO;
import com.api.model.jcook.dto.SettlementShoppingCartDTO;
import com.api.model.jcook.dto.UpdateShoppingCartNumDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 京库克商城（第三方对接）App端购物车
 */
@RestController
@RequestMapping("app/user/jcookShoppingCat")
public class AppJcookShoppingCartController {
    @Resource
    AppJcookShoppingCartService appJcookShoppingCartService;


    /**
     * 我的购物车
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/myShoppingCart")
    public Map<String,Object> myShoppingCart(Integer id){
        return appJcookShoppingCartService.myShoppingCart(id);
    }

    /**
     * 加入购物车
     * @param insertShoppingCartDTO 加入购物车model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insertShoppingCart")
    public Map<String,Object> insertShoppingCart(@RequestBody InsertShoppingCartDTO insertShoppingCartDTO, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        insertShoppingCartDTO.setResidentId(id);//填入用户主键id
        return appJcookShoppingCartService.insertShoppingCart(insertShoppingCartDTO);
    }

    /**
     * 更改购物车商品数量
     * @param updateShoppingCartNumDTO 修改购物车数量model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/updateShoppingCartNum")
    public Map<String,Object> updateShoppingCartNum(@RequestBody UpdateShoppingCartNumDTO updateShoppingCartNumDTO, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        updateShoppingCartNumDTO.setResidentId(id);//填入用户主键id
        return appJcookShoppingCartService.updateShoppingCartNum(updateShoppingCartNumDTO);
    }

    /**
     * 批量删除购物车商品
     * @param deleteShoppingCartDTO 删除购物车model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/deleteShoppingCart")
    public Map<String,Object> deleteShoppingCart(@RequestBody DeleteShoppingCartDTO deleteShoppingCartDTO, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        deleteShoppingCartDTO.setResidentId(id);//填入用户主键id
        return appJcookShoppingCartService.deleteShoppingCart(deleteShoppingCartDTO);
    }


    /**
     * 购物车结算
     * @param settlementShoppingCartDTO 结算购物车model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/settlement")
    public Map<String,Object> settlement(@RequestBody SettlementShoppingCartDTO settlementShoppingCartDTO, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        settlementShoppingCartDTO.setResidentId(id);//填入用户主键id
        return appJcookShoppingCartService.settlement(settlementShoppingCartDTO);
    }

}
