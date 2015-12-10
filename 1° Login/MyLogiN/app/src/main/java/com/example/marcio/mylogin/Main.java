package com.example.marcio.mylogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    private static EditText login;
    private static EditText pass;
    private static Button click;
    private static TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();
    }

    public void LoginButton(){

        click = (Button)findViewById(R.id.click);
        login = (EditText)findViewById(R.id.login);
        pass = (EditText)findViewById(R.id.pass);
        ans = (TextView)findViewById(R.id.ans);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (login.getText().toString().equals("marcio") && pass.getText().toString().equals("maf360")) {
                        Toast.makeText(Main.this, "User and Password is correct", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent("com.example.marcio.mylogin.Main2");
                        startActivity(intent);
                    } else {
                        Toast.makeText(Main.this, "User or Password ins't correct", Toast.LENGTH_SHORT).show();
                        ans.setText("Login ou Senha incorreto. Tente novamente!");
                    }
                }
        });

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
