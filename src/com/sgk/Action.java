package com.sgk ;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shemul
 */
public class Action {
    private static String urlForInformation = "http://127.0.0.1/json/info";
    private static String urlForLogin = "http://127.0.0.1/json/login";
    JSONArray  status = null;
    JSONArray  login = null;
           
    ServiceHandler sh = new ServiceHandler();
    String jsonStr = sh.makeServiceCall(urlForInformation, ServiceHandler.GET);
    
           
    public Info[] getInformation() {
        String jsonStr = sh.makeServiceCall(urlForInformation, ServiceHandler.GET);
        Info in[] = new Info[getStatusCount()];
         for (int i = 0; i < in.length; i++) {
             in[i] = new Info();
         }
        if (jsonStr != null) {
            try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                   
                    status = jsonObj.getJSONArray("status");
                    
                    for (int i = 0; i < status.length(); i++) {
                        JSONObject c = status.getJSONObject(i);
                        
                        int id = Integer.parseInt(c.getString("id"));
                        in[i].setId(id);
                        in[i].setName(c.getString("t_name"));
                        in[i].setGoneFor(c.getString("gone_for"));
                        in[i].setAvaiable(c.getString("available_now"));
                        in[i].setCommenet(c.getString("comment"));
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return in;
    }
    
     public Info getLoginData(String u , String p) {
        Info in = new Info();
        String jsonLogin = sh.makeServiceCall(urlForLogin, ServiceHandler.GET); 
        boolean loginStatus = false ; 
        int userStatus = 0 ;
        if (jsonLogin != null) {
            try {
                    JSONObject jsonObj = new JSONObject(jsonLogin);
                   
                    login = jsonObj.getJSONArray("login");
                    
                    for (int i = 0; i < login.length(); i++) {
                        
                        JSONObject c = login.getJSONObject(i);
                       if (u.equals(c.getString("username")) && p.equals(c.getString("password"))) {
                           if("1".equals(c.getString("status"))) {
                               if("1".equals(c.getString("isAdmin"))) {
                                   in.setLoginStatusCode(1);
                                   in.setName(c.getString("username"));
                                   in.setId(Integer.parseInt(c.getString("user_id")));
                                   
                                   break;
                               } else {
                                    in.setLoginStatusCode(2);
                                    in.setName(c.getString("username"));
                                    in.setId(Integer.parseInt(c.getString("user_id")));
                                    break;
                               }
                           } else {
                               in.setLoginStatusCode(3);
                               in.setName(c.getString("username"));
                               in.setId(Integer.parseInt(c.getString("user_id")));
                           }
                           
                       } else {
                           in.setLoginStatusCode(4);
                           in.setName(c.getString("username"));
                           in.setId(Integer.parseInt(c.getString("user_id")));
                       }
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
       return in;
        //return 1;
    }
    
    public int getStatusCount() {
        if (jsonStr != null) {
            try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                   
                    status = jsonObj.getJSONArray("status");
                    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status.length();
    }
    public Info getIndividual(int t_id) {
        
        Info in = new Info();
        
        //ServiceHandler sh = new ServiceHandler();
        String urlForIndividual = "http://128.199.201.52/app/javaPro/info";
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
        nameValuePair.add(new BasicNameValuePair("search", t_id+""));
         
	String jsonIndividual = sh.makeServiceCall(urlForIndividual, ServiceHandler.POST, nameValuePair);
         
         
         if (jsonIndividual != null) {
            try {
                    JSONObject jsonObj = new JSONObject(jsonIndividual);
                   
                    status = jsonObj.getJSONArray("status");
                    
                   
                    for (int i = 0; i < status.length(); i++) {
                        JSONObject c = status.getJSONObject(i);
                        int id =  Integer.parseInt(c.getString("id"));
                        in.setId(id);
                        in.setName(c.getString("t_name"));
                        in.setGoneFor(c.getString("gone_for"));
                        in.setAvaiable(c.getString("available_now"));
                        in.setCommenet(c.getString("comment"));
                    }
                    
                   // System.out.println(status.toString());
                   
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return in;
         
    }
    public void postMet(){
        
        //  under construction
        ServiceHandler sh = new ServiceHandler();
        String url3 = "http://128.199.201.52/app/SirGeloKoi/login";
			// Making a request to url and getting response
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
         nameValuePair.add(new BasicNameValuePair("search", "shemul"));
         
	String jsonStr4 = sh.makeServiceCall(url3, ServiceHandler.POST, nameValuePair);
         
         
         if (jsonStr4 != null) {
            try {
                    JSONObject jsonObj = new JSONObject(jsonStr4);
                   
                   // status = jsonObj.getJSONArray("login");
                    
                    System.out.println(jsonObj.toString());
                    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //return status.length();
        
    }
}
