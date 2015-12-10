package com.example.marcio.tb001androidmenu.database;

/**
 * Created by marcio on 28/11/2015.
 */
public class ScriptSQL {


    public static String getCreateContato()
    {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" CREATE TABLE IF NOT EXISTS CONTATO ( ");        //1
        sqlBuilder.append("_id                INTEGER       NOT NULL ");    //2
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");                   //3
        sqlBuilder.append("NOME               VARCHAR (200), ");            //4
        sqlBuilder.append("TELEFONE           VARCHAR (14), ");             //5
        sqlBuilder.append("TIPOTELEFONE       VARCHAR (1), ");              //6
        sqlBuilder.append("EMAIL              VARCHAR (255), ");            //7
        sqlBuilder.append("TIPOEMAIL          VARCHAR (1), ");              //8
        sqlBuilder.append("ENDERECO           VARCHAR (255), ");            //9
        sqlBuilder.append("TIPOENDERECO       VARCHAR (1), ");              //10
        sqlBuilder.append("DATASESPECIAIS     DATE, ");                     //11
        sqlBuilder.append("TIPODATASESPECIAIS VARCHAR (1), ");              //12
        sqlBuilder.append("GRUPOS             VARCHAR (255) ");             //13
        sqlBuilder.append(");");                                            //14

        return sqlBuilder.toString();

    }

}
