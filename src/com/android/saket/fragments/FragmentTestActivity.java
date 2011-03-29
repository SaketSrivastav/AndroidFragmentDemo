package com.android.saket.fragments;

import com.example.fragmenttest.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentTestActivity extends FragmentActivity implements OnItemClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ListView l = (ListView) findViewById(R.id.number_list);
        ArrayAdapter<String> magzTitles = new ArrayAdapter<String>(getApplicationContext(),
        		android.R.layout.simple_list_item_1, R.array.magz_titles);
        l.setAdapter(magzTitles);
        l.setOnItemClickListener(this);
    }

	/**
	 * Called when a number gets clicked
	 */
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		Fragment f = new TestFragment(position+1);
    	
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.the_frag, f);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
	}
}