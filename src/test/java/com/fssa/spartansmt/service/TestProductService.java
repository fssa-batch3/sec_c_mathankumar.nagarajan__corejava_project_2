package com.fssa.spartansmt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.model.Product;

public class TestProductService {

	Product demoProduct() {

		Product p1 = new Product();
		p1.setProductId(6);
		p1.setProductTitle("Test Product Service");
		p1.setProductPrice(2900);
		p1.setProductImage("https://iili.io/HkeiZmb.webp");
		p1.setStoreId(2);

		return p1;

	}
	

	@Test
	void testValidAddProduct() throws InvalidProductDetailsException, DAOException {

		TestProductService tps = new TestProductService();
		Assertions.assertTrue(ProductService.addProduct(tps.demoProduct()));

	}

	@Test
	void testValidUpdateProduct() throws InvalidProductDetailsException, DAOException {
		TestProductService tps = new TestProductService();
		Assertions.assertTrue(ProductService.updateProduct(tps.demoProduct()));
	}

	@Test
	void testValidDeleteProduct() throws InvalidProductDetailsException, DAOException {
		Assertions.assertTrue(ProductService.deleteProduct(6));
	}

	@Test
	void testValidGetAllProductDetails() throws DAOException {
		ProductService ps = new ProductService();
		Assertions.assertTrue(ps.getAllProductDetails());
	}
	
}
