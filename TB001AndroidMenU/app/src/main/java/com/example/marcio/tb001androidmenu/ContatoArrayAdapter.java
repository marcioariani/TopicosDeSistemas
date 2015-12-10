package com.example.marcio.tb001androidmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.marcio.tb001androidmenu.dominio.entidades.Contato;

/**
 * Created by marcio on 28/11/2015.
 */
public class ContatoArrayAdapter extends ArrayAdapter {

    private int resource = 0;
    private LayoutInflater inflater;
    private Context context;

    public ContatoArrayAdapter(Context context, int resource)
    {
        super(context, resource);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resource = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        ViewHolder viewHolder = null;
        if(convertView == null){

            viewHolder = new ViewHolder();
            view = inflater.inflate(resource, parent, false);
            viewHolder.txtCor = (TextView)view.findViewById(R.id.txtCor);
            viewHolder.txtNome = (TextView)view.findViewById(R.id.txtNome);
            viewHolder.txtTelefone = (TextView)view.findViewById(R.id.txtTelefone);
            view.setTag(viewHolder);
            convertView = view;

        }else{

            viewHolder = (ViewHolder)convertView.getTag();
            view = convertView;
        }

        Contato contato = (Contato) getItem(position);

        if (contato.getNome().toUpperCase().startsWith("A") )
            viewHolder.txtCor.setBackgroundColor( context.getResources().getColor(R.color.azul) );
        else
        if (contato.getNome().toUpperCase().startsWith("B"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.vermelho));
        else
        if (contato.getNome().toUpperCase().startsWith("C"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.amarelo));
        else
        if (contato.getNome().toUpperCase().startsWith("D"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.roxo));
        else
        if (contato.getNome().toUpperCase().startsWith("E"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.rosa));
        else
        if (contato.getNome().toUpperCase().startsWith("F"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.cinza));
        else
        if (contato.getNome().toUpperCase().startsWith("G"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.bronze));
        else
        if (contato.getNome().toUpperCase().startsWith("H"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.azul_claro));
        else
        if (contato.getNome().toUpperCase().startsWith("I"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.azul_marinho));
        else
        if (contato.getNome().toUpperCase().startsWith("J"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.laranja));
        else
        if (contato.getNome().toUpperCase().startsWith("K"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.verde));
        else
        if (contato.getNome().toUpperCase().startsWith("L"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.verde_claro));
        else
        if (contato.getNome().toUpperCase().startsWith("M"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.verde_escuro));
        else
        if (contato.getNome().toUpperCase().startsWith("N"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.vermelho_claro));
        else
        if (contato.getNome().toUpperCase().startsWith("O"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.vermelho_escuro));
        else
        if (contato.getNome().toUpperCase().startsWith("P"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.amarelo_escuro));
        else
        if (contato.getNome().toUpperCase().startsWith("Q"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.preto));
        else
        if (contato.getNome().toUpperCase().startsWith("R"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.rosa_claro));
        else
        if (contato.getNome().toUpperCase().startsWith("S"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.rosa_escuro));
        else
        if (contato.getNome().toUpperCase().startsWith("T"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.roxo_claro));
        else
        if (contato.getNome().toUpperCase().startsWith("U"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.roxo_escuro));
        else
        if (contato.getNome().toUpperCase().startsWith("V"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.azul_escuro));
        else
        if (contato.getNome().toUpperCase().startsWith("W"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.amarelo_verde));
        else
        if (contato.getNome().toUpperCase().startsWith("X"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.azul_roxo));
        else
        if (contato.getNome().toUpperCase().startsWith("Y"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.vermelho_rosa));
        else
        if (contato.getNome().toUpperCase().startsWith("Z"))
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.verde_azul));
        else
            viewHolder.txtCor.setBackgroundColor(context.getResources().getColor(R.color.nothing));


        viewHolder.txtNome.setText(contato.getNome());
        viewHolder.txtTelefone.setText(contato.getTelefone());


        return view;

    }

    static class ViewHolder{
        TextView txtCor;
        TextView txtNome;
        TextView txtTelefone;
    }

}
