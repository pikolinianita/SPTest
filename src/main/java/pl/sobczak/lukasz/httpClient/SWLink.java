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
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

/**
 *
 * @author piko
 */



public class SWLink {
    
    HttpClient connection;
    Gson gson;
    
    SWLink(){
        connection = HttpClient.newHttpClient();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    public static void main(String[] args) {
        SWLink link = new SWLink();
        

        /*HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.co/api/films/"))
                .build();
        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        */
        
      //  link.createReport("Luke","Tatooine");
        HttpReport2 rep = HttpReport2.create("Luke", "Tatooine");
    }

    HttpReport createReport(String name, String planet) {
        var report = new HttpReport(name, planet);
        var bool = report.setPlanets(queryForPage(Url.PLANET, planet, SWPlanetsPage.class))
                .validatePlanet()
                .hasCorrectPlanet();
        // boolean x = report.hasCorrectPlanet();
        if (bool) {
            return report;
        }
        bool = report.setCharacters(queryForPage(Url.PEOPLE, name, SWCharacterPage.class))
                .validateChars()
                .hasCorrectChars();

        return report;
    }

    private <T extends SWAbstractDataPage> T queryForPage(Url url, String name, Class<T> klass ) {
        T p = GetCharacterResponsePage(url, name, klass);
        while (p.hasNextPage()){
            p.addNextPage(GetCharacterResponsePage( p.getNextPageURL(), klass));
        }
        System.out.println(p);
        return p;
    }
    
    private <T> T GetCharacterResponsePage (Url url, String name, Class<T> klass) {
       return GetCharacterResponsePage( url.label+"?search="+name , klass);
    
    }

    private <T> T GetCharacterResponsePage (String webPatch, Class<T> klass) {
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(webPatch))
                .GET()
                .build();
        var p = connection.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply( st-> gson.fromJson(st, klass) )
                .join();
        return p;
    }

    private SWPlanetsPage queryForPlanets(String planet) {
       
       return null;
    }
}
