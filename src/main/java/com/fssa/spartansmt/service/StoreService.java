package com.fssa.spartansmt.service;

import com.fssa.spartansmt.dao.StoreDao;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidStoreDetailsException;
import com.fssa.spartansmt.model.Store;
import com.fssa.spartansmt.validator.StoreValidator;

public class StoreService {
	
	/* Add Store Method It should first Validate the Store Object If the Object validator returned true.
	 * It should send the Object to StoreDao Class Otherwise it will throw the Exception
	*/
	public boolean addStore(Store store) throws DAOException, InvalidStoreDetailsException {

		if (StoreValidator.validate(store)) {
			StoreDao.addStore(store);
		}

		return true;

	}

	/* Update Store Method It should first Validate the Store Object If the Object validator returned true.
	 * It should send the Object to StoreDao Class Otherwise it will throw the Exception
	*/
	public static boolean updateStore(Store store) throws DAOException, InvalidStoreDetailsException {

		if (StoreValidator.validate(store)) {
			StoreDao.updateStore(store);
		}

		return true;

	}

	/*
	 *  Get All Store Details Method Directly it Call the StoreDao.
	 *  Because It Should not have any Parameter to Validate.
	 */
	public static boolean getAllStoreDetails() throws DAOException {

		StoreDao.getAllStoreDetails();

		return true;

	}
	
	/* Delete Store Method It should first Validate the Store ID If the ID validator returned true.
	 * It should Delete the Object From Database Table.
	*/
	public static boolean deleteStore(int storeId) throws DAOException, InvalidStoreDetailsException {
		
		StoreValidator sv = new StoreValidator();
		
		if (sv.validateId(storeId)) {
			StoreDao.deleteStore(storeId);
		}

		return true;

	}

}
