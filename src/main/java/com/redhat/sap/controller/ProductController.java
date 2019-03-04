package com.redhat.sap.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.sap.bean.Product;

@RestController
public class ProductController {

	@Produce(uri = "direct:start")
	private ProducerTemplate template;

	//Return all products sorted by price
	@GetMapping("/sap/products")
	public Object getProducts() {
		template.sendBody("Hello");
		LinkedHashMap response = (LinkedHashMap) template.requestBody("<hello/>");
		return response.get("results");
		//return response.getClass();
		//List<Product> productList = new ArrayList<Product>();
		//Product fun = new Product();
		//fun.setId("12345");
		//productList.add(fun);
		//return productList;
	}
}
