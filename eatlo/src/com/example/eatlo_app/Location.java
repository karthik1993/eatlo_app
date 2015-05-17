package com.example.eatlo_app;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

public class Location extends Activity {
	ListView lv;
	boolean doubleBackToExitPressedOnce = false;
	TabActivity tabs;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.location);
	ArrayAdapter<String>ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
			getResources().getStringArray(R.array.location));
	lv=(ListView) findViewById(R.id.listView1);
	lv.setAdapter(ad);
	lv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			String s=parent.getItemAtPosition(position).toString();
			/*Intent data=new Intent();
			data.setAction("com.example.eatlo_app.A_CUSTOM_INTENT");
			data.putExtra("cal", s);
			sendBroadcast(data);*/
			getParent().getIntent().putExtra("val",s);
		
			TabActivity tabs = (TabActivity) getParent();
			tabs.getTabWidget().getChildAt(0).setEnabled(false);
		    tabs.getTabWidget().getChildAt(1).setEnabled(true);
		    tabs.getTabWidget().getChildAt(2).setEnabled(false);
		    tabs.getTabHost().setCurrentTab(1);
		    
		    
			//Toast.makeText(getApplicationContext(), s, 0).show();
			
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
public void onBackPressed() {
	// TODO Auto-generated method stub
	if (doubleBackToExitPressedOnce) {
        super.onBackPressed();
        return;
    }
	this.doubleBackToExitPressedOnce = true;
    Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_LONG).show();
	
}
}
