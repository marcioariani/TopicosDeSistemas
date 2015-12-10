package com.example.marcio.myloginf;

/**
 * Created by marcio on 14/11/2015.
 */
public class Contact {
    String name, email, uname, pass;
    //-------------------Set and Get -> NAME---------------
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    //-------------------Set and Get -> EMAIL---------------
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    //-------------------Set and Get -> UNAME---------------
    public void setUname(String uname){
        this.uname = uname;
    }
    public String getUname(){
        return this.uname;
    }
    //-------------------Set and Get -> PASSWORD---------------
    public void setPass(String pass){
        this.pass = pass;
    }
    public String getPass(){
        return this.pass;
    }
}
