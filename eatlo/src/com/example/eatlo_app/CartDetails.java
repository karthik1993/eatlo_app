package com.example.eatlo_app;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class CartDetails extends Activity {
	//LinearLayout l;
	List<Cart> data;
	TableLayout t1;
	int[]total;
	int j=0;
	TextView t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cart);
		Log.i("s", "ssss");
		
		TableLayout t1 = (TableLayout) findViewById(R.id.tablelayout);
		t=(TextView) findViewById(R.id.total);
		TableRow tr_head = new TableRow(this);
		tr_head.setBackgroundColor(Color.GRAY);
		tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
	    tr_head.setGravity(Gravity.CENTER);
	   // tr_head.setWeightSum(1f);
		
		TextView sno = new TextView(this);
        sno.setText("S.No.");
        sno.setTextColor(Color.WHITE);
        sno.setPadding(5, 5, 5, 5);
        tr_head.addView(sno);// add the column to the table row here

        TextView name = new TextView(this);
        name.setText("Name"); // set the text for the header 
        name.setTextColor(Color.WHITE); // set the color
        name.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(name);
        
        TextView rate = new TextView(this);
        rate.setText("Rate"); // set the text for the header 
        rate.setTextColor(Color.WHITE); // set the color
        rate.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(rate);
        
        TextView quan = new TextView(this);
        quan.setText("Quantity"); // set the text for the header 
        quan.setTextColor(Color.WHITE); // set the color
        quan.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(quan);
        
        TextView price = new TextView(this);
        price.setText("Total"); // set the text for the header 
        price.setTextColor(Color.WHITE); // set the color
        price.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(price);
        
        t1.addView(tr_head, new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
           
		data=ListFoodAdapter.getlist();
		
		total=new int[data.size()];
	//	l=(LinearLayout) findViewById(R.id.linearlayout);
		for(int i=1;i<=data.size();++i)
		{
			
			TableRow dt = new TableRow(this);
			dt.setBackgroundColor(Color.WHITE);
			dt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
		    dt.setGravity(Gravity.CENTER);
			Cart fs=data.get(i-1);
		
			int q=fs.getQuantity();
			int rates=fs.getPrice();
			int pr=q*rates;
			String pric=Double.toString(pr);
			total[j]=pr;
			j++;
			
			TextView sno1 = new TextView(this);
	        sno1.setText(""+i);
	        sno1.setTextColor(Color.BLACK);
	        sno1.setPadding(5, 5, 5, 5);
	        sno1.setGravity(Gravity.CENTER);
	        dt.addView(sno1);// add the column to the table row here

	        TextView name1 = new TextView(this);
	        name1.setText(fs.getTitlle()); // set the text for the header 
	        name1.setTextColor(Color.BLACK); // set the color
	        name1.setPadding(5, 5, 5, 5); // set the padding (if required)
	        dt.addView(name1);
	        
	        TextView rate1 = new TextView(this);
	        rate1.setText(Double.toString(rates)); // set the text for the header 
	        rate1.setTextColor(Color.BLACK); // set the color
	        rate1.setPadding(5, 5, 5, 5); // set the padding (if required)
	        dt.addView(rate1);
	        
	        TextView quan1 = new TextView(this);
	        quan1.setText(""+q); // set the text for the header 
	        quan1.setTextColor(Color.BLACK); // set the color
	        quan1.setPadding(5, 5, 5, 5); // set the padding (if required)
	        quan1.setGravity(Gravity.CENTER);
	        dt.addView(quan1);
	        
	        TextView price1 = new TextView(this);
	        price1.setText(pric); // set the text for the header 
	        price1.setTextColor(Color.BLACK); // set the color
	        price1.setPadding(5, 5, 5, 5); // set the padding (if required)
	        dt.addView(price1);
			
	        t1.addView(dt, new TableLayout.LayoutParams(
	                LayoutParams.WRAP_CONTENT,
	                LayoutParams.WRAP_CONTENT));
			//String res="\t"+i+"\t\t"+fs.getTitlle()+"\t\t"+q+"\t\t\t\t"+pric;
			//t.setText(res);
			//l.addView(t);
			
					}
		int sum=0;
		for(int i=0;i<total.length;++i)
		{
			sum+=total[i];
		}
		t.setText("Rs "+sum);
		
		
		
	}

}
