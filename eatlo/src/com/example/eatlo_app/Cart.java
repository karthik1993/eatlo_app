package com.example.eatlo_app;

public class Cart {
	
	String titlle;
	int price;
	int quantity;
	public Cart(String title,int price)
	{
		
		this.price=price;
		this.quantity=1;
		this.titlle=title;
	}
	public void update_quantity()
	{
		quantity+=1;
	}
	public void dec_quantity()
	{
		quantity-=1;
	}
	public String getTitlle() {
		return titlle;
	}
	public void setTitlle(String titlle) {
		this.titlle = titlle;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
