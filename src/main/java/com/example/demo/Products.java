package com.example.demo;

public class Products {

	private String title;
	private double price;
    private String category;
	private String description;

	public Products(String title, double price, String category, String description) {
		this.title = title;
		this.price = price;
        this.category = category;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}
	
    public void setPrice(double price) {
		this.price = price;
	}
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
