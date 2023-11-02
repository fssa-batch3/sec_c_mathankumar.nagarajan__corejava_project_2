package com.fssa.spartansmt.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.exception.ServiceException;
import com.fssa.spartansmt.model.Product;

class TestProductService {

	Product demoProduct() {

		Product p1 = new Product();
		p1.setProductId(120);
		p1.setProductTitle("Teddy Bear");
		p1.setProductPrice(9199);
		p1.setProductImage("https://assets.flowersnfruits.com/uploads/product-pics/1631950556_blue-teddy.jpg");
		p1.setStoreId(30);
		p1.setUploadedDate(LocalDate.now());

		return p1;

	}


	@Test
	void testValidAddProduct() {

		TestProductService tps = new TestProductService();
		try {
			Assertions.assertTrue(ProductService.addProduct(tps.demoProduct()));
		} catch (InvalidProductDetailsException | DAOException e) {
			e.printStackTrace();
		}

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
		} catch (DAOException ex) {
			fail("Get Product Detials Methos Is Failded");
		}
	}

	@Test
	void testValidGetAllProductDetailsByStoreId() throws DAOException {
		ProductService ps = new ProductService();
		try {
			List<Product> productList = ps.getAllProductsByStoreId(demoProduct().getStoreId());
		} catch (DAOException ex) {
			fail("Get Product Detials Methos Is Failded");
		}
	}

	@Test
	void testValidGetProductById() throws InvalidProductDetailsException, DAOException {
		ProductService productSer = new ProductService();
		try {
			Product product = productSer.getProductById(demoProduct().getProductId());
		} catch (ServiceException e) {
			fail("Get Product By Id Method Is Failded");
		}
	}

}
