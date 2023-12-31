package com.fssa.spartansmt.errors;

/*
 * @author MathankumarNagarajan
 * 
 * An interface which holds the Error Messages.
 * It has variables.
 */

public class StoreValidatorErrors {
	
	private StoreValidatorErrors() {
		// private constructor
	}

	// Store Attributes validate Errors
	public static final String INVALID_ATTRIBUTES = "Name or Category or Image link can't be null";

	// Store Object Validate Errors
	public static final String INVALID_STORE_NULL = "Store Obj Can't Be Null";

	// Store Logo Image URL Validate Errors
	public static final String INVALID_STORE_IMAGE_LOGO_URL = "Invalid Store Logo URL";

	// Store ID Validate Errors
	public static final String INVALID_STORE_ID = "Store ID Must Have More Then Zero";

}
