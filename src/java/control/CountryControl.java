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

    public ArrayList<Pais> selectAll() {
        return new ArrayList(Conexao.namedQuery("Pais.findAll"));
    }

}
