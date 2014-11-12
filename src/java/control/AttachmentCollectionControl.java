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

    private AnexoColecao anexoColecao;

    public AttachmentCollectionControl() {
    }

    public AttachmentCollectionControl(AnexoColecao anexoColecao) {
        this.anexoColecao = anexoColecao;
    }
    
    public AnexoColecao getAnexoColecao() {
        return anexoColecao;
    }

    public void setAnexoColecao(AnexoColecao anexoColecao) {
        this.anexoColecao = anexoColecao;
    }

    public boolean hasAnexoColecao() {
        if (anexoColecao == null) {
            return false;
        }
        return true;
    }

    public ArrayList<AnexoColecao> selectAll() {
        return new ArrayList(Conexao.namedQuery("AnexoColecao.findAll"));
    }

}
