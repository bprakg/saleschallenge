package com.avenuecode.sales.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avenuecode.sales.model.Product;
import com.avenuecode.sales.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService ps;

	@RequestMapping("/")
	public Collection<Product> listAllProducts() {
		Collection<Product> list = new ArrayList<>();
		ps.findAll().forEach(c -> {
			addLinks(c);
			list.add(c);
		});
		return list;
	}

	private void addLinks(Product c) {
		Link sl = linkTo(methodOn(ProductController.class).getProductById(c.getProdId())).withSelfRel();
		c.add(sl);
	}

	@RequestMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return ps.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addProduct(@RequestBody Product prod) {
		ps.save(prod);
	}
}
