package control;

import java.util.ArrayList;

import domain.Colecao;
import domain.Estilo;
import domain.Pais;
import domain.Tag;
import java.math.BigDecimal;
import javax.persistence.NoResultException;
import utils.Formatador;
import utils.Genero;
import utils.RadioOptions;

public class CollectionControl {
    
    Colecao colecao;

    public CollectionControl() {
    }

    public CollectionControl(Colecao colecao) {
        this.colecao = colecao;
    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }
    
    public boolean hasColecao(){
        if(colecao == null) return false;
        return true;
    }

    //TODO MELHORAR
    public ArrayList<Colecao> getBestColections() {
        ArrayList<Colecao> result = new ArrayList<Colecao>();

        for (Colecao colecao : listByLikes()) {
            if (colecao.getLikes() != null) {
                result.add(colecao);
            }
        }

        return result;
    }

    /**
     * Retorna uma lista de todos as colecoes ordenadas pelo campo likes de
     * forma decrescente(index0.likes > index1.likes).
     *
     * @return Uma lista de colecoes ordenada.
     */
    public ArrayList<Colecao> listByLikes() {
        return new ArrayList(Conexao.namedQuery("Colecao.selectOrderByLikes"));
    }

    /**
     * Retorna todos as colecoes que correspondem ao status especificado.
     *
     * @param status Status a ser comparado
     * @return Uma lista de colecoes.
     */
    public ArrayList<Colecao> findByStatus(String status) {
        ArrayList<Colecao> listaColecoesPorDescricaoStatus = new ArrayList<Colecao>();

        for (Colecao colecao : selectAll()) {
            if (colecao.getColecaoStatusId().getDescricao().equals(status)) {
                listaColecoesPorDescricaoStatus.add(colecao);
            }
        }

        return listaColecoesPorDescricaoStatus;
    }

    /**
     * Retorna todos as colecoes cadastrados no banco de dados.
     *
     * @return Lista de colecoes.
     */
    public ArrayList<Colecao> selectAll() {
        return new ArrayList(Conexao.namedQuery("Colecao.findAll"));
    }

    /**
     * Adiciona uma colecao no banco de dados.
     *
     * @param colecao Colecao a ser adicionada no banco.
     */
    public void add(Colecao colecao) {
        Conexao.persist(colecao);
    }

    /**
     * Remove permanentemente uma colecao do banco de dados.
     *
     * @param colecao Colecao a ser removida permanentemente no banco.
     */
    public void delete(Colecao colecao) {
        Conexao.remove(colecao);
    }

    //TODO
    public void update(Colecao colecao) {
        //TODO
    }

    public Colecao findById(BigDecimal id) {
        Colecao colecaoDeRetorno = new Colecao();
        try {
            colecaoDeRetorno = (Colecao) Conexao.singleResultNamedQuery("Colecao.findById", id, "id");
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return colecaoDeRetorno;
    }
    
    public String getVigencia(Colecao colecao) {
        //TODO revisar regras de negocio
        if (colecao.getVigenciaInicial() == null) {
            return "N/A";
        }
        if (colecao.getVigenciaFinal() == null) {
            return "N/A";
        }

        long diff = colecao.getVigenciaFinal().getTime() - colecao.getVigenciaInicial().getTime();
        return (diff / (1000 * 60 * 60 * 24)) + " dias";
    }

    public String getListaDeTagsTratada(Colecao colecao) {
        String retorno = "";
        if (colecao.getTagList().size() <= 0) {
            return retorno;
        }

        for (Tag tagList1 : colecao.getTagList()) {
            retorno += (tagList1.getDescricao() + ",");
        }
        retorno = retorno.substring(0, retorno.length() - 1);
        return retorno;
    }

    public String getListaDePaisesTratada(Colecao colecao) {
        String retorno = "";
        if (colecao.getPaisList().size() <= 0) {
            return retorno;
        }

        for (Pais paisList1 : colecao.getPaisList()) {
            retorno += (paisList1.getNome() + ",");
        }
        retorno = retorno.substring(0, retorno.length() - 1);
        return retorno;
    }

    public String getListaDeEstilosTratada(Colecao colecao) {
        String retorno = "";
        if (colecao.getEstiloList().size() <= 0) {
            return retorno;
        }

        for (Estilo estiloList1 : colecao.getEstiloList()) {
            retorno += (estiloList1.getDescricao() + ",");
        }

        retorno = retorno.substring(0, retorno.length() - 1);
        return retorno;
    }

    public String isMascChecked(Colecao colecao) {
        if (colecao.getGenero().equals(Genero.MASCULINO.getDescricao())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String isFemChecked(Colecao colecao) {
        if (colecao.getGenero().equals(Genero.FEMININO.getDescricao())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String isUnissexChecked(Colecao colecao) {
        if (colecao.getId() == null) {
            return RadioOptions.CHECKED.getOption();
        }
        if (colecao.getGenero().equals(Genero.UNISSEX.getDescricao())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }
    
    public String getVigenciaInicialTratada(Colecao colecao){
        return Formatador.formataData(colecao.getVigenciaInicial());
    }
    
    public String getVigenciaFinalTratada(Colecao colecao){
        return Formatador.formataData(colecao.getVigenciaFinal());
    }

}
