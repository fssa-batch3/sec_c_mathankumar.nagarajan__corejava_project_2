package com.fssa.spartansmt.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.errors.StoreValidatorErrors;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.model.Product;

class TestProductValidator {
	
	// Valid Product Object
	static Product validProduct() {
		Product product = new Product();
		product.setProductTitle("Mens Air Zoom Vomero 15 Running Shoe");
		product.setProductPrice(1999);
		product.setProductImage("https://iili.io/HWXep1e.png");
		product.setStoreId(1);
		product.setProductId(1);
		return product;
	}
	
	// Invalid Product Object
	static Product invalidProduct() {
		
		Product invalidProduct = new Product(null, 500, null, 0);
		return invalidProduct;

	}


	@Test
	void testProductValidate() throws InvalidProductDetailsException {

		Assertions.assertTrue(ProductValidator.validate(validProduct()));
	
	}

	@Test
	void testInvalidProduct() {
		
		try {

			Product p1 = null;
			ProductValidator.validate(p1);
			Assertions.fail("Test Invalid Product Methos Is Failded");
	
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_NULL, ex.getMessage());
		}
		
	}
	
	// Null Attributes Test Cases
	
	@Test
	void testInvalidProductTitle() {
		
		try {
			ProductValidator.validateProductTitle(invalidProduct().getProductTitle());
			Assertions.fail("Test Invalid Product Title Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_TITLE, ex.getMessage());
		}
		
	}
	
	@Test
	void testInvalidProductPrice() {
		
		try {
			ProductValidator.validateProductPrice(invalidProduct().getProductPrice());
			Assertions.fail("Test Invalid Product Price Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_PRICE, ex.getMessage());
		}
		
	}
	
	@Test
	void testInvalidProductImageURL() {
		
		try {
			ProductValidator.validateProductImageLink(invalidProduct().getProductImage());
			Assertions.fail("Test Invalid Product Image URL Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL, ex.getMessage());
		}
		
	}
	
	@Test
	void testInvalidProductStoreId() {
		
		try {
			ProductValidator.validateStoreId(invalidProduct().getStoreId());
			Assertions.fail("Test Invalid Product Store Id Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_STORE_ID, ex.getMessage());
		}
		
	}
	
	
	@Test
	void testInvalidProductURL() {
		
		try {
			String invalidProductUrl = "https://iili.io/HWXep1e";
			ProductValidator.validateProductImageLink(invalidProductUrl);
			Assertions.fail("Test Invalid Product Image URL Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL, ex.getMessage());
		}
		
	}
	
	@Test 
	void testValidProductId() throws InvalidProductDetailsException {
		ProductValidator pv = new ProductValidator();
		Assertions.assertTrue(pv.validateProductId(validProduct().getProductId()));
	}
	
	@Test
	void testInvalidProductId() {
		try {
			int invalidProductId = -1;
			ProductValidator pv = new ProductValidator();
			pv.validateProductId(invalidProductId);
			Assertions.fail("Test Invalid Product Id Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
	}
	
	
	// Empty Space Validations
	
	@Test
	void testInvalidProductTitleEmptySpace() {
		
		try {
			Product p2 = new Product("", 1999, "https://iili.io/HWXep1e.png", 1);
			ProductValidator.validate(p2);
			Assertions.fail("Test Invalid Product Title Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_TITLE, ex.getMessage());
		}
		
	}
	
	@Test
	void testInvalidProductURLEmptySpace() {
		
		try {
			Product p2 = new Product("Mens Air Zoom Vomero 15 Running Shoe", 1000, "", 1);
			ProductValidator.validate(p2);
			Assertions.fail("Test Invalid Product Image URL Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL, ex.getMessage());
		}
		
	}
	
	

}
