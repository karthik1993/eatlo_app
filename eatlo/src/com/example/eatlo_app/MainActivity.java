package com.example.eatlo_app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.os.Build;

public class MainActivity extends TabActivity {

	TabHost th;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		th=(TabHost) findViewById(android.R.id.tabhost);
		TabSpec tab1 = th.newTabSpec("First Tab");
	    TabSpec tab2 = th.newTabSpec("Second Tab");
	    TabSpec tab3 = th.newTabSpec("Third Tab");
	    tab1.setIndicator("\t\t1\nLocation");
	    tab1.setContent(new Intent(this,Location.class));

	    tab2.setIndicator("\t2\nOrder");
	    tab2.setContent(new Intent(this,Order.class));

	    tab3.setIndicator("\t3\nDetails");
	    tab3.setContent(new Intent(this,Details.class));

	    th.addTab(tab1);
	    th.addTab(tab2);
	    th.addTab(tab3);
	   th.getTabWidget().getChildAt(1).setEnabled(false);
	    th.getTabWidget().getChildAt(2).setEnabled(false);
	    th.setCurrentTab(0);

		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	

}
