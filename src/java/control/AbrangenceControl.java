/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Abrangencia;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Calandrini
 */
public class AbrangenceControl {
    
    private Abrangencia abrangencia;

    public AbrangenceControl() {
    }

    public AbrangenceControl(Abrangencia abrangencia) {
        this.abrangencia = abrangencia;
    }
     
    public boolean hasAbrangencia(){
        if(abrangencia == null) return false;
        return true;
    }

    public void setAbrangencia(Abrangencia abrangencia) {
        this.abrangencia = abrangencia;
    }

    public Abrangencia getAbrangencia() {
        return abrangencia;
    }
    
    /**
     * Retorna todos as Abrangencias cadastradas no banco de dados.
     *
     * @return Lista de Abrangencias.
     */
    public ArrayList<Abrangencia> selectAll() {
        return new ArrayList(Conexao.namedQuery("Abrangencia.findAll"));
    }
}
