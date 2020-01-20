/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.domain;

import java.util.LinkedList;
import java.util.Set;
import pl.sobczak.lukasz.spttest.httpClient.HttpClientService;
import pl.sobczak.lukasz.spttest.httpClient.Url;

/**
 *
 * @author piko
 * solid class for result from Film query. 
 * constructor takes set of films, (generated from SWCharacterPage) and ask for each film
 */

public class SWFilmPage extends SWAbstractDataPage<SWFilm> {

    public SWFilmPage(Url url, Set<String> filmsReferences) {
        count = filmsReferences.size();
        results = new LinkedList<>();
        
        if (count > 0) {
            for (var filmUrl : filmsReferences) {
                
                var z = HttpClientService.getOneResponse(filmUrl, SWFilm.class);
                
                results.add(z);
            }
        }
    }
    @Override
    void Validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "SWFilmPage(" + count + " - " + next +  " -  " + previous + ")";
    }
    
}
