package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    List<Product> productList = new ArrayList<>();
    {
        productList.add(new Product(1,"Samsung", 300));
        productList.add(new Product(1,"Iphone", 500));
        productList.add(new Product(1,"Nokia", 700));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}
