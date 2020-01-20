/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest;

import lombok.Data;

/**
 *
 * @author piko
 * keeps data from GET query from REST API. 
 */

@Data
public class RestQuery {
   String query_criteria_character_phrase;
   String query_criteria_planet_name;
}
