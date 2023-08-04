package com.fssa.spartansmt.validator;

import java.util.regex.Pattern;

import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.errors.StoreValidatorErrors;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.model.Product;

public class ProductValidator {
	
	// Product Object Validation Method.
	public static boolean validate(Product product) throws InvalidProductDetailsException{

		// Product Object Validation if the Product Object is "NULL" It will Throw an Exception.
		if(product == null) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_NULL);
		}
		
		// Product Title Validation If the Title is Null or Empty Exception Will Throw otherwise it will check other Condition.
		if(product.getProductTitle() == null || "".equals(product.getProductTitle().trim())) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_TITLE);
		}
		
		// Product Price Validation If the Product Price is less then 900 It will throw the Exception.
		if(product.getProductPrice() < 900) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_PRICE);
		}
		
		// Product Image URL Validation. If the product Image URL is Null or Empty It will throw the Exception.
		if(product.getProductImage() == null || "".equals(product.getProductImage().trim())) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL);
		}
		
		// Image URL Regex Pattern Validate Code
		boolean isMatch = Pattern.matches("(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg|webp))", product.getProductImage());  
				
		// If the patter is not Matched it will throw the Exception Otherwise it's True.
		if(!isMatch) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL);
		}
		
		/* If the Store Id is Must have more then then ZERO. 
		 * If Store Id Have More then Zero it will return true. 
		 * OtherWise it throw Exception.
		 */
		if(product.getStoreId() <= 0) {
			throw new InvalidProductDetailsException(StoreValidatorErrors.INVALID_STORE_ID);
		}
		
		return true;
	
	}
	

	
	// Product ID Validation Method.
	public boolean validateProductId(int productId) throws InvalidProductDetailsException {
		
		// If the product Id is ZERO or less then Zero it will throw the Exception. Otherwise it'll true.
		if(productId <= 0) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_ID);
		}
		
		return true;
		
	}

}
