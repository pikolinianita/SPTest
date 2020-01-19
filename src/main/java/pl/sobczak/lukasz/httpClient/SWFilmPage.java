/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.httpClient;

import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author piko
 */
//@lombok.ToString
public class SWFilmPage extends SWAbstractDataPage<SWFilm> {

    SWFilmPage(Url url, Set<String> filmsReferences) {
        count = filmsReferences.size();
        results = new LinkedList<>();
        System.out.println(filmsReferences);
        if (count > 0) {
            for (var filmUrl : filmsReferences) {
                System.out.println(filmUrl);
                var z = HttpClientService.getOneResponse(filmUrl, SWFilm.class);
                System.out.println(z);
                //System.out.println(z.results);
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
