package control;

import java.math.BigDecimal;
import java.util.ArrayList;

import utils.OracleBoolean;
import domain.Modelagem;
import domain.Produtos;
import javax.persistence.NoResultException;

public class ModelingControl {

    /**
     * Retorna todos as modelagens que correspondem ao status especificado.
     *
     * @param status Status a ser comparado
     * @return Uma lista de Modelagem.
     */
    public ArrayList<Modelagem> findByStatus(OracleBoolean status) {
        return new ArrayList(Conexao.namedQuery("Modelagem.findByStatus", status.getValue(), "status"));
    }

    /**
     * Retorna todos as modelagens cadastrados no banco de dados.
     *
     * @return Lista de Modelagens.
     */
    public ArrayList<Modelagem> selectAll() {
        return new ArrayList(Conexao.namedQuery("Modelagem.findAll"));
    }

    /**
     * Adiciona uma modelagem no banco de dados.
     *
     * @param modelagem Modelagem a ser adicionada no banco.
     */
    public void add(Modelagem modelagem) {
        Conexao.persist(modelagem);
    }

    /**
     * Remove permanentemente uma modelagem do banco de dados.
     *
     * @param modelagem Modelagem a ser removida permanentemente no banco.
     */
    public void delete(Modelagem modelagem) {
        Conexao.remove(modelagem);
    }

    //TODO
    public static void update(Modelagem modelagem) {
        //TODO
    }

    public Modelagem findById(BigDecimal id) {
        Modelagem modelagemDeRetorno = new Modelagem();
        try {
            modelagemDeRetorno = (Modelagem) Conexao.singleResultNamedQuery("Modelagem.findById", id, "id");
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return modelagemDeRetorno;
    }
}
