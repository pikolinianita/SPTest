/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.domain;

/**
 *
 * @author piko
 * Solid class for planets data. 
 * name and url inherited
 */
@lombok.Getter
public class SWPlanets extends SWAbstractPayload{
    
    @Override
    public String toString() {
        return "SWPlanets{" + "name=" + name + ", url=" + url + '}' + System.lineSeparator();
    }
}
