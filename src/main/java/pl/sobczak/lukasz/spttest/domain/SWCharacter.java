/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.domain;

import java.util.Arrays;

/**
 *
 * @author piko
 * Solid class for character data. 
 * name and url inherited
 * films later used for query SWApi/films
 */
@lombok.Getter
public class SWCharacter extends SWAbstractPayload {
    String homeworld; 
    String[] films;

      
    
    @Override
    public String toString() {
        return "SWCharacter{" + "name=" + name + ", homeworld=" + homeworld + ", films=" + Arrays.toString(films) + '}' + System.lineSeparator();
    }
}
