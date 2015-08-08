/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgk;

/**
 * Interface to introduce re-usable method , member.
 * @author shemul
 * @version 1.0
 * 
 */
public interface ActionHelper {
    
    static String dashBannerImage = "assets/dash.jpg";
    static String dashBannerStudent = "assets/student_dash.jpg";
    
    static String urlForInformation = "http://128.199.201.52/app/javaPro/info";
    static String urlForLogin = "http://128.199.201.52/app/javaPro/login";
    static String urlForIndividual = "http://128.199.201.52/app/javaPro/info";
    static String urlForAddNewFaculty = "http://128.199.201.52/app/javaPro/addNew";
         
        
    public Info[] getInformation();
    public Info getLoginData(String u , String p);
    public int getStatusCount();
    public Info getIndividual(int t_id);
     
    public String statusUpdate(int user_id , String goneFor , String available , String comment);
    public String addFaculty(String user_id , String username , String password , int IsAdmin , int isActive);
    public void postMet();
    
}
