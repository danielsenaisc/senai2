package control;

import java.util.ArrayList;

import domain.Colecao;
import java.math.BigDecimal;

public class CollectionControl {

	
	//TODO MELHORAR
    public ArrayList<Colecao> getBestColections(){
    	ArrayList<Colecao> result = new ArrayList<Colecao>();
    	
    	for (Colecao colecao : listByLikes()) {
			if(colecao.getLikes() != null) result.add(colecao);
		}
    	
    	return result;
    }
    
    /**
	 * Retorna uma lista de todos as colecoes ordenadas pelo campo likes de forma decrescente(index0.likes > index1.likes).
	 * @return Uma lista de colecoes ordenada.
	 */
    public ArrayList<Colecao> listByLikes(){
    	return new ArrayList(Conexao.namedQuery("Colecao.selectOrderByLikes"));
    }
    
    /**
	 * Retorna todos as colecoes que correspondem ao status especificado.
	 * @param status Status a ser comparado
	 * @return Uma lista de colecoes.
	 */
    public ArrayList<Colecao> findByStatus(String status){
    	ArrayList<Colecao> listaColecoesPorDescricaoStatus = new ArrayList<Colecao>();

    	for (Colecao colecao : selectAll()) {
			if(colecao.getColecaoStatusId().getDescricao().equals(status))listaColecoesPorDescricaoStatus.add(colecao);	
		}
    	
    	return listaColecoesPorDescricaoStatus;
    }
	
    /**
	 * Retorna todos as colecoes cadastrados no banco de dados.
	 * @return Lista de colecoes.
	 */
    public ArrayList<Colecao> selectAll(){
    	return new ArrayList(Conexao.namedQuery("Colecao.findAll"));
    }
    

    /** Adiciona uma colecao no banco de dados.
	 * @param colecao Colecao a ser adicionada no banco.
	 */
	public static void add(Colecao colecao){
		Conexao.persist(colecao);
	}
	
	/**
	 * Remove permanentemente uma colecao do banco de dados.
	 * @param colecao Colecao a ser removida permanentemente no banco.
	 */
	public static void delete(Colecao colecao){
		Conexao.remove(colecao);
	}
	
	//TODO
	public static void update(Colecao colecao){
		//TODO
	}
        
        public Colecao findById(BigDecimal id){
            return (Colecao) Conexao.singleResultNamedQuery("Colecao.findById", id, "id");        
        }
	
}
