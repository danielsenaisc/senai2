package control;

import java.math.BigDecimal;
import java.util.ArrayList;

import utils.OracleBoolean;
import domain.Produtos;

public class ProductControl {
	
	/**
	 * Retorna todos os produtos cadastrados no banco de dados.
	 * @return Lista de Produtos.
	 */
	public static ArrayList<Produtos> selectAll(){
		return new ArrayList(Conexao.namedQuery("Produtos.findAll"));
	}
	
	/**
	 * Adiciona um produto no banco de dados.
	 * @param produto Produto a ser adicionado no banco.
	 */
	public static void add(Produtos produto){
		Conexao.persist(produto);
	}
	
	/**
	 * Remove permanentemente um produto do banco de dados.
	 * @param produto Produto a ser removido permanentemente no banco.
	 */
	public static void delete(Produtos produto){
		Conexao.remove(produto);
	}
	
	//TODO
	public static void update(BigDecimal codigo){
		//TODO
	}
	
	/**
	 * Retorna todos os produtos que correspondem ao status especificado.
	 * @param status TRUE/FALSE.
	 * @return Uma lista de produtos.
	 */
	public static ArrayList<Produtos> findByStatus(OracleBoolean status){
    	return new ArrayList(Conexao.namedQuery("Produtos.findByStatus", status.getValue(), "status"));
    }
	
	/**
	 * Retorna uma lista de todos os produtos ordenados pelo campo likes de forma decrescente(index0.likes > index1.likes).
	 * @return Uma lista de produtos ordenada.
	 */
	public static ArrayList<Produtos> listByLikes(){
    	return new ArrayList(Conexao.namedQuery("Produtos.selectOrderByLikes"));
    }
	
	/**
	 * Retorna uma lista de produtos ordenada pela quantidade de likes exetuando-se aqueles em que o campo like correponda a NULL(likes = null).
	 * @return Uma lista de produtos.
	 */
	public static ArrayList<Produtos> getBestProducts(){
    	ArrayList<Produtos> result = new ArrayList<Produtos>();
    	
    	for (Produtos produtos : listByLikes()) {
			if(produtos.getLikes() != null) result.add(produtos);
		}

    	return result;
    }
	
	/**
	 * Retorna um produto, no qual o codigo corresponde ao codigo informado, caso nao seja encontrado um produto retorna null.
	 * @param codigo
	 * @return Um produto com codigo correspondente
	 * 		   Caso nao seja encontrado retorna null.
	 */
	 public static Produtos findByCodigo(BigDecimal codigo){
	    	return (Produtos) Conexao.singleResultNamedQuery("Produtos.findByCodigo", codigo, "codigo");
	    }
}
