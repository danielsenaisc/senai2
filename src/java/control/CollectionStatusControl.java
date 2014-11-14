/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.ColecaoStatus;
import java.util.ArrayList;

/**
 *
 * @author IST-08-PC
 */
public class CollectionStatusControl {
    
    ColecaoStatus colecaoStatus;

    public CollectionStatusControl() {
    }

    public CollectionStatusControl(ColecaoStatus colecaoStatus) {
        this.colecaoStatus = colecaoStatus;
    }

    public ColecaoStatus getColecaoStatus() {
        return colecaoStatus;
    }

    public void setColecaoStatus(ColecaoStatus colecaoStatus) {
        this.colecaoStatus = colecaoStatus;
    }
    
    public boolean hasColecaoStatus(){
        if(colecaoStatus == null) return false;
        return true;
    }

    public ArrayList<ColecaoStatus> selectAll() {
        return new ArrayList(Conexao.namedQuery("ColecaoStatus.findAll"));
    }

    public ColecaoStatus findByDescricao(String descricao){
        ColecaoStatus colecaoStatusDeRetorno = new ColecaoStatus();
        try {
            colecaoStatusDeRetorno = (ColecaoStatus) Conexao.singleResultNamedQuery("ColecaoStatus.findByDescricao", descricao, "descricao");
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return colecaoStatusDeRetorno;
    }
}
