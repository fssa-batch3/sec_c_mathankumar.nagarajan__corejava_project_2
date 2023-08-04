package com.fssa.spartansmt.service;

import com.fssa.spartansmt.dao.ProductDao;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.model.Product;
import com.fssa.spartansmt.validator.ProductValidator;

// TODO-Write Comments

public class ProductService {

	public static boolean addProduct(Product product) throws InvalidProductDetailsException, DAOException {

		if (ProductValidator.validate(product)) {
			ProductDao.addProduct(product);
		}

		return true;

	}

	public static boolean updateProduct(Product product) throws InvalidProductDetailsException, DAOException {

		if (ProductValidator.validate(product)) {
			ProductDao.updateProduct(product);
		}

		return true;

	}
	
	public static boolean deleteProduct(int productId) throws InvalidProductDetailsException, DAOException {
		ProductValidator pv = new ProductValidator();

		if (pv.validateProductId(productId)) {
			ProductDao.deleteProduct(productId);
		}

		return true;

	}
	
	public boolean getAllProductDetails() throws DAOException {
		ProductDao pd = new ProductDao();
		pd.getAllProductDetails();
		return true;
		
	}
	
//	public static void main(String[] args) throws InvalidProductDetailsException, DAOException {
//		
//		Product p = new Product();
//		p.setProduct_id(5);
//		p.setProduct_title("New");
//		p.setProduct_price(1999);
//		p.setProduct_image("https://deploy-preview-1--spartans-market-town.netlify.app/assets/image/stores/items/nike12.jpg");
//		p.setStore_id(1);
		
//		addProduct(p);
//		updateProduct(p);
//		getAllProductDetails();
//		deleteProduct(5);
		
//	}

}
