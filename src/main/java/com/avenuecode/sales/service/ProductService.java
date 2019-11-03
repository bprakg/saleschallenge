package com.avenuecode.sales.service;

import org.springframework.data.repository.CrudRepository;

import com.avenuecode.sales.model.Product;

public interface ProductService extends CrudRepository<Product, Integer> {

}
