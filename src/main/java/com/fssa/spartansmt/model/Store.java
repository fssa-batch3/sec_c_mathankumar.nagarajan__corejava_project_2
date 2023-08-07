package com.fssa.spartansmt.model;

/*
 * @author MathankumarNagarajan
 * Model object for representing Store in the application
 * */

public class Store {
	
	private int id;
	private String name;
	private String category;
	private String storeLogoLink;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStoreLogoLink() {
		return storeLogoLink;
	}
	public void setStoreLogoLink(String imageLink) {
		this.storeLogoLink = imageLink;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Store(String name, String category, String storeLogoLink) {
		this.name = name;
		this.category = category;
		this.storeLogoLink = storeLogoLink;
	}
	
	public Store() {
		
	}
	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", category=" + category + ", storeLogoLink=" + storeLogoLink
				+ "]";
	}
	
	
	
}
