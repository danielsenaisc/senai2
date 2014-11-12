/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Pais;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Calandrini
 */
public class CountryControl {

    Pais pais;
    
    public CountryControl() {
    }

    public CountryControl(Pais pais) {
        this.pais = pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }
    
    public boolean hasPais(){
        if(pais == null) return false;
        return true;
    }

    public ArrayList<Pais> selectAll() {
        return new ArrayList(Conexao.namedQuery("Pais.findAll"));
    }

}
