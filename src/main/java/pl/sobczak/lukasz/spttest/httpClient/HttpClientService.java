/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.httpClient;

import pl.sobczak.lukasz.spttest.domain.SWAbstractPayload;
import pl.sobczak.lukasz.spttest.domain.SWAbstractDataPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import pl.sobczak.lukasz.spttest.MyExc;

/**
 *
 * @author piko
 */
@Service
public class HttpClientService {

    static HttpClient connection = HttpClient.newHttpClient();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T extends SWAbstractDataPage> T getResponsePage(String webPatch, Class<T> klass) {

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(webPatch))
                    .GET()
                    .build();

            String body = connection.send(request, HttpResponse.BodyHandlers.ofString()).body();
            var p = gson.fromJson(body, klass);
            return p;
        } catch (IOException | InterruptedException ex) {

            throw new MyExc.HttpClientNoConnectionException("Cannot connect to SWApi.co");
        }

    }

    public static <T extends SWAbstractPayload> T getOneResponse(String webPatch, Class<T> klass) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(webPatch))
                    .GET()
                    .build();

            String body = connection.send(request, HttpResponse.BodyHandlers.ofString()).body();
            var p = gson.fromJson(body, klass);
            return p;
        } catch (IOException | InterruptedException ex) {

            throw new MyExc.HttpClientNoConnectionException("Cannot connect to SWApi.co");
        }

    }
}
