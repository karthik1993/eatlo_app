package com.example.eatlo_app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends Activity implements OnClickListener {
	TextView loc;
	ArrayList<Food> arrayFood;
	ListView listViewFood;
	TextView price;
	Button see_cart;
	Button proceed;
	List<Cart> s1;
	TabActivity tabs;
	boolean doubleBackToExitPressedOnce = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order);
		arrayFood=new ArrayList<Food>();
		
		
		
		
	   // th.getTabWidget().getChildAt(2).setEnabled(false);
		see_cart=(Button) findViewById(R.id.seecart);
		price=(TextView) findViewById(R.id.prices);
		Food first=new Food(R.drawable.first, getResources().getString(R.string.first), 55,R.drawable.minus,R.drawable.plus,0);
		Food second=new Food(R.drawable.second,getResources().getString(R.string.second), 150,R.drawable.minus,R.drawable.plus,0);
		Food third=new Food(R.drawable.third,getResources().getString(R.string.third), 120,R.drawable.minus,R.drawable.plus,0);
		Food fourth=new Food(R.drawable.fourth,getResources().getString(R.string.fourth), 100,R.drawable.minus,R.drawable.plus,0);
		arrayFood.add(first);
		arrayFood.add(second);
		arrayFood.add(third);
		arrayFood.add(fourth);
		listViewFood = (ListView) findViewById(R.id.listView1);
		ListFoodAdapter adapter = new ListFoodAdapter(this, arrayFood);
		listViewFood.setAdapter(adapter);
		
		proceed=(Button) findViewById(R.id.button2);
		loc=(TextView) findViewById(R.id.textView1);
		String s=getParent().getIntent().getStringExtra("val");
		loc.setText(s);
		
		see_cart.setOnClickListener(this);
		
		tabs = (TabActivity) getParent();
	    tabs.getTabWidget().getChildAt(0).setEnabled(false);
	    tabs.getTabWidget().getChildAt(2).setEnabled(false);
	    tabs.getTabWidget().getChildAt(1).setEnabled(false);
	    
	    proceed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(price.getText().equals("Rs 0"))
				{
					Toast.makeText(getApplicationContext(), "Cart is Empty",Toast.LENGTH_LONG).show();
				}
				else
				{
					tabs = (TabActivity) getParent();
					tabs.getTabWidget().getChildAt(2).setEnabled(true);
					tabs.getTabWidget().getChildAt(1).setEnabled(false);
				    tabs.getTabHost().setCurrentTab(2);
				}
				
				
			}
		});
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		this.doubleBackToExitPressedOnce = false;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		if(price.getText().equals("Rs 0"))
		{
			Toast.makeText(getApplicationContext(), "Cart is Empty",Toast.LENGTH_LONG).show();
		}
		else
		{
		Intent i=new Intent(Order.this,CartDetails.class);
		startActivity(i);
		}
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		/*if (doubleBackToExitPressedOnce) {
	        super.onBackPressed();
	        return;
	    }
		this.doubleBackToExitPressedOnce = true;
	    Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_LONG).show();*/
		//tabs = (TabActivity) getParent();
		 tabs.getTabWidget().getChildAt(0).setEnabled(true);
		 tabs.getTabWidget().getChildAt(1).setEnabled(false);
		 tabs.getTabHost().setCurrentTab(0);
		   
	}
	
	

}
