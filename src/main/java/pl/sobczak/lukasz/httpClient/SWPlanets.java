/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.httpClient;

/**
 *
 * @author piko
 */
@lombok.Getter
public class SWPlanets extends SWAbstractPayload{
    // String name, url;

    @Override
    public String toString() {
        return "SWPlanets{" + "name=" + name + ", url=" + url + '}' + System.lineSeparator();
    }
}