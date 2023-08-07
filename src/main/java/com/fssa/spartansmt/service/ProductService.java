package com.fssa.spartansmt.service;

import com.fssa.spartansmt.dao.ProductDao;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.model.Product;
import com.fssa.spartansmt.validator.ProductValidator;

/*
 * @author MathankumarNagarajan
 */
 
public class ProductService {

	/*
	 *  Add Product Service Method
	 */
	public static boolean addProduct(Product product) throws InvalidProductDetailsException, DAOException {

		/*
		 * Passing a Product Object in the Product Validator Method. This method
		 * validate the Product Obj If the Product Object Is Valid it should send the
		 * product Object to the Add Product Dao Layer otherwise it will throw the
		 * Exception.
		 */
		if (ProductValidator.validate(product)) {
			ProductDao.addProduct(product);
		}

		return true;

	}

	/*
	 *  Update Product Service Method
	 */
	public static boolean updateProduct(Product product) throws InvalidProductDetailsException, DAOException {

		/*
		 * Here Validating a Product Object Through the Product Validator if the Product
		 * Object is Valid It should send the Product object to the Update Product Dao
		 * Layer. Otherwise It will throw the Exception.
		 */
		if (ProductValidator.validate(product)) {
			ProductDao.updateProduct(product);
		}

		return true;

	}

	/*
	 *  Delete Product Method
	 */
	public static boolean deleteProduct(int productId) throws InvalidProductDetailsException, DAOException {

		/*
		 *  Created a new Product Validator Object
		 */
		ProductValidator pv = new ProductValidator();

		/*
		 * Here Validating a product Id through the product validator if the product id
		 * is valid. It should send the product id to delete product dao method that
		 * method delete the object in the database.
		 */
		if (pv.validateProductId(productId)) {
			ProductDao.deleteProduct(productId);
		}

		return true;

	}

	/*
	 *  Get All Product Details Method It Should have any parameter
	 *  to validate the object or Id. So this Method Dirtily call 
	 *  the Dao Layer Method.
	 */
	public boolean getAllProductDetails() throws DAOException {

		/*
		 *  Creating a Product Dao Object
		 */
		ProductDao pd = new ProductDao();

		/*
		 *  Accessing the getAllProductDetails Method through the Product Dao Object.
		 */
		pd.getAllProductDetails();
		return true;

	}

}
