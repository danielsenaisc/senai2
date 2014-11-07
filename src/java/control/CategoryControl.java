/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Categoria;
import java.util.ArrayList;
import javax.persistence.NoResultException;

/**
 *
 * @author IST-08-PC
 */
public class CategoryControl {

    public ArrayList<Categoria> selectAll() {
        return new ArrayList(Conexao.namedQuery("Categoria.findAll"));
    }
    
    public Categoria findById(Long id) {
        Categoria marcaDeRetorno = new Categoria();
        
        try {
            marcaDeRetorno = (Categoria) Conexao.singleResultNamedQuery("Categoria.findById", id, "id");
        } catch (NoResultException e) {
            e.printStackTrace();
        }       
        return marcaDeRetorno;
    }
    
}
