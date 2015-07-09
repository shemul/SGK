package com.sgk ;


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
    private static String url = "http://128.199.201.52/app/SirGeloKoi/info";
    JSONArray  status = null;
    ServiceHandler sh = new ServiceHandler();
    String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);
        
    public Info[] runit() {
        
        //System.out.println("Response " + jsonStr);
        
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
}
