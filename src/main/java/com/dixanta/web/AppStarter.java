/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author USER
 */

@EnableAutoConfiguration
@SpringBootApplication
public class AppStarter {
    
    public static void main(String[] args){
        SpringApplication.run(AppStarter.class, args);
    }
}
