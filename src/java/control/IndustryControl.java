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
    
    Industria industria;

    public IndustryControl() {
    }

    public IndustryControl(Industria industria) {
        this.industria = industria;
    }

    public void setIndustria(Industria industria) {
        this.industria = industria;
    }

    public Industria getIndustria() {
        return industria;
    }
    
    public boolean hasIndustria(){
        if(industria == null) return false;
        return true;
    }

    public Industria findById(BigDecimal id) {
        return (Industria) Conexao.singleResultNamedQuery("Industria.findById", id, "id");
    }

}
