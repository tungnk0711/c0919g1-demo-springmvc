package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    //ProductServiceImpl productService = new ProductServiceImpl();
    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public ModelAndView listProducts(){

        List<Product> listProducts = productService.findAllHaveBusiness();

        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products",listProducts);

        return modelAndView;
    }
}
