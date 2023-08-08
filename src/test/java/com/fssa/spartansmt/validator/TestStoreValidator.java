package com.fssa.spartansmt.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.StoreValidatorErrors;
import com.fssa.spartansmt.exception.InvalidStoreDetailsException;
import com.fssa.spartansmt.model.Store;

public class TestStoreValidator {
	
	@Test
	public void testValidateStore() throws InvalidStoreDetailsException {
		Store store = new Store("Nike", "Shoes Shop", "https://iili.io/HkeiZmb.webp");
		Assertions.assertTrue(StoreValidator.validate(store));
	}
	
	@Test
	public void testValidateStoreNull() {
		try {
			StoreValidator.validate(null);
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_STORE_NULL, ex.getMessage());
		}
	}
	
	@Test
	public void testValidateStoreName() {
		Store store = new Store(null, "Shoes Shop", "https://iili.io/HWXkdkx.png");		
		try {
			StoreValidator.validate(store);
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_ATTRIBUTES, ex.getMessage());
		}
	}
	
	@Test
	public void testValidateStoreCategory() {
		Store store = new Store("Nike", null, "https://iili.io/HWXkdkx.png");		
		try {
			StoreValidator.validate(store);
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_ATTRIBUTES, ex.getMessage());
		}
	}
	
	@Test
	public void testValidateStoreImageLink() {
		Store store = new Store("Nike", "Shoes Shop", null);		
		try {
			StoreValidator.validate(store);
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_ATTRIBUTES, ex.getMessage());
		}
	}
	
	@Test 
	public void testInvalidStoreImageURL() {
		
		Store store = new Store("Nike", "Shoes Shop", "https://iili.io/HWXkdkx");
		try {
			StoreValidator.validate(store);
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_STORE_IMAGE_LOGO_URL, ex.getMessage());
		}
		
	}
	
	@Test 
	public void testInvalidStoreId() {
		
		try {
			StoreValidator sv = new StoreValidator();
			sv.validateId(-1);
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_STORE_ID, ex.getMessage());
		}
		
	}
	
	
	
	// Empty String
	
	@Test
	public void testValidateEmptyStoreName() {
		
		Store store = new Store();
		store.setId(1);
		store.setName("");
		store.setCategory("Shoes Shop");
		store.setStoreLogoLink("https://iili.io/HWXkdkx.png");
		
		try {
			StoreValidator.validate(store);
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_ATTRIBUTES, ex.getMessage());
		}
	}
	
	@Test
	public void testValidateEmptyStoreCategory() {
		Store store = new Store("Nike", "", "https://iili.io/HWXkdkx.png");	
		try {
			StoreValidator.validate(store);
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_ATTRIBUTES, ex.getMessage());
		}
	}
	
	@Test
	public void testValidateEmptyStoreImageLink() {
		Store store = new Store("Nike", "Shoes Shop", "");		
		try {
			StoreValidator.validate(store);
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_ATTRIBUTES, ex.getMessage());
		}
	}

	@Test
	public void testValidateStoreId() throws InvalidStoreDetailsException {
		StoreValidator storeValidator = new StoreValidator();
		Store store = new Store();
		store.setId(1);
		Assertions.assertTrue(storeValidator.validateId(store.getId()));
	}
	


}
