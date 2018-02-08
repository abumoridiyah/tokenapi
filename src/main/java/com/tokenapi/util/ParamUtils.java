/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokenapi.util;

/**
 *
 * @author Abu Moridiyah
 */
public class ParamUtils {
     public static final String REST_SERVICE_URI = "http://localhost:9090/tokenapi";
    
    public static final String AUTH_SERVER_URI = "http://localhost:9090/tokenapi/oauth/token";
    
    public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=bill&password=abc123";
    
    public static final String QPM_ACCESS_TOKEN = "?access_token=";
}
