package com.avenuecode.sales.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avenuecode.sales.model.Product;
import com.avenuecode.sales.model.ProductOrder;
import com.avenuecode.sales.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService os;

	@RequestMapping(method = RequestMethod.POST)
	public void placeOrder(@RequestBody ProductOrder po) {
		os.save(po);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void modifyOrder(@PathVariable int id, @RequestBody Collection<Product> list) {
		os.delete(id);
		ProductOrder po = new ProductOrder(id, list);
		os.save(po);
	}

	@RequestMapping("/")
	public List<ProductOrder> listAllOrders() {
		List<ProductOrder> list = new ArrayList<>();
		os.findAll().forEach(e -> {
			addLinks(e);
			list.add(e);
		}

		);
		return list;
	}

	@RequestMapping("/{id}")
	public ProductOrder getProductById(@PathVariable int id) {
		return os.findOne(id);
	}

	private void addLinks(ProductOrder po) {
		Link sl = linkTo(methodOn(OrderController.class).getProductById(po.getProdOrderId())).withSelfRel();
		po.add(sl);
	}
}
