/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest;

import org.springframework.stereotype.Service;

/**
 *
 * @author piko
 */
@Service
public class MyService {
    public String getMessage() {
    	return "Hello World!";
    }
    public int multiplyNum(int num1, int num2) {
    	return num1 * num2;
    }
    public boolean isIdAvailable(long id) {
        if (id == 100) {
        	return true;
        }
        return false;
    }    
} 
