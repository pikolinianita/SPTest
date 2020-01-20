/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.domain;


import java.util.LinkedList;
import java.util.List;
import pl.sobczak.lukasz.spttest.httpClient.HttpClientService;
import pl.sobczak.lukasz.spttest.httpClient.Url;

/**
 *
 * @author piko
 * @param <T>
 */



public abstract class SWAbstractDataPage <T extends SWAbstractPayload> {
    
   protected int count;
   protected String next, previous;
   LinkedList<T> results;   
  
   // HttpClientService httpClient;

    public SWAbstractDataPage(){};
    
    public SWAbstractDataPage (Url url, String name, HttpClientService httpClient) {  
    
        //this.httpClient = httpClient;
        //System.out.println(this.getClass());
        //System.out.println(url.label +"?search="+name);
       //System.out.println(this.httpClient);
        var pageFromNet = HttpClientService.getResponsePage(url.label +"?search="+name, this.getClass());
        while (pageFromNet.hasNextPage()){
            pageFromNet.addNextPage(httpClient.getResponsePage( pageFromNet.getNextPageURL(), this.getClass()));
        }
        this.count = pageFromNet.count;
        this.results = pageFromNet.results;
    }
    
    
    boolean hasNextPage() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return next!=null;
    }

    String getNextPageURL() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return next;
    }

      void addNextPage (SWAbstractDataPage<T> otherPage)
     {
      next = otherPage.next;
      results.addAll(otherPage.results);
     }
     abstract void Validate();
        
        //next = otherPage.next;
        //results = Stream.concat(Stream.of(results), Stream.of(otherPage.results)).toArray(T[]::new);
         //var xxx = Stream.of(otherPage.results);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    public String hasHits() {
        return count > 0 ? "Ok" : "No hits";
    }
    
    public String hasExactHit(String requiredName) {
        long cnt = results.stream().filter(n -> n.name.equals(requiredName)).count();
        return cnt == 1 ? "Ok" : "No exact hit";
    }
    
    public int getCount(){
        return count;
    }
    
    public List<T> getResults(){
        return results;
    }
    
}
