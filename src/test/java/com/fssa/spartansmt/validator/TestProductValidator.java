package com.fssa.spartansmt.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.errors.StoreValidatorErrors;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.model.Product;

public class TestProductValidator {


	@Test
	public void testProductValidate() throws InvalidProductDetailsException {
		Product p2 = new Product();
		p2.setProductTitle("Mens Air Zoom Vomero 15 Running Shoe");
		p2.setProductPrice(1999);
		p2.setProductImage("https://iili.io/HWXep1e.png");
		p2.setStoreId(1);
		
		Assertions.assertTrue(ProductValidator.validate(p2));
	}

	@Test
	public void testInvalidProduct() {
		
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
	public void testInvalidProductTitle() {
		
		try {
			Product p2 = new Product(null, 1999, "https://iili.io/HWXep1e.png", 1);
			ProductValidator.validate(p2);
			Assertions.fail("Test Invalid Product Title Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_TITLE, ex.getMessage());
		}
		
	}
	
	@Test
	public void testInvalidProductPrice() {
		
		try {
			Product p2 = new Product("Mens Air Zoom Vomero 15 Running Shoe", 500, "https://iili.io/HWXep1e.png", 1);
			ProductValidator.validate(p2);
			Assertions.fail("Test Invalid Product Price Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_PRICE, ex.getMessage());
		}
		
	}
	
	@Test
	public void testInvalidProductImageURL() {
		
		try {
			Product p2 = new Product("Mens Air Zoom Vomero 15 Running Shoe", 1000, null, 1);
			ProductValidator.validate(p2);
			Assertions.fail("Test Invalid Product Image URL Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL, ex.getMessage());
		}
		
	}
	
	@Test
	public void testInvalidProductStoreId() {
		
		try {
			Product p2 = new Product("Mens Air Zoom Vomero 15 Running Shoe", 1000, "https://iili.io/HWXep1e.png", -1);
			ProductValidator.validate(p2);
			Assertions.fail("Test Invalid Product Store Id Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_STORE_ID, ex.getMessage());
		}
		
	}
	
	
	@Test
	public void testInvalidProductURL() {
		
		try {
			Product p2 = new Product("Mens Air Zoom Vomero 15 Running Shoe", 1000, "https://iili.io/HWXep1e", 1);
			ProductValidator.validate(p2);
			Assertions.fail("Test Invalid Product Image URL Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL, ex.getMessage());
		}
		
	}
	
	@Test 
	public void testValidProductId() throws InvalidProductDetailsException {
		ProductValidator pv = new ProductValidator();
		Product p3 = new Product();
		p3.setProductId(1);
		Assertions.assertTrue(pv.validateProductId(p3.getProductId()));
	}
	
	@Test
	public void testInvalidProductId() {
		try {
			ProductValidator pv = new ProductValidator();
			pv.validateProductId(-1);
			Assertions.fail("Test Invalid Product Id Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
	}
	
	// Empty Space Validations
	
	@Test
	public void testInvalidProductTitleEmptySpace() {
		
		try {
			Product p2 = new Product("", 1999, "https://iili.io/HWXep1e.png", 1);
			ProductValidator.validate(p2);
			Assertions.fail("Test Invalid Product Title Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_TITLE, ex.getMessage());
		}
		
	}
	
	@Test
	public void testInvalidProductURLEmptySpace() {
		
		try {
			Product p2 = new Product("Mens Air Zoom Vomero 15 Running Shoe", 1000, "", 1);
			ProductValidator.validate(p2);
			Assertions.fail("Test Invalid Product Image URL Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL, ex.getMessage());
		}
		
	}
	
	

}
