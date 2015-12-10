package com.example.marcio.tb001androidmenu.app;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by marcio on 28/11/2015.
 */
public class ViewHelper {

    public static ArrayAdapter<String> createArrayAdapter(Context ctx, Spinner spinner){
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(arrayAdapter);
        return arrayAdapter;
    }

}
