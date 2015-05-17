package com.example.eatlo_app;

public class Food {
	private int drawableId;
	private String title;
	private int price;
	private int decrement;
	private int incremenet;
	private int quan;
	
	public Food(int drawableId, String title,  int price,int decrement,int incremenet,int quan) {
		super();
		this.drawableId = drawableId;
		this.title = title;
		this.price = price;
		this.decrement=decrement;
		this.incremenet=incremenet;
		this.quan=quan;

}

	public int getQuan() {
		return quan;
	}
	public void decquan()
	{
		quan-=1;
	}
	public void incquan()
	{
		quan+=1;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}

	public int getDecrement() {
		return decrement;
	}

	public void setDecrement(int decrement) {
		this.decrement = decrement;
	}

	public int getIncremenet() {
		return incremenet;
	}

	public void setIncremenet(int incremenet) {
		this.incremenet = incremenet;
	}

	public int getDrawableId() {
		return drawableId;
	}

	public void setDrawableId(int drawableId) {
		this.drawableId = drawableId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}