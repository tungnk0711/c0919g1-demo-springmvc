package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product/")
public class ProductController {

    //ProductServiceImpl productService = new ProductServiceImpl();
    @Autowired
    IProductService productService;

    @RequestMapping(value = "list*",method = RequestMethod.GET)
    public ModelAndView listProducts(){

        List<Product> listProducts = productService.findAllHaveBusiness();

        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products",listProducts);

        return modelAndView;
    }

    @RequestMapping(value = "product-detail/{id}", method = RequestMethod.GET)
    public ModelAndView productDetail(@PathVariable Long id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/detail");
        modelAndView.addObject("product", product);
        return  modelAndView;
    }
}
