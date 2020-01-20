/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.httpClient;

/**
 *
 * @author piko
 * Keeps URLs for SWApi in one place
 */
public enum Url{
    PLANET("https://swapi.co/api/planets/"), 
    PEOPLE("https://swapi.co/api/people/"), 
    FILM("https://swapi.co/api/films/");
    
    public final String label;
    
    private Url(String l){
        label = l;
    }
}
