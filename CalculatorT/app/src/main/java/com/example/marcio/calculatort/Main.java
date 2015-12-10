package com.example.marcio.calculatort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends AppCompatActivity implements View.OnClickListener{

    boolean decimal = false;
    boolean soma1 = false;
    boolean sub1 = false;
    boolean mult1 = false;
    boolean div1 = false;
    boolean expo1 = false;
    Double[] numero = new Double[20];
    Double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button n0 = (Button)findViewById(R.id.btn0);
        n0.setOnClickListener(this);
        Button n1 = (Button)findViewById(R.id.btn1);
        n1.setOnClickListener(this);
        Button n2 = (Button)findViewById(R.id.btn2);
        n2.setOnClickListener(this);
        Button n3 = (Button)findViewById(R.id.btn3);
        n3.setOnClickListener(this);
        Button n4 = (Button)findViewById(R.id.btn4);
        n4.setOnClickListener(this);
        Button n5 = (Button)findViewById(R.id.btn5);
        n5.setOnClickListener(this);
        Button n6 = (Button)findViewById(R.id.btn6);
        n6.setOnClickListener(this);
        Button n7 = (Button)findViewById(R.id.btn7);
        n7.setOnClickListener(this);
        Button n8 = (Button)findViewById(R.id.btn8);
        n8.setOnClickListener(this);
        Button n9 = (Button)findViewById(R.id.btn9);
        n9.setOnClickListener(this);

        Button ponto = (Button)findViewById(R.id.btnponto);
        ponto.setOnClickListener(this);

        Button soma = (Button)findViewById(R.id.btnsoma);
        soma.setOnClickListener(this);
        Button resto = (Button)findViewById(R.id.btnresto);
        resto.setOnClickListener(this);
        Button mult = (Button)findViewById(R.id.btnmult);
        mult.setOnClickListener(this);
        Button div = (Button)findViewById(R.id.btndiv);
        div.setOnClickListener(this);
        Button expo = (Button)findViewById(R.id.btnexp);
        expo.setOnClickListener(this);

        Button exp = (Button)findViewById(R.id.btnexp);
        exp.setOnClickListener(this);
        Button left = (Button)findViewById(R.id.btnleft);
        left.setOnClickListener(this);
        Button pi = (Button)findViewById(R.id.btnpi);
        pi.setOnClickListener(this);

        Button resul = (Button)findViewById(R.id.btnclick);
        resul.setOnClickListener(this);
        Button limpar = (Button)findViewById(R.id.btnac);
        limpar.setOnClickListener(this);

        Button right = (Button)findViewById(R.id.btnright);
        right.setOnClickListener(this);
        Button eular = (Button)findViewById(R.id.btneular);
        eular.setOnClickListener(this);
        Button phi = (Button)findViewById(R.id.btnphi);
        phi.setOnClickListener(this);
        //2.71828183

        Button danger = (Button)findViewById(R.id.btndanger);
        danger.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        TextView tela = (TextView)findViewById(R.id.txtTela);
        int Selecao = v.getId();
        String a = tela.getText().toString();

        try {
            switch (Selecao) {
                case R.id.btn0:
                    tela.setText(a + "0");
                    break;
                case R.id.btn1:
                    tela.setText(a + "1");
                    break;
                case R.id.btn2:
                    tela.setText(a + "2");
                    break;
                case R.id.btn3:
                    tela.setText(a + "3");
                    break;
                case R.id.btn4:
                    tela.setText(a + "4");
                    break;
                case R.id.btn5:
                    tela.setText(a + "5");
                    break;
                case R.id.btn6:
                    tela.setText(a + "6");
                    break;
                case R.id.btn7:
                    tela.setText(a + "7");
                    break;
                case R.id.btn8:
                    tela.setText(a + "8");
                    break;
                case R.id.btn9:
                    tela.setText(a + "9");
                    break;

                case R.id.btnpi:
                    tela.setText(a + "3.14159265");     //PI
                    break;
                case R.id.btnphi:
                    tela.setText(a + "1.618");          //PHI ("fi")
                    break;
                case R.id.btneular:
                    tela.setText(a + "2.71828183");     //NEPERIANO OR NEULAR (e)
                    break;
                case R.id.btnleft:
                    tela.setText(a + "(");
                    break;
                case R.id.btnright:
                    tela.setText(a + ")");
                    break;
                case R.id.btndanger:
                    tela.setText(a + "APP developed by Marcio Ariani");
                    break;

                case R.id.btnponto:
                    if(decimal == false){
                        tela.setText(a  + ".");
                        decimal = true;
                    }else{
                        return;
                    }
                    break;

                case R.id.btnsoma:
                    soma1 = true;
                    numero[0] = Double.parseDouble(a);
                    tela.setText("");
                    decimal = false;
                    break;
                case R.id.btnresto:
                    sub1 = true;
                    numero[0] = Double.parseDouble(a);
                    tela.setText("");
                    decimal = false;
                    break;
                case R.id.btnmult:
                    mult1 = true;
                    numero[0] = Double.parseDouble(a);
                    tela.setText("");
                    decimal = false;
                    break;
                case R.id.btndiv:
                    div1 = true;
                    numero[0] = Double.parseDouble(a);
                    tela.setText("");
                    decimal = false;
                    break;
                case R.id.btnexp:
                    expo1 = true;
                    numero[0] = Double.parseDouble(a);
                    tela.setText("");
                    decimal = false;
                    break;

                case R.id.btnclick:
                    numero[1] = Double.parseDouble(a);
                    if(soma1 == true){
                        resultado = numero[0] + numero[1];
                        tela.setText(String.valueOf(resultado));
                    }else if(sub1 == true){
                        resultado = numero[0] - numero[1];
                        tela.setText(String.valueOf(resultado));
                    }else if(mult1 == true){
                        resultado = numero[0] * numero[1];
                        tela.setText(String.valueOf(resultado));
                    }else if(div1 == true){
                        resultado = numero[0] / numero[1];
                        tela.setText(String.valueOf(resultado));
                    }else if(expo1 == true){
                        for(int k = 0; k< numero[1]; k++){
                            resultado *= numero[0];
                            tela.setText(String.valueOf(resultado));
                        }
                    }

                    decimal = false;
                    soma1 = false;
                    sub1 = false;
                    mult1 = false;
                    div1 = false;
                    expo1 = false;
                    break;


                case R.id.btnac:
                    tela.setText("");
                    decimal = false;
                    break;

            }
        }catch (Exception e){
            tela.setText("error");
        }
    }
}