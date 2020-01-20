/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest.domain;

/**
 *
 * @author piko
 * Abstract class for classes used as parameters for SWAbstractDataPage.
 * url is used by database as unique ID
 */
@lombok.Getter
public abstract class SWAbstractPayload {
    String name, url;
}
