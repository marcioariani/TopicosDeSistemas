package com.example.marcio.tb001androidmenu.dominio.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by marcio on 28/11/2015.
 */
public class Contato implements Serializable {

    public static String TABELA = "CONTATO";

    public static String ID = "_id";
    public static String NOME = "NOME";
    public static String TELEFONE = "TELEFONE";
    public static String TIPOTELEFONE = "TIPOTELEFONE";
    public static String EMAIL = "EMAIL";
    public static String TIPOEMAIL = "TIPOEMAIL";
    public static String ENDERECO = "ENDERECO";
    public static String TIPOENDERECO = "TIPOENDERECO";
    public static String DATASESPECIAIS = "DATASESPECIAIS";
    public static String TIPODATASESPECIAIS = "TIPODATASESPECIAIS";
    public static String GRUPOS = "GRUPOS";

    private long id;                    //1
    private String nome;                //2
    private String telefone;            //3
    private String tipotelefone;        //4
    private String email;               //5
    private String tipoemail;           //6
    private String endereco;            //7
    private String tipoendereco;        //8
    private Date datasespeciais;        //9
    private String tipodatasespeciais;  //10
    private String grupos;              //11




    public Contato()
    {

        id = 0;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipotelefone() {
        return tipotelefone;
    }

    public void setTipotelefone(String tipotelefone) {
        this.tipotelefone = tipotelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoemail() {
        return tipoemail;
    }

    public void setTipoemail(String tipoemail) {
        this.tipoemail = tipoemail;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoendereco() {
        return tipoendereco;
    }

    public void setTipoendereco(String tipoendereco) {
        this.tipoendereco = tipoendereco;
    }

    public Date getDatasespeciais() {
        return datasespeciais;
    }

    public void setDatasespeciais(Date datasespeciais) {
        this.datasespeciais = datasespeciais;
    }

    public String getTipodatasespeciais() {
        return tipodatasespeciais;
    }

    public void setTipodatasespeciais(String tipodatasespeciais) {
        this.tipodatasespeciais = tipodatasespeciais;
    }

    public String getGrupos() {
        return grupos;
    }

    public void setGrupos(String grupos) {
        this.grupos = grupos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return nome + " " + telefone;
    }
}

