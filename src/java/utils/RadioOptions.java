/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Gustavo Calandrini
 */
public enum RadioOptions {
    
    CHECKED("checked"),
    UNCHECkED("");

    String option;
    
    private RadioOptions(String option) {
    this.option = option;
    }

    public String getOption() {
        return option;
    }
    
}
