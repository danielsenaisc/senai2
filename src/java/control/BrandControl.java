package control;

import java.util.ArrayList;

import domain.Marca;
import javax.persistence.NoResultException;

public class BrandControl {

    /**
     * Retorna todos as marcas cadastradas no banco de dados.
     *
     * @return Lista de Marcas.
     */
    public ArrayList<Marca> selectAll() {
        return new ArrayList(Conexao.namedQuery("Marca.findAll"));
    }

    /**
     * Adiciona uma marca no banco de dados.
     *
     * @param marca Marca a ser adicionada no banco.
     */
    public void add(Marca marca) throws NullPointerException {
        if (hasNullValues(marca)) {
            throw new NullPointerException();
        }
        Conexao.persist(marca);
    }

    /**
     * Remove permanentemente uma marca do banco de dados.
     *
     * @param marca Marca a ser removida permanentemente no banco.
     */
    public void delete(Marca marca) {
        Conexao.remove(marca);
    }

    //TODO
    public void update(Marca marca) {

    }

    public Marca findById(Long id) {
        Marca marcaDeRetorno = new Marca();
        try {
            marcaDeRetorno = (Marca) Conexao.singleResultNamedQuery("Marca.findById", id, "id");
        } catch (NoResultException e) {
            //TODO tratar
            e.printStackTrace();
        }
        return marcaDeRetorno;
    }

    private boolean hasNullValues(Marca marca) {
        if (marca.getNome().equals("")) {
            return true;
        }
        System.out.println("nome ok");
        if (marca.getDataCriacao() == null) {
            return true;
        }
        System.out.println("data ok");
        if (marca.getIdadeInicial() == 0l) {
            return true;
        }
        System.out.println("idade inicial ok");
        if (marca.getIdadeFinal() == 0l) {
            return true;
        }
        System.out.println("idade final ok");
        if (marca.getStatus().equals(' ')) {
            return true;
        }
        System.out.println("status ok");
        if (marca.getIndustriaId() == null) {
            return true;
        }
        System.out.println("industriaID ok");
        return false;
    }

}
