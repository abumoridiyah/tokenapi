/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokenapi.controller;

import com.tokenapi.model.AuthTokenInfo;
import com.tokenapi.util.ParamUtils;
import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Abu Moridiyah
 */
@RestController
@RequestMapping("/filters")
public class TokenController {
    private static AuthTokenInfo sendTokenRequest(){
        RestTemplate restTemplate = new RestTemplate(); 
        
        HttpEntity<String> request = new HttpEntity<>(getHeadersWithClientCredentials());
        ResponseEntity<AuthTokenInfo> response = restTemplate.exchange(ParamUtils.AUTH_SERVER_URI+ParamUtils.QPM_PASSWORD_GRANT, HttpMethod.POST, request, AuthTokenInfo.class);
        
        return response.getBody();
    }
    
    private static HttpHeaders getHeaders(){
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	return headers;
    }
    private static HttpHeaders getHeadersWithClientCredentials(){
    	String plainClientCredentials="my-trusted-client:secret";
    	String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
    	
    	HttpHeaders headers = getHeaders();
    	headers.add("Authorization", "Basic " + base64ClientCredentials);
    	return headers;
    }    
    
    @RequestMapping(value="/tokens")
    public AuthTokenInfo getResults(){
       return sendTokenRequest();
    }
}
