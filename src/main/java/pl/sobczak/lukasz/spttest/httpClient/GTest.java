/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.httpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author piko
 */

class SWC {
    String name, homeworld, url;
    String[] films;

    @Override
    public String toString() {
        return "SWCharacter{" + "name=" + name + ", homeworld=" + homeworld + ", films=" + Arrays.toString(films) + '}' + System.lineSeparator();
    }
}

class SWCP{
     int count;
     String next, previous;
     LinkedList<SWC> results;

    @Override
    public String toString() {
        return "SWCP{" + "count=" + count + ", next=" + next + ", previous=" + previous + ", results=" + results + '}';
    }
     
}

public class GTest {
    public static void main(String[] args) {
       var connection = HttpClient.newHttpClient();
        Gson gson = new GsonBuilder().create();
         HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.co/api/people/"))
                .GET()
                .build();
        var p = connection.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply( st-> gson.fromJson(st, SWCP.class) )
                .join();
        System.out.println(p);
    }
}
