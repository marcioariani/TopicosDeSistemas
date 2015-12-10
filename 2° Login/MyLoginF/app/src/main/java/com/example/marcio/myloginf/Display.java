package com.example.marcio.myloginf;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by marcio on 13/11/2015.
 */
public class Display extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
        Button voltar = (Button)findViewById(R.id.sair);
        voltar.setOnClickListener(this);
    }

    public void onClick(View v){
        finish();
    }
}
