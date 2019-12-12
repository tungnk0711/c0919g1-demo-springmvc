package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.repository.impl.ProductRepositoryImpl;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    //ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAllHaveBusiness() {

        // code business....

        return productRepository.findAll();
    }
}
