package com.fssa.spartansmt.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.logger.Logger;
import com.fssa.spartansmt.model.Product;

class TestProductDao {
	
	static Product validProduct() {

		Product p1 = new Product();
		p1.setProductId(15);
		p1.setProductTitle("IQOO Z6 44W (Lumina Blue, 128 GB) (8 GB RAM)");
		p1.setProductPrice(29999);
		p1.setProductImage("https://iili.io/HUMtFun.webp");
		p1.setStoreId(2);
		p1.setUploadedDate(LocalDate.now());

		return p1;
 
	}
	
	
	// Valid Test Cases
	static Product invalidProduct() {
		Product p1 = new Product();
		p1.setProductId(-1);
		p1.setUploadedDate(LocalDate.now());
		return p1;
	}

	@Test
	void testValidAddProduct() throws DAOException {
		ProductDao productDao = new ProductDao();
		Assertions.assertTrue(productDao.addProduct(validProduct()));
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
		
		try {
			ProductDao pd = new ProductDao();
			List<Product> productList = pd.getAllProductDetails();
			for(Product ele : productList) {
				Logger.info(ele);
			}
		}catch(DAOException ex) {
			fail("Get All Product Details Method Is Failded");
		}
		
	}

	

	@Test
	void testValidGetProductsDetailsByStoreId() throws DAOException, InvalidProductDetailsException {
		
		try {
			ProductDao pd = new ProductDao();
			List<Product> productList = pd.getAllProductByStoreId(validProduct().getStoreId());
			for(Product ele : productList) {
				Logger.info(ele);
			}
		}catch(DAOException ex) {
			fail("Get All Products Details By Store Id Method Is Failded");
		}
		
	}
	
	// Invalid Test Cases
	@Test
	void testInvalidAddProduct() {
		
		try {
			ProductDao productDao = new ProductDao();
			productDao.addProduct(invalidProduct());
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
