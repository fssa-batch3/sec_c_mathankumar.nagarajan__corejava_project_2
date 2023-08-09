package com.fssa.spartansmt.errors;

public class ProductValidatorErrors {
	private ProductValidatorErrors() {
//		private constructor
	}
	// Product Object Validation Error
	public static final String INVALID_PRODUCT_NULL = "Product Obj Can't Be Null";
	
	// Product Title Validation Error
	public static final String INVALID_PRODUCT_TITLE = "Product Title Conn't be Null or Empty";
	
	// Product Price Validation Error
	public static final String INVALID_PRODUCT_PRICE = "Product Price Must Have More Then Zero";
		
	// Product Logo Image URL Validate Error
	public static final String INVALID_PRODUCT_IMAGE_LOGO_URL = "Invalid Product Logo URL";
	
	// Store Id Validation Error
	public static final String INVALID_PRODUCT_ID = "Invalid Product Id. ID Must Have More Then ZERO";

}
