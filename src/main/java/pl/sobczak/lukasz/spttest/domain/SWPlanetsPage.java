/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.domain;


import pl.sobczak.lukasz.spttest.httpClient.HttpClientService;
import pl.sobczak.lukasz.spttest.httpClient.Url;

/**
 *
 * @author piko
 */
public class SWPlanetsPage extends SWAbstractDataPage<SWPlanets>{

    public SWPlanetsPage(Url url, String name, HttpClientService httpClient) {
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
