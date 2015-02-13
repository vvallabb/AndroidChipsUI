package com.example.vvallabb.vasandroidchips;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChipsMultiAutoCompleteTextview ch = (ChipsMultiAutoCompleteTextview) findViewById(R.id.chipsMultiAutoCompleteTextview1);

        String[] countries = getResources().getStringArray(R.array.country);
        TypedArray imgs = getResources().obtainTypedArray(R.array.flags);


        ArrayList<ChipsItem> arrCountry = new ArrayList<ChipsItem>();


        for (int i = 0; i < countries.length; i++) {
            arrCountry.add(new ChipsItem(countries[i], imgs.getResourceId(i, -1)));
            Log.i("Main Activity", arrCountry.get(i).getTitle() + " = " + arrCountry.get(i).getImageid());
        }

        Log.i("MainActivity", "Array :" + arrCountry.size());

        ChipsAdapter chipsAdapter = new ChipsAdapter(this, arrCountry);
        ch.setAdapter(chipsAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
