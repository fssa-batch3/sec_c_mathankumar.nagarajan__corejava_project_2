package com.fssa.spartansmt.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.exception.ServiceException;
import com.fssa.spartansmt.logger.Logger;
import com.fssa.spartansmt.model.Product;
import com.fssa.spartansmt.model.Store;

class TestProductService {

	Product demoProduct() {

		Product p1 = new Product();
		p1.setProductId(120);
		p1.setProductTitle("Teddy Bear");
		p1.setProductPrice(9199);
		p1.setProductImage("https://assets.flowersnfruits.com/uploads/product-pics/1631950556_blue-teddy.jpg");
		p1.setStoreId(2);
		p1.setUploadedDate(LocalDate.now());

		return p1;

	}

	public static List<Product> listOfProduct() {
		List<Product> productList = new ArrayList<>();

		productList.add(new Product("Mens Air Zoom Vomero 15 Running Shoe", 10009.53, "https://iili.io/HkeiZmb.webp", 1,
				LocalDate.now()));
		productList.add(new Product("Men's Ultra Light Running <br>and Training Shoes", 4999,
				"https://iili.io/HkeiQku.webp", 1, LocalDate.now()));
		productList.add(new Product("Men's Running Shoe<br>Bacca Bucci", 5230, "https://iili.io/HkeiDIj.webp", 1,
				LocalDate.now()));
		productList.add(new Product("Mens Slip-on Premium Comfy-fit Sneaker", 4536.34, "https://iili.io/HkeiL7e.webp",
				1, LocalDate.now()));
		productList.add(new Product("Men's Wonder-13 Sports Running Shoes", 5484.92, "https://iili.io/Hkeis29.webp", 1,
				LocalDate.now()));
		productList.add(new Product("Mens Ultimate Ease Range Walking Shoe", 3299, "https://iili.io/Hkeibhx.webp", 1,
				LocalDate.now()));

		productList.add(new Product("Apple iPhone 14 Pro", 120000, "https://iili.io/HyZvUFt.webp", 2, LocalDate.now()));
		productList.add(new Product("Apple iPhone 14", 100009, "https://iili.io/HyZv69s.webp", 2, LocalDate.now()));
		productList.add(new Product("Apple iPhone 13 Pro", 87000, "https://iili.io/HyZvPAG.webp", 2, LocalDate.now()));
		productList.add(new Product("Apple iPhone 12", 23000, "https://iili.io/HyZviNf.webp", 2, LocalDate.now()));
		productList.add(new Product("Apple iPhone 13", 76000, "https://iili.io/HyZvst4.webp", 2, LocalDate.now()));

		return productList;
	}

//	@Test
//	void addProductForDemo() throws InvalidProductDetailsException, DAOException {
//
//		TestProductService tps = new TestProductService();
//		List<Product> productList = listOfProduct();
//		for (Product product : productList) {
//			Assertions.assertTrue(ProductService.addProduct(product));
//		}

//	}

	@Test
	void testValidAddProduct() {

		TestProductService tps = new TestProductService();
		try {
			Assertions.assertTrue(ProductService.addProduct(tps.demoProduct()));
		} catch (InvalidProductDetailsException | DAOException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testValidUpdateProduct() throws InvalidProductDetailsException, DAOException {
		TestProductService tps = new TestProductService();
		Assertions.assertTrue(ProductService.updateProduct(tps.demoProduct()));
	}

	@Test
	void testValidDeleteProduct() throws InvalidProductDetailsException, DAOException {
		Assertions.assertTrue(ProductService.deleteProduct(6));
	}

	@Test
	void testValidGetAllProductDetails() throws DAOException {
		ProductService ps = new ProductService();
		try {
			List<Product> productList = ps.getAllProductDetails();
			for (Product ele : productList) {
				Logger.info(ele);
			}
		} catch (DAOException ex) {
			fail("Get Product Detials Methos Is Failded");
		}
	}

	@Test
	void testValidGetAllProductDetailsByStoreId() throws DAOException {
		ProductService ps = new ProductService();
		try {
			List<Product> productList = ps.getAllProductsByStoreId(demoProduct().getStoreId());
			for (Product ele : productList) {
				Logger.info(ele);
			}
		} catch (DAOException ex) {
			fail("Get Product Detials Methos Is Failded");
		}
	}

	@Test
	void testValidGetProductById() throws InvalidProductDetailsException, DAOException {
		ProductService productSer = new ProductService();
		try {
			Product product = productSer.getProductById(demoProduct().getProductId());
			Logger.info(product);
		} catch (ServiceException e) {
			fail("Get Product By Id Method Is Failded");
		}
	}

}
