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
 */
@lombok.Getter
public class SWCharacter extends SWAbstractPayload {
    String homeworld; //name, url
    String[] films;

    //public SWCharacter() {
   // }

    
    
    @Override
    public String toString() {
        return "SWCharacter{" + "name=" + name + ", homeworld=" + homeworld + ", films=" + Arrays.toString(films) + '}' + System.lineSeparator();
    }
}
