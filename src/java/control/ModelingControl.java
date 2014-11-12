package control;

import java.math.BigDecimal;
import java.util.ArrayList;
import utils.OracleBoolean;
import domain.Modelagem;
import java.util.Objects;
import javax.persistence.NoResultException;
import utils.Genero;

public class ModelingControl {
    
    Modelagem modelagem;

    public ModelingControl() {
    }

    public ModelingControl(Modelagem modelagem) {
        this.modelagem = modelagem;
    }

    public Modelagem getModelagem() {
        return modelagem;
    }

    public void setModelagem(Modelagem modelagem) {
        this.modelagem = modelagem;
    }
    
    public boolean hasModelagem(){
        if(modelagem == null) return false;
        return true;
    }

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
        if (hasNullValues(modelagem)) {
            throw new NullPointerException();
        }
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

    private boolean hasNullValues(Modelagem modelagem) {
        if (modelagem.getNome().equals("")) {
            return true;
        }
        System.out.println("nome ok");

        if (modelagem.getGenero().equals(' ')) {
            return true;
        }
        System.out.println("genero ok");

        if (modelagem.getDescricao().equals("")) {
            return true;
        }
        System.out.println("descricao ok");

        if (modelagem.getStatus().equals(' ')) {
            return true;
        }
        System.out.println("status ok");

        if (modelagem.getIdInternoIndustria().equals("")) {
            return true;
        }
        System.out.println("idInternoIndustri ok");

        return false;
    }
    
    //TODO Rever Regra de Negócio
    public int getQuantidadeDeColecoes(Modelagem modelagem) {
        return 0;
    }

    //TODO Rever Regra de Negócio
    public int getQuantidadeDeProdutos(Modelagem modelagem) {
        return 0;
    }

    public String getStatusTratado(Modelagem modelagem) {
        if (Objects.equals(modelagem.getStatus(), OracleBoolean.TRUE.getValue())) {
            return "Ativo";
        }
        return "Inativo";
    }

    public String isMascChecked(Modelagem modelagem) {
        if (modelagem.getGenero().equals(Genero.MASCULINO.getDescricao())) {
            return "checked";
        }
        return "";
    }

    public String isFemChecked(Modelagem modelagem) {
        if (modelagem.getGenero().equals(Genero.FEMININO.getDescricao())) {
            return "checked";
        }
        return "";
    }

    public String isUnissexChecked(Modelagem modelagem) {
        if (modelagem.getId() == null) {
            return "checked";
        }
        if (modelagem.getGenero().equals(Genero.UNISSEX.getDescricao())) {
            return "checked";
        }
        return "";
    }

    public String isActive(Modelagem modelagem) {
        if (modelagem.getId() == null) {
            return "checked";
        }
        if (modelagem.getStatus().equals(OracleBoolean.TRUE.getValue())) {
            return "checked";
        }
        return "";
    }

    public String isInactive(Modelagem modelagem) {
        if (modelagem.getStatus().equals(OracleBoolean.FALSE.getValue())) {
            return "checked";
        }
        return "";
    }
}
