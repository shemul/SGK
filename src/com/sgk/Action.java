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
    private static String urlForInformation = "http://128.199.201.52/app/SirGeloKoi/info";
    private static String urlForLogin = "http://128.199.201.52/app/SirGeloKoi/login";
    JSONArray  status = null;
    JSONArray  login = null;
           
    ServiceHandler sh = new ServiceHandler();
    String jsonStr = sh.makeServiceCall(urlForInformation, ServiceHandler.GET);
    String jsonLogin = sh.makeServiceCall(urlForLogin, ServiceHandler.GET);
           
    public Info[] getInformation() {
        
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
    
     public int getLoginData(String u , String p) {
       
         
        boolean loginStatus = false ; 
        int userStatus = 0 ;
        if (jsonLogin != null) {
            try {
                    JSONObject jsonObj = new JSONObject(jsonLogin);
                   
                    login = jsonObj.getJSONArray("login");
                    
                    for (int i = 0; i < login.length(); i++) {
                        
                        JSONObject c = login.getJSONObject(i);
                       // System.out.println("Found");
                       // System.out.println(c.getString("username"));
                       if (u.equals(c.getString("username")) && p.equals(c.getString("password"))) {
                           if("1".equals(c.getString("status"))) {
                               if("1".equals(c.getString("isAdmin"))) {
                                   userStatus = 1 ;
                                   break;
                               } else {
                                    userStatus = 2 ;
                                    break;
                               }
                           } else {
                               userStatus = 3 ;
                           }
                           
                       } else {
                           userStatus = 0;
                       }
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
       return userStatus;
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
    
    public void postMet(){
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
