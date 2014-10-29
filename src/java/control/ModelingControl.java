package control;

import java.math.BigDecimal;
import java.util.ArrayList;

import utils.OracleBoolean;
import domain.Modelagem;
import domain.Produtos;

public class ModelingControl {
    
	/**
	 * Retorna todos as modelagens que correspondem ao status especificado.
	 * @param status Status a ser comparado
	 * @return Uma lista de Modelagem.
	 */
    public ArrayList<Modelagem> findByStatus(OracleBoolean status){
    	return new ArrayList(Conexao.namedQuery("Modelagem.findByStatus", status.getValue(), "status"));    
    }
    
    /**
	 * Retorna todos as modelagens cadastrados no banco de dados.
	 * @return Lista de Modelagens.
	 */
    public ArrayList<Modelagem> sellectAll(){
    	return new ArrayList(Conexao.namedQuery("Modelagem.findAll"));
    }
    
    /** Adiciona uma modelagem no banco de dados.
	 * @param modelagem Modelagem a ser adicionada no banco.
	 */
	public static void add(Modelagem modelagem){
		Conexao.persist(modelagem);
	}
	
	/**
	 * Remove permanentemente uma modelagem do banco de dados.
	 * @param modelagem Modelagem a ser removida permanentemente no banco.
	 */
	public static void delete(Modelagem modelagem){
		Conexao.remove(modelagem);
	}
	
	//TODO
	public static void update(Modelagem modelagem){
		//TODO
	}
	
}
