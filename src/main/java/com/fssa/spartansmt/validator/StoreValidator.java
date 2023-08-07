package com.fssa.spartansmt.validator;

import java.util.regex.Pattern;

import com.fssa.spartansmt.errors.StoreValidatorErrors;
import com.fssa.spartansmt.exception.InvalidStoreDetailsException;
import com.fssa.spartansmt.model.Store;

public class StoreValidator {

	public static boolean validate(Store store) throws InvalidStoreDetailsException {

		/*
		 *  Store Object Validation If the Store Obj is "NULL" It will Throw the Exception.
		 */
		if (store == null) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_STORE_NULL);
		}
		
		/*
		 * Name Validator Method
		 */
		validateName(store.getName());
		
		/*
		 * Store Category Validate Method
		 */
		validateCategory(store.getCategory());
		
		/*
		 *  Store logo url validate Method
		 */
		validateStoreLogoUrl(store.getStoreLogoLink());

		return true;
	}

	public static boolean validateName(String name) throws InvalidStoreDetailsException {

		/*
		 *  Store Name validation If the Store Name is "NULL" or Empty it will throw the Exception.
		 */
		if (name == null || "".equals(name.trim())) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_ATTRIBUTES);
		}

		return true;

	}

	public static boolean validateCategory(String category) throws InvalidStoreDetailsException {

		/*
		 *  Store Category validation If the Store Category is "NULL" or Empty it will
		 *  throw the Exception.
		 */
		if (category == null || "".equals(category.trim())) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_ATTRIBUTES);
		}

		return true;

	}

	public static boolean validateStoreLogoUrl(String url) throws InvalidStoreDetailsException {

		/*
		 *  Store image link validation If the Store Image URL is "NULL" or Empty it will
		 *  throw the Exception.
		 */
		if (url == null || "".equals(url.trim())) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_ATTRIBUTES);
		}

		/*
		 *  Image URL Regex Pattern Validate Code
		 */
		boolean isMatch = Pattern.matches("(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|svg|webp))", url);

		/*
		 *  If the patter is not Matched it will throw the Exception Otherwise it's True.
		 */
		if (!isMatch) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_STORE_IMAGE_LOGO_URL);
		}

		return true;

	}

	public boolean validateId(int storeId) throws InvalidStoreDetailsException {
		
		/*
		 *  Assigning invalid store Id as a number
		 */
		int invalidId = 0;

		/*
		 *  Store ID validator If the Must have more the Zero it will return true
		 *  otherwise it'll throw Exception.
		 */
		if (storeId <= invalidId) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_STORE_ID);
		}

		return true;

	}

}
