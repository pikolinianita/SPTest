/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.httpClient;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.sobczak.lukasz.spttest.MyExc;

/**
 *
 * @author piko
 */
public class HttpReport2IT {
    
    public HttpReport2IT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of create method, of class HttpReport2.
     */
    @Test
    public void testCreate1Hit() {
        System.out.println("------------IT Report Luke-----------------");
        var report = HttpReport2.create("Luke", "Tatooine");
        assertEquals(1, report.getCharList().size());
        assertEquals("Ok", report.getPlanetsStatus());
        assertEquals(5, report.getFilmList().size());
    }

     @Test
    public void testCreateManyHits(){
        System.out.println("------------IT Report l-----------------");
        var report = HttpReport2.create("l", "Tatooine");
        assertEquals(37, report.getCharList().size());
        assertEquals("Ok", report.getPlanetsStatus());
        assertEquals(7, report.getFilmList().size());
    }
    
     @Test
    public void testWrongGuy(){
        System.out.println("------------IT Report Skywalkerzzz-----------------");
        var exc = assertThrows(MyExc.HttpNameNotCorrect.class,()-> HttpReport2.create("Skywalkerzzz", "Tatooine"));
    }
    
    @Test
    public void testWrongPlanet(){
        System.out.println("------------IT Report Skywalker wrong pl-----------------");
        var exc = assertThrows(MyExc.HttpPlanetNotExist.class,()->HttpReport2.create("Skywalker", "Tatooinezzz"));
    }
       
        
        
        
    
}
