package com.fssa.spartansmt.model;

/*
 * @author MathankumarNagarajan
 * 
 * Model object for representing Store in the application.
 * */

public class Store {
	
	/*
	 * Create Variables
	 * id as a int data type.
	 * name as a String data type.
	 * category as a String data type.
	 * store Logo Link as a String data type.
	 */
	private int id;
	private String name;
	private String category;
	private String storeLogoLink;
	
	/*
	 * getName Method it should return the name.
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * setName Method it should get the value
	 * through the parameter and assign the value for name.
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * getCategory Method will return the category.
	 */
	public String getCategory() {
		return category;
	}
	
	/*
	 * setCategory Method should get category value
	 * through the parameter and it will assign the 
	 * value to category variable
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/*
	 * getStoreLogoLink Method will return 
	 * the storeLogoLink value
	 */
	public String getStoreLogoLink() {
		return storeLogoLink;
	}
	
	/*
	 * setStoreLogoLink Method will get a value
	 * through the parameter and it will assign the 
	 * value to storeLogoLink
	 */
	public void setStoreLogoLink(String imageLink) {
		this.storeLogoLink = imageLink;
	}
	
	/*
	 * getId Method will return the id value
	 */
	public int getId() {
		return id;
	}
	
	/*
	 * setId Method will get the value
	 * through the parameter and assign the 
	 * value to the id variable
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * Create a new Store Constructor 
	 * It will Get name, category, storeLogoLink through the 
	 * parameter and it will assign the values to that variables.
	 */
	public Store(String name, String category, String storeLogoLink) {
		this.name = name;
		this.category = category;
		this.storeLogoLink = storeLogoLink;
	}
	
	/*
	 * Create a Default Constructor 
	 */
	public Store() {
		
	}
	
	/*
	 * Override toString Class
	 * This Method will return the Store Object String. 
	 */
	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", category=" + category + ", storeLogoLink=" + storeLogoLink
				+ "]";
	}
	
}
