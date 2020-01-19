/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.httpClient;

import lombok.Data;

/**
 *
 * @author piko
 */
@Data
class HttpReport {
    SWCharacterPage characters;
    SWPlanetsPage planets;
    String charsStatus, planetsStatus;
    String name, planet;

    static HttpReport create(String name, String planet)
    { 
        var rp = new HttpReport(name, planet);
        return rp;
    }
    
    public HttpReport(String name, String planet) {
        this.name = name;
        this.planet = planet;
    }
    
    

    HttpReport validatePlanet() {
        planetsStatus = "Planet Not Found";
        long shouldBeOne = planets.results
                .stream()
                .filter(r-> r.name.equalsIgnoreCase(name))
                .count();
        if (shouldBeOne  == 1) {
            planetsStatus = "Ok";
        } else {
            planetsStatus = "Planet Not Found";
        }
        return this;
    }

    HttpReport setPlanets(SWPlanetsPage queryForPage) {
        planets = queryForPage;
        return this;
    }

    HttpReport setCharacters(SWCharacterPage queryForPage) {
        characters = queryForPage;
        return this;
    }

    boolean hasCorrectPlanet() {
        return planetsStatus.equals("Ok");
    }

    HttpReport validateChars() {
        if (characters.count >0 ){
            charsStatus = "Ok";
        } else {
            charsStatus = "Planet Not Found";
        }
        
        return this;
    }

    boolean hasCorrectChars() {
        return charsStatus.equals("Ok");
    }
    
  
    
}
