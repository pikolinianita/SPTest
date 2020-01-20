/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 *
 * @author piko
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SWServiceTest {
     
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private SWReportRepository sWRepository;
    
    public SWServiceTest() {
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

    @Test
    public void testGetReport() {
        
        Report r = new Report();
        r.report_id = "1";
        r.query_criteria_planet_name="Earth";
        r.query_criteria_character_phrase = "Batman";
        
        entityManager.persist(r);
        entityManager.flush();
        
        var rep = sWRepository.findById("1").get();
        assertEquals("Earth", rep.query_criteria_planet_name);
    }
    
    
}
