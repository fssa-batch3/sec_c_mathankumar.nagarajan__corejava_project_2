package com.fssa.spartansmt.service;


import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.logger.Logger;
import com.fssa.spartansmt.model.Product;

class TestProductService {

	Product demoProduct() {

		Product p1 = new Product();
		p1.setProductId(27);
		p1.setProductTitle("Oppo");
		p1.setProductPrice(2900);
		p1.setProductImage("https://iili.io/HkeiZmb.webp");
		p1.setStoreId(2);
		p1.setUploadedDate(LocalDate.now());

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
		try {
			List<Product> productList = ps.getAllProductDetails();
			for(Product ele : productList) {
				Logger.info(ele);
			}
		}catch(DAOException ex) {
			fail("Get Product Detials Methos Is Failded");
		}
	} 
	
	
	@Test 
	void testValidGetAllProductDetailsByStoreId() throws DAOException {
		ProductService ps = new ProductService();
		try {
			List<Product> productList = ps.getAllProductsByStoreId(demoProduct().getStoreId());
			for(Product ele : productList) {
				Logger.info(ele);
			}
		}catch(DAOException ex) {
			fail("Get Product Detials Methos Is Failded");
		}
	} 
	
}
