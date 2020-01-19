/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.httpClient;

import java.util.Arrays;

/**
 *
 * @author piko
 */
class SWPlanetsPage extends SWAbstractDataPage<SWPlanets>{

    SWPlanetsPage(Url url, String name, HttpClientService httpClient) {
        super (url, name, httpClient);
    }
    
    @Override
    public String toString() {
        return "SWPlanetsPage{" + "count=" + count + ", next=" + next + ", previous=" + previous + ", planets=" + results + '}';
    }
    
    @Override
    void Validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public SWPlanets getOneHit(String name){
        return results.stream().filter(p -> p.name.equals(name)).findFirst().get();
    }
}
