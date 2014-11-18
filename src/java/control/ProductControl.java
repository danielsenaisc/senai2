package control;

import java.math.BigDecimal;
import java.util.ArrayList;

import utils.OracleBoolean;
import domain.Produtos;
import domain.Tag;
import javax.persistence.NoResultException;
import utils.Genero;
import utils.RadioOptions;

public class ProductControl {
    
    Produtos produtos;

    public ProductControl() {
    }

    public ProductControl(Produtos produtos) {
        this.produtos = produtos;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }
    
    public boolean hasProduto(){
        if(produtos == null) return false;
        return true;
    }

    /**
     * Retorna todos os produtos cadastrados no banco de dados.
     *
     * @return Lista de Produtos.
     */
    public ArrayList<Produtos> selectAll() {
        return new ArrayList(Conexao.namedQuery("Produtos.findAll"));
    }

    /**
     * Adiciona um produto no banco de dados.
     *
     * @param produto Produto a ser adicionado no banco.
     */
    public void add(Produtos produtos) {
        Conexao.persist(produtos);
    }

    /**
     * Remove permanentemente um produto do banco de dados.
     *
     * @param produto Produto a ser removido permanentemente no banco.
     */
    public void delete(Produtos produtos) {
        Conexao.remove(produtos);
    }

    //TODO
    public void update(BigDecimal id) {
        //TODO
    }

    /**
     * Retorna todos os produtos que correspondem ao status especificado.
     *
     * @param status TRUE/FALSE.
     * @return Uma lista de produtos.
     */
    public ArrayList<Produtos> findByStatus(OracleBoolean status) {
        return new ArrayList(Conexao.namedQuery("Produtos.findByStatus", status.getValue(), "status"));
    }

    /**
     * Retorna uma lista de todos os produtos ordenados pelo campo likes de
     * forma decrescente(index0.likes > index1.likes).
     *
     * @return Uma lista de produtos ordenada.
     */
    public ArrayList<Produtos> listByLikes() {
        return new ArrayList(Conexao.namedQuery("Produtos.selectOrderByLikes"));
    }

    /**
     * Retorna uma lista de produtos ordenada pela quantidade de likes
     * exetuando-se aqueles em que o campo like correponda a NULL(likes = null).
     *
     * @return Uma lista de produtos.
     */
    public ArrayList<Produtos> getBestProducts() {
        ArrayList<Produtos> result = new ArrayList<Produtos>();

        for (Produtos produtos : listByLikes()) {
            if (produtos.getLikes() != null) {
                result.add(produtos);
            }
        }

        return result;
    }

    /**
     * Retorna um produto, no qual o id corresponde ao id informado, caso nao
     * seja encontrado um produto retorna null.
     *
     * @param id
     * @return Um produto com id correspondente Caso nao seja encontrado retorna
     * null.
     */
    public Produtos findById(BigDecimal id) {
        Produtos produtoDeRetorno = new Produtos();

        try {
            produtoDeRetorno = (Produtos) Conexao.singleResultNamedQuery("Produtos.findById", id, "id");
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        return produtoDeRetorno;
    }
    
    public String getListaDeTagsTratada(Produtos produtos) {
        String retorno = "";
        if (produtos.getTagList().size() <= 0) {
            return retorno;
        }

        for (Tag tagList1 : produtos.getTagList()) {
            retorno += (tagList1.getDescricao() + ",");
        }

        retorno = retorno.substring(0, retorno.length() - 1);

        return retorno;
    }

    public String isMascChecked(Produtos produtos) {
        if (produtos.getGenero().equals(Genero.MASCULINO.getDescricao())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String isFemChecked(Produtos produtos) {
        if (produtos.getGenero().equals(Genero.FEMININO.getDescricao())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String isUnissexChecked(Produtos produtos) {
        if (produtos.getGenero().equals(Genero.UNISSEX.getDescricao())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String isActiveChecked(Produtos produtos) {
        if (produtos.getStatus().equals(OracleBoolean.TRUE.getValue())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String isInactiveChecked(Produtos produtos) {
        if (produtos.getStatus().equals(OracleBoolean.FALSE.getValue())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }      
    
    public String isActive(Produtos produtos) {
        if (produtos.getId() == null) {
            return RadioOptions.CHECKED.getOption();
        }
        if (produtos.getStatus().equals(OracleBoolean.TRUE.getValue())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String isInactive(Produtos produtos) {
        if (produtos.getStatus().equals(OracleBoolean.FALSE.getValue())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }    
    
    public String getStatusTratado(Produtos produtos) {
        if (produtos.getStatus().equals(OracleBoolean.TRUE.getValue())) {
            return "Ativo";
        }
        return "Inativo";
    }
    
    //TODO rever Regras de Negocio
    public int getQuantidadeVariantes() {
        return 0;
    }
}
