package com.avenuecode.sales.service;

import org.springframework.data.repository.CrudRepository;

import com.avenuecode.sales.model.ProductOrder;

public interface OrderService extends CrudRepository<ProductOrder, Integer> {

}
