/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgk;

/**
 *
 * @author shemul
 */
public class Info {
    
    private int id = 0;
    private String tName ;
    private String goneFor;
    private String available;
    private String comment;
    private int loginStatusCode;
    
    public void setId(int i) {
        this.id = i;
    }
    
    public void setLoginStatusCode(int i) {
        this.loginStatusCode = i;
    }
    
    public void setName(String n) {
        this.tName = n;
    }
    
    public void setGoneFor(String g) {
        this.goneFor = g ;
    }
    public void setAvaiable(String a) {
        this.available = a;
    }
    
    public void setCommenet(String c) {
        this.comment = c;
    }
    
    public int getID() {
        return id;
    }
    
    public String getName() {
        return tName;
    }
    
    public String getGoneFor(){
        return goneFor;
    }
    
    public String getAvaible(){
        return available;
    }
    public String getComment(){
        return comment;
    }
    public int getLoginStatusCode(){
        return loginStatusCode;
    }
    
    
    
}
