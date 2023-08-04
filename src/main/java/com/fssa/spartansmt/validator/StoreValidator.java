package com.fssa.spartansmt.validator;

import java.util.regex.Pattern;

import com.fssa.spartansmt.errors.StoreValidatorErrors;
import com.fssa.spartansmt.exception.InvalidStoreDetailsException;
import com.fssa.spartansmt.model.Store;

public class StoreValidator {

	public static boolean validate(Store store) throws InvalidStoreDetailsException {

		// Store Object Validation If the Store Obj is "NULL" It will Throw the Exception.
		if (store == null) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_STORE_NULL);
		}

		// Store Name validation If the Store Name is "NULL" or Empty it will throw the Exception.
		if (store.getName() == null || "".equals(store.getName().trim())) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_ATTRIBUTES);
		}

		// Store Category validation If the Store Category is "NULL" or Empty it will throw the Exception.
		if (store.getCategory() == null || "".equals(store.getCategory().trim())) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_ATTRIBUTES);
		}

		// Store image link validation If the Store Image URL is "NULL" or Empty it will throw the Exception.
		if (store.getStoreLogoLink() == null || "".equals(store.getStoreLogoLink().trim())) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_ATTRIBUTES);
		}
		
		// Image URL Regex Pattern Validate Code
		boolean isMatch = Pattern.matches("(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))", store.getStoreLogoLink());  
		
		// If the patter is not Matched it will throw the Exception Otherwise it's True.
		if(!isMatch) {
			// TODO - Write a JUnit to Handle below Exception
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_STORE_IMAGE_LOGO_URL);
		}

		return true;
	}
	
	public boolean validateId(int storeId) throws InvalidStoreDetailsException {
		
		// Store ID validator If the Must have more the Zero it will return true otherwise it'll throw Exception.
		if(storeId <= 0) {
			// TODO - Write a JUnit to Handle below Exception
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_STORE_ID);
		}
		
		return true;
		
	}

}
