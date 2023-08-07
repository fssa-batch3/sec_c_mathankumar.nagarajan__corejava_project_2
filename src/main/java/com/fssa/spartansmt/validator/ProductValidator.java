package com.fssa.spartansmt.validator;

import java.util.regex.Pattern;
import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.errors.StoreValidatorErrors;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.model.Product;

/*
 * @author MathankumarNagarajan
 */

public class ProductValidator {

	/*
	 *  Product Object Validation Method.
	 */
	public static boolean validate(Product product) throws InvalidProductDetailsException {

		/*
		 *  Product Object Validation if the Product Object is "NULL" It will Throw an Exception.
		 */
		if (product == null) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_NULL);
		}

		/*
		 * Invoked Validate Product Title Method.
		 */
		validateProductTitle(product.getProductTitle());
		
		/*
		 * Invoked Validate Product Price Method.
		 */
		validateProductPrice(product.getProductPrice());
		
		/*
		 * Invoked Validate Product Image Link Method.
		 */
		validateProductImageLink(product.getProductImage());
		
		/*
		 * Invoked Validate Store Id Method.
		 */
		validateStoreId(product.getStoreId());
		
		return true;

	}

	
	public static boolean validateProductTitle(String productTitle) throws InvalidProductDetailsException {

		/*
		 * Product Title Validation If the Title is Null or Empty Exception Will Throw
		 * otherwise it will check other Condition.
		 */
		if (productTitle == null || "".equals(productTitle.trim())) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_TITLE);
		}

		return true;

	}

	public static boolean validateProductPrice(double price) throws InvalidProductDetailsException {

		/*
		 *  Assigning the product minimum price
		 */
		int minPrice = 900;

		/*
		 * Product Price Validation If the Product Price is less then 900 It will throw
		 * the Exception.
		 */
		if (price < minPrice) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_PRICE);
		}

		return true;

	}

	public static boolean validateProductImageLink(String url) throws InvalidProductDetailsException {

		/*
		 * Product Image URL Validation. If the product Image URL is Null or Empty It
		 * will throw the Exception.
		 */

		if (url == null || "".equals(url.trim())) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL);
		}

		/*
		 *  Image URL Regex Pattern Validate Code
		 */
		boolean isMatch = Pattern.matches("(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg|webp))", url);

		/*
		 *  If the patter is not Matched it will throw the Exception Otherwise it's True.
		 */
		if (!isMatch) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_IMAGE_LOGO_URL);
		}

		return true;

	}
	
	public static boolean validateStoreId(int storeId) throws InvalidProductDetailsException {
		
		/*
		 *  Assigning a invalid Store ID
		 */
		int invalidId = 0;
		
		/*
		 * If the Store Id is Must have more then then ZERO. If Store Id Have More then
		 * Zero it will return true. OtherWise it throw Exception.
		 */
		if (storeId <= invalidId) {
			throw new InvalidProductDetailsException(StoreValidatorErrors.INVALID_STORE_ID);
		}
		
		return true;
		
	}

	/*
	 *  Product ID Validation Method.
	 */
	public boolean validateProductId(int productId) throws InvalidProductDetailsException {

		/*
		 *  Assigning a invalid product Id
		 */
		int invalidId = 0;
		
		/*
		 *  If the product Id is ZERO or less then Zero it will throw the Exception.
		 *  Otherwise it'll return true.
		 */
		if (productId <= invalidId) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_ID);
		}

		return true;

	}

}
