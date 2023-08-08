package com.fssa.spartansmt.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.StoreValidatorErrors;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidStoreDetailsException;
import com.fssa.spartansmt.model.Store;

public class TestStoreDao {
	
	Store storeDetails() {
		
		Store s = new Store();
		s.setId(14);
		s.setName("Vero Moda");
		s.setCategory("Fashion Dress For Women");
		s.setStoreLogoLink("https://iili.io/HWXeyru.png");
		return s;
		
	}
	
	@Test
	void testValidateAddStore() throws DAOException {
		Assertions.assertTrue(StoreDao.addStore(storeDetails()));
	}
	
	@Test
	void testValidateUpdateStore() throws DAOException, InvalidStoreDetailsException {
		Assertions.assertTrue(StoreDao.updateStore(storeDetails()));
	}
	
	@Test
	void testValidateDeleteStore() throws InvalidStoreDetailsException, DAOException {
		Assertions.assertTrue(StoreDao.deleteStore(14));
	}
	
	@Test
	void testValidateGetAllStoreDetails() throws DAOException {
		Assertions.assertTrue(StoreDao.getAllStoreDetails());
	}

	@Test 
	void testInvalidUpdateStoreId() throws DAOException, InvalidStoreDetailsException {
		
		Store sl = new Store();
		sl.setId(0);
		sl.setName("Vero Moda");
		sl.setCategory("Fashion Dress For Women");
		sl.setStoreLogoLink("https://iili.io/HWXeyru.png");
		
		try {
			StoreDao.updateStore(sl);
			Assertions.fail("Invalid Update Store ID Method is failded");
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_STORE_ID, ex.getMessage());
		}
		
	}
	
	@Test 
	void testInvalidDeleteStoreId() throws InvalidStoreDetailsException, DAOException {
		
		try {
			StoreDao.deleteStore(-1);
			Assertions.fail("Invalid Delete Store ID Method is failded");
		}catch(InvalidStoreDetailsException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_STORE_ID, ex.getMessage());
		}
		
	}
	
	
	
}
