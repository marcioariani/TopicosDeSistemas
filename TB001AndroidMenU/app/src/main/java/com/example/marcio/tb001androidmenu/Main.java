package com.example.marcio.tb001androidmenu;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.marcio.tb001androidmenu.app.MessageBox;
import com.example.marcio.tb001androidmenu.database.DataBase;
import com.example.marcio.tb001androidmenu.dominio.RepositorioContato;
import com.example.marcio.tb001androidmenu.dominio.entidades.Contato;

public class Main extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{


    private ImageButton click;
    private EditText pesq;
    private ListView lista;
    private ArrayAdapter<Contato> adpContatos;

    private DataBase database;
    private SQLiteDatabase conn;
    private RepositorioContato repositorioContato;
    private FiltraDados filtraDados;
    public static final String PAR_CONTATO = "CONTATO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (ImageButton)findViewById(R.id.btnadd);
        pesq = (EditText)findViewById(R.id.edpesq);
        lista = (ListView)findViewById(R.id.lista);

        click.setOnClickListener(this);
        lista.setOnItemClickListener(this);
        try {

            database = new DataBase(this);
            conn = database.getWritableDatabase();
            repositorioContato = new RepositorioContato(conn);

            adpContatos = repositorioContato.buscaContatos(this);

            lista.setAdapter(adpContatos);

            filtraDados = new FiltraDados(adpContatos);
            pesq.addTextChangedListener(filtraDados);

        }catch (SQLException ex){

            MessageBox.show(this, "Erro", "Erro ao criar o banco" + ex.getMessage());

        }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(conn != null){
            conn.close();
        }

    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, Main2.class);
        startActivityForResult(it, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        adpContatos = repositorioContato.buscaContatos(this);
        filtraDados.setArrayAdapter(adpContatos);
        lista.setAdapter(adpContatos);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Contato contato = adpContatos.getItem(position);
        Intent it = new Intent(this, Main2.class);
        it.putExtra(PAR_CONTATO, contato);
        startActivityForResult(it, 0);

    }

    private class FiltraDados implements TextWatcher {

        private ArrayAdapter<Contato> arrayAdapter;
        private FiltraDados(ArrayAdapter<Contato> arrayAdapter){

            this.arrayAdapter = arrayAdapter;

        }

        public void setArrayAdapter(ArrayAdapter<Contato> arrayAdapter){

            this.arrayAdapter = arrayAdapter;

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {



        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            arrayAdapter.getFilter().filter(s);

        }

        @Override
        public void afterTextChanged(Editable s) {



        }
    }

}
