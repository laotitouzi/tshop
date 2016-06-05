package com.tshop.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.StringUtils;

import com.tshop.controller.BaseController;
import com.tshop.page.Criteria;
import com.tshop.page.Page;

import com.tshop.entity.Product;
import com.tshop.service.ProductService;

/**
* author: Han, Tixiang
* createDate: 2016-06-05
*/

@Controller
@Scope("prototype")
@RequestMapping("/product")
public class ProductController extends BaseController{
    
    @Autowired(required=false)
    private ProductService productService; 
    
    private Page<Product> page;

    private List<Product> list;


    /**
     *  非分页查询，根据条件显示所有记录
     */
    @RequestMapping("/show")
    public String show(HttpServletRequest request, HttpServletResponse response,Criteria criteria) throws Exception{
        //TODO
        list  =  productService.queryProductForList(criteria);
        return "/Product/show";
    }


    /**
    *  分页查询
    */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response,Criteria criteria) throws Exception{
        //TODO
        page  =  productService.queryProductForPage(criteria);
        return "/Product/list";
    }


    @RequestMapping(value = "/doSave")
    @ResponseBody
    public JSONObject doSave(@Valid Product  product, BindingResult result){
        if (product == null) {
        return resonseError(BASIC_MESSAGE_MUST_INPUT);
        }

        if (result.hasErrors()) {
            return resonseError(result.getAllErrors());
        }

        productService.addProduct(product);

        return resonseOk();
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public JSONObject doUpdate(@Valid Product product,BindingResult result){
        if (product == null) {
            return resonseError(BASIC_MESSAGE_MUST_INPUT);
        }

        if (result.hasErrors()) {
            return resonseError(result.getAllErrors());
        }

        productService.updateProductBySelective(product);

        return resonseOk();
    }

    @RequestMapping("/doDeleteById")
    @ResponseBody
    public JSONObject doDeleteById(String id){
        if(StringUtils.isEmpty(id)){
            return resonseError(BASIC_MUST_INPUT_DELETE_ID_OR_IDS);
        }

        int record = productService.deleteProductById(id);

        if(record > 0){
            return resonseOk();
        }

        return responseError();
    }

    @RequestMapping("/doDeleteByIds")
    @ResponseBody
    public JSONObject doDeleteByIds(String ids){
        if(StringUtils.isEmpty(ids)){
            return resonseError(BASIC_MUST_INPUT_DELETE_ID_OR_IDS);
        }

        int record = productService.deleteProductByIds(ids);

        if(record > 0){
            return resonseOk();
        }

        return responseError();
    }

    public  List<Product> getList(){
        return list;
    }
    
    public void setList(List<Product> list){
        this.list = list;
    }

    public  Page<Product> getPage(){
        return page;
    }

    public void setPage(Page<Product> page){
        this.page = page;
    }
}
