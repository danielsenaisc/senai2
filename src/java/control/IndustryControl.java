/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Industria;
import java.math.BigDecimal;

/**
 *
 * @author Gustavo Calandrini
 */
public class IndustryControl {

    public Industria findById(BigDecimal id) {
        return (Industria) Conexao.singleResultNamedQuery("Industria.findById", id, "id");
    }

}
