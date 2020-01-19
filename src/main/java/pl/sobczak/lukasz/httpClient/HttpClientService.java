/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.httpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

/**
 *
 * @author piko
 */
@Service
public class HttpClientService {
   static HttpClient connection  = HttpClient.newHttpClient();
   static Gson gson = new GsonBuilder().setPrettyPrinting().create();

   /* public HttpClientService() {
        connection = HttpClient.newHttpClient();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
     */
   
   public static <T extends SWAbstractDataPage> T getResponsePage (String webPatch, Class<T> klass) {
        
       System.out.println("HttpClientService 1");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(webPatch))
                .GET()
                .build();
        System.out.println("HttpClientService 2");
        var p = connection.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply( st-> gson.fromJson(st, klass) )
                .join();
        System.out.println("HttpClientService 3");
        return p;
    }

    public static <T extends SWAbstractPayload> T getOneResponse (String webPatch, Class<T> klass) {
        
       System.out.println("HttpClientService 1");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(webPatch))
                .GET()
                .build();
        System.out.println("HttpClientService 2");
        var p = connection.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply( st-> gson.fromJson(st, klass) )
                .join();
        System.out.println("HttpClientService 3");
        return p;
    }
   
}
