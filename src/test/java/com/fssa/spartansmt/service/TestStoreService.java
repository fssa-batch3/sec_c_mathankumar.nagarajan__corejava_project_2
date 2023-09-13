package com.fssa.spartansmt.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidStoreDetailsException;
import com.fssa.spartansmt.logger.Logger;
import com.fssa.spartansmt.model.Store;

class TestStoreService {

	
	public static List<Store> listStore(){
		
		List<Store> storeList = new ArrayList<>();
		
		storeList.add(new Store("Nike", "Shoes Shop", "https://iili.io/HWXkdkx.png"));
		storeList.add(new Store("ivenus", "Apple Premium Reseller", "https://iili.io/HWXkBB1.jpg"));
		storeList.add(new Store("SS Beauty Shop", "Beauty Shop", "https://iili.io/HWXkHdb.jpg"));
		storeList.add(new Store("Lenskart", "Specse Shop", "https://iili.io/HWXkKhB.jpg"));
		storeList.add(new Store("Charles & Keith", "Bags & Luggage", "https://iili.io/HWXep1e.png"));
		
		
		storeList.add(new Store("Vero Moda", "Fashion Dress For Women", "https://iili.io/HWXeyru.png"));
		storeList.add(new Store("Poorvika", "Mobile Shop", "https://iili.io/HWXknrg.png"));
		storeList.add(new Store("MAC", "Beauty Products", "https://iili.io/HWXk2mQ.gif"));
		storeList.add(new Store("Jack & Zone", "Men's Fashion", "https://iili.io/HWXemB9.png"));
		storeList.add(new Store("Label Ritu Kumar", "Designer Wear", "https://iili.io/HWXkJ7j.jpg"));

		
		return storeList;
		
	}
	
	
	@Test
	void testValidateAddStore() throws DAOException, InvalidStoreDetailsException {
		Store s1 = new Store("Nike", "Shoes Shop", "https://iili.io/HWXknrg.png");
		StoreService ss = new StoreService();
		Assertions.assertTrue(ss.addStore(s1));
	}
	
	@Test 
	void testValidateUpdateStore() throws InvalidStoreDetailsException, DAOException {
		Store s1 = new Store();
		s1.setId(12);
		s1.setName("MAC");
		s1.setCategory("Beauty Products");
		s1.setStoreLogoLink("https://iili.io/HWXk2mQ.gif");
		
		Assertions.assertTrue(StoreService.updateStore(s1));
	}
	
	@Test
	void testValidateDeleteStore() throws InvalidStoreDetailsException, DAOException {
		Store s2 = new Store();
		s2.setId(13);
		Assertions.assertTrue(StoreService.deleteStore(s2.getId()));
	}
	
	
	@Test
	void testValidateGetAllStoreDetails() throws DAOException{
		try {
			List<Store> storeList = StoreService.getAllStoreDetails();
			for(Store ele : storeList) {
				Logger.info(ele);
			}
		}catch(DAOException ex) {
			fail("Get Store Detials Methos Is Failded");
		}
	}

	
}
