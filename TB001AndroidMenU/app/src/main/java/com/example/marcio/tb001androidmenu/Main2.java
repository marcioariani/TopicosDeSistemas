package com.example.marcio.tb001androidmenu;

import android.app.DatePickerDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.marcio.tb001androidmenu.app.MessageBox;
import com.example.marcio.tb001androidmenu.app.ViewHelper;
import com.example.marcio.tb001androidmenu.database.DataBase;
import com.example.marcio.tb001androidmenu.dominio.RepositorioContato;
import com.example.marcio.tb001androidmenu.dominio.entidades.Contato;
import com.example.marcio.tb001androidmenu.util.DateUtils;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main2 extends AppCompatActivity {

    private EditText ednome;         //1
    private EditText edemail;        //2
    private EditText edtele;         //3
    private EditText edende;         //4
    private EditText eddatas;        //5
    private EditText edgrupos;       //6

    private Spinner spnemail;        //7
    private Spinner spntele;         //8
    private Spinner spnende;         //9
    private Spinner spndatas;        //10

    private ArrayAdapter<String> adpemail;  //11
    private ArrayAdapter<String> adptele;    //12
    private ArrayAdapter<String> adpende;   //13
    private ArrayAdapter<String> adpdatas;  //14

    private DataBase database;
    private SQLiteDatabase conn;
    private RepositorioContato repositorioContato;
    private Contato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ednome      = (EditText)findViewById(R.id.ednome);       //1
        edtele      = (EditText)findViewById(R.id.edtele);       //3
        eddatas     = (EditText)findViewById(R.id.eddatas);     //4
        edgrupos    = (EditText)findViewById(R.id.edgrupos);   //6
        spntele     = (Spinner)findViewById(R.id.spntele);      //7
        spndatas    = (Spinner)findViewById(R.id.spndatas);    //9
        adptele     = ViewHelper.createArrayAdapter(this, spntele);
        adpdatas    = ViewHelper.createArrayAdapter(this, spndatas);


        /*adpemail = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpemail.setDropDownViewResource(android.R.layout.simple_spinner_item);

        adptele = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adptele.setDropDownViewResource(android.R.layout.simple_spinner_item);

        adpdatas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpdatas.setDropDownViewResource(android.R.layout.simple_spinner_item);

        adpende = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpende.setDropDownViewResource(android.R.layout.simple_spinner_item);*/

        spntele.setAdapter(adptele);
        spndatas.setAdapter(adpdatas);

        adptele.add("Real");
        adptele.add("Dollar");
        adptele.add("Euro");
        adptele.add("Outros");

        adpdatas.add("Inclusão");
        adpdatas.add("Alteração");

        ExibeDataListener listener = new ExibeDataListener();
        eddatas.setOnClickListener(listener);
        eddatas.setOnFocusChangeListener(listener);
        eddatas.setKeyListener(null);

        Bundle bundle = getIntent().getExtras();

        if((bundle != null) && (bundle.containsKey(Main.PAR_CONTATO))){
            contato = (Contato)bundle.getSerializable(Main.PAR_CONTATO);
            preencheDados();
        }else{
            contato = new Contato();
        }


        try {

            database = new DataBase(this);
            conn = database.getWritableDatabase();
            repositorioContato = new RepositorioContato(conn);

        }catch (SQLException ex){

            MessageBox.show(this, "Erro", "Erro ao criar o banco" + ex.getMessage());

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(conn != null){
            conn.close();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main2, menu);

        if(contato.getId() != 0)
            menu.getItem(1).setVisible(true);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mni_acao1:            //Case 001 - To Salve
                salvar();
                finish();
                break;

            case R.id.mni_acao2:            //Case 002 - Excluir item da Lista
                excluir();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    private void preencheDados(){

        ednome.setText(contato.getNome());
        edtele.setText(contato.getTelefone());
        spntele.setSelection(Integer.parseInt(contato.getTipotelefone()));
        DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
        String dt = format.format(contato.getDatasespeciais());
        eddatas.setText(dt);
        spndatas.setSelection(Integer.parseInt(contato.getTipodatasespeciais()));
        edgrupos.setText(contato.getGrupos());


    }

    private void excluir(){
        try {
            repositorioContato.excluir( contato.getId());
        }catch (Exception ex){

            MessageBox.show(this, "Erro", "Erro ao excluir o dado" + ex.getMessage());

        }

    }
    private void salvar(){

        try {

            contato.setNome(ednome.getText().toString());
            contato.setTelefone(edtele.getText().toString());
            contato.setGrupos(edgrupos.getText().toString());
            contato.setTipotelefone(String.valueOf(spntele.getSelectedItemPosition()));
            contato.setTipodatasespeciais(String.valueOf(spndatas.getSelectedItemPosition()));

            if(contato.getId() == 0)
                repositorioContato.inserir(contato);
            else
                repositorioContato.alterar(contato);

        }catch (Exception ex){

            MessageBox.show(this, "Erro", "Erro ao Salvar os dados" + ex.getMessage());

        }
    }


    private void exibeData(){
        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dlg = new DatePickerDialog(this, new SelecionaDataListener(), ano, mes, dia);
        dlg.show();

    }

    private class ExibeDataListener implements View.OnClickListener, View.OnFocusChangeListener{

        @Override
        public void onClick(View v) {
            exibeData();
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(hasFocus)
                exibeData();
        }
    }

    private class SelecionaDataListener implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String dt = DateUtils.dateToString(year, monthOfYear, dayOfMonth);
            Date date = DateUtils.getDate(year, monthOfYear, dayOfMonth);
            eddatas.setText(dt);
            contato.setDatasespeciais(date);

        }
    }
}
