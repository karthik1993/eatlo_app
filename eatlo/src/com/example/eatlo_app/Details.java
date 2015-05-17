package com.example.eatlo_app;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Details extends Activity {
	TabActivity tabs;
	boolean doubleBackToExitPressedOnce = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		tabs = (TabActivity) getParent();
	    
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		 
		this.doubleBackToExitPressedOnce = false;
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
		
		   
		   tabs.getTabWidget().getChildAt(1).setEnabled(true);
		   tabs.getTabWidget().getChildAt(2).setEnabled(false);
		  tabs.getTabHost().setCurrentTab(1);
	}

}
