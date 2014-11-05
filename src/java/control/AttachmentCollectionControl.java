/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.AnexoColecao;
import java.util.ArrayList;

/**
 *
 * @author IST-08-PC
 */
public class AttachmentCollectionControl {
    
    public ArrayList<AnexoColecao> selectAll(){       
        return new ArrayList(Conexao.namedQuery("AnexoColecao.findAll"));
    }
    
}
