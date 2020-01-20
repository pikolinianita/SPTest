/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;
import pl.sobczak.lukasz.spttest.httpClient.HttpClientService;
import pl.sobczak.lukasz.spttest.httpClient.Url;


/**
 *
 * @author piko
 */
@lombok.Getter
public class SWCharacterPage extends SWAbstractDataPage<SWCharacter>{

    public SWCharacterPage(Url url, String name, HttpClientService httpClient) {
        super (url, name, httpClient);
    }

    @Override
    public String toString() {
        return "SWCharacterPage{" + "count=" + count + ", next=" + next + ", previous=" + previous + ", people=" + results + '}';
    }
    
    @Override
    void Validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public Set<String> getFilmsReferences() {
        var set = new HashSet<String>();
        results.forEach(ch -> Stream.of(ch.films).forEach(film -> set.add(film)));
        return set;
    }


}
