/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.domain;

/**
 *
 * @author piko
 * Solid class for Film data. 
 * name and url inherited
 */
@lombok.ToString
@lombok.Getter
public class SWFilm extends SWAbstractPayload{
   // String url, name;
    String episode_id;
    String title;
}
