package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product/")
public class ProductController {

    //ProductServiceImpl productService = new ProductServiceImpl();
    @Autowired
    IProductService productService;

    @RequestMapping(value = "list*", method = RequestMethod.GET)
    public ModelAndView listProducts() {

        List<Product> listProducts = productService.findAllHaveBusiness();

        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", listProducts);

        return modelAndView;
    }

    @RequestMapping(value = "product-detail/{id}/{name}", method = RequestMethod.GET)
    public ModelAndView productDetail(@PathVariable Long id, @PathVariable String name) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/detail");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping(value = "search")
    public ModelAndView searchProduct(@RequestParam("txtSearch") String txtSearch) {
        Product product = productService.findByName(txtSearch);
        ModelAndView modelAndView = new ModelAndView("/product/search");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @RequestMapping("save-product")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) {

        //add to database
        productService.save(product);

        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
}
