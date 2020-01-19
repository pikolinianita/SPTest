/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.httpClient;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author piko
 */
@lombok.ToString
@lombok.Getter
public class HttpReport2 {
    SWCharacterPage characters;
    SWPlanetsPage planets;
    SWFilmPage films;
    String charsStatus, planetsStatus, filmStatus;
    String name, planet;

    @Autowired
    HttpClientService httpClient;
    
    public static HttpReport2 create(String name, String planet)
    { 
        System.out.println("HttpReport:");
        
        var rp = new HttpReport2(name, planet);
        
        System.out.println(rp.httpClient);
        rp.planets = new SWPlanetsPage(Url.PLANET, planet, rp.httpClient);
        rp.planetsStatus = rp.planets.hasExactHit(planet);
        if (! rp.planetsStatus.equals("Ok")) {
            return rp;
        }
        rp.characters = new SWCharacterPage(Url.PEOPLE, name, rp.httpClient);
        rp.charsStatus = rp.characters.hasHits();
        if (rp.charsStatus.equals("Ok")){
            rp.films = new SWFilmPage(Url.FILM,rp.characters.getFilmsReferences());
            rp.filmStatus = rp.films.hasHits();
        }
        return rp;
    }
    
    public List<SWCharacter> getCharList(){
        return characters.getResults();
    }
          
    public SWPlanets getPlanet(){
        return planets.getOneHit(planet);
    }
    
    public String GetPlanetName(){
        return planet;
    }
    
    public List<SWFilm> getFilmList(){
        return films.getResults();
    }
    
    private HttpReport2(String name, String planet) {
        this.name = name;
        this.planet = planet;
        
    }
    
    public String checkStatus(){
        if (!planetsStatus.equals("ok")) {
            return "Planet - " + planetsStatus;
        } else if (!charsStatus.equals("ok")) {
            return "Character phrase - " + charsStatus;
        } else {
            return "Ok";
        }
        
    }
}
