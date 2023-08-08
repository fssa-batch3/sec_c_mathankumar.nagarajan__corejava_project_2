package com.fssa.spartansmt.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.model.Product;

public class TestProductDao {

	static Product validProduct() {

		Product p1 = new Product();
		p1.setProductId(15);
		p1.setProductTitle("IQOO Z6 44W (Lumina Blue, 128 GB) (8 GB RAM)");
		p1.setProductPrice(29999);
		p1.setProductImage("https://iili.io/HUMtFun.webp");
		p1.setStoreId(3);

		return p1;

	}
	
	
	// Valid Test Cases
	static Product invalidProduct() {
		Product p1 = new Product();
		p1.setProductId(-1);
		return p1;
	}

	@Test
	void testValidAddProduct() throws DAOException {
		Assertions.assertTrue(ProductDao.addProduct(validProduct()));
	}

	@Test
	void testValidUpdateProduct() throws DAOException, InvalidProductDetailsException {
		Assertions.assertTrue(ProductDao.updateProduct(validProduct()));
	}

	@Test
	void testValidDelectProduct() throws DAOException, InvalidProductDetailsException {
		Assertions.assertTrue(ProductDao.deleteProduct(validProduct().getProductId()));
	}

	@Test
	void testValidGetProductDetails() throws DAOException, InvalidProductDetailsException {
		ProductDao pd = new ProductDao();
		Assertions.assertTrue(pd.getAllProductDetails());
	}

	
	// Invalid Test Cases
	@Test
	void testInvalidAddProduct() {
		
		try {
			ProductDao.addProduct(invalidProduct());
		}catch(DAOException ex) {
			Assertions.assertEquals("Add Product to the Database Method is Failded", ex.getMessage());
		}
		
	}
	
	@Test
	void testInvalidUpdateProduct() throws InvalidProductDetailsException, DAOException {
		
		try {
			Product p2 = new Product();
			p2.setProductId(2);
			ProductDao.updateProduct(p2);
		}catch(DAOException ex) {
			Assertions.assertEquals("Update Product Details to Datadase Method Is Failded", ex.getMessage());
		}
		
	}
	
	@Test
	void testInvalidUpdateProductId() throws InvalidProductDetailsException, DAOException {
		
		try {
			ProductDao.updateProduct(invalidProduct());
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
		
	}

	@Test
	void testInvalidDelectProductId() throws InvalidProductDetailsException, DAOException {
		
		try {
			ProductDao.deleteProduct(invalidProduct().getProductId());
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
		
	}



}
