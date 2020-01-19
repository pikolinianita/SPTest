/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.httpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author piko
 */
//@Component
public class ClientRunner implements CommandLineRunner  {

    //@Autowired
   // HttpClientService httpClient;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------Client Runner-------------");
        System.out.println(HttpReport2.create("Luke", "Tatooine"));
        System.out.println("------------Skywalker-----------------");
        System.out.println(HttpReport2.create("Skywalker", "Tatooine"));
        System.out.println("------------Skywalkerzzz-----------------");
        System.out.println(HttpReport2.create("Skywalkerzzz", "Tatooine"));
        System.out.println("------------Skywalker wrong pl-----------------");
        System.out.println(HttpReport2.create("Skywalker", "Tatooinezzz"));
        System.out.println("------------l-----------------");
        System.out.println(HttpReport2.create("l", "Tatooine"));
    }
    
}
