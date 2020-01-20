/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest;

import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author piko
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(LRestController.class)
public class LRestControllerTest {
    
     @Autowired
    private MockMvc mvc;
     
     @MockBean
    private SWService service;
    
     static Report btm;
     
    public LRestControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        btm = new Report();
        btm.report_id = "1";
        btm.query_criteria_planet_name="Earth";
        btm.query_criteria_character_phrase = "Batman";
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
    public void testGet1() throws Exception {
        
        given(service.getReport("1")).willReturn(btm);
        
        mvc.perform(get("/report/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("Batman")));
               // .andExpect(jsonPath("$.btm.query_criteria_character_phrase"), is("Batman"));
    }
    
    @Test
    public void testGet1Wrong() throws Exception {
        given(service.getReport("1")).willThrow(MyExc.NoSuchRecord.class);
         mvc.perform(get("/report/1").contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().is4xxClientError());
    }
}
