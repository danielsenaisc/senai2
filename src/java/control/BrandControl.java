package control;

import java.util.ArrayList;

import domain.Colecao;
import domain.Marca;

public class BrandControl {
	
	/**
	 * Retorna todos as marcas cadastradas no banco de dados.
	 * @return Lista de Marcas.
	 */
	public ArrayList<Marca> selectAll() {
        return new ArrayList(Conexao.namedQuery("Marca.findAll"));
    }

    /** Adiciona uma marca no banco de dados.
	 * @param marca Marca a ser adicionada no banco.
	 */
	public static void add(Marca marca){
		Conexao.persist(marca);
	}
	
	/**
	 * Remove permanentemente uma marca do banco de dados.
	 * @param marca Marca a ser removida permanentemente no banco.
	 */
	public static void delete(Marca marca){
		Conexao.remove(marca);
	}
	
	//TODO
	public static void update(Marca marca){
		//TODO
	}
	
}