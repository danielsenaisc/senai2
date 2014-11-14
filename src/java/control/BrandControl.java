package control;

import domain.Colecao;
import domain.Estilo;
import java.util.ArrayList;

import domain.Marca;
import domain.Pais;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.NoResultException;
import utils.Formatador;
import utils.Genero;
import utils.OracleBoolean;
import utils.RadioOptions;

public class BrandControl {
    
    Marca marca;

    public BrandControl() {
    }

    public BrandControl(Marca marca) {
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    public boolean hasMarca(){
        if(marca == null) return false;
        return true;
    }

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

    public int getQuantidadeProdutos(Marca marca) {
        int quantidadeDeProdutos = 0;

        for (Colecao colecaoList : marca.getColecaoList()) {
            quantidadeDeProdutos += colecaoList.getProdutosList().size();
        }

        return quantidadeDeProdutos;
    }

    public String getStatusTratado(Marca marca) {
        if (marca.getStatus().equals(OracleBoolean.TRUE.getValue())) {
            return "Ativo";
        }
        return "Inativo";
    }

    public String getDataCriacaoTratada(Marca marca) {
        return Formatador.formataData(marca.getDataCriacao());
    }

    public String isMascChecked(Marca marca) {
        if (marca.getGenero().equals(Genero.MASCULINO.getDescricao())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String isFemChecked(Marca marca) {
        if (marca.getGenero().equals(Genero.FEMININO.getDescricao())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String isUnissexChecked(Marca marca) {
        //retorno default para marcasVazias;
        if (marca.getId() == null) {
            return RadioOptions.CHECKED.getOption();
        }
        if (marca.getGenero().equals(Genero.UNISSEX.getDescricao())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    public String getEstiloListTratado(Marca marca) {
        String retorno = "";

        if (marca.getEstiloList().size() <= 0) {
            return retorno;
        }

        for (Estilo style : marca.getEstiloList()) {
            retorno += (style.getDescricao() + ",");
        }

        retorno = retorno.substring(0, retorno.length() - 1);

        return retorno;
    }

    public String getLocationsListTratado(Marca marca) {
        String retorno = "";

        if (marca.getPaisList().size() <= 0) {
            return retorno;
        }

        for (Pais location : marca.getPaisList()) {
            retorno += (location.getNome() + ",");
        }

        retorno = retorno.substring(0, retorno.length() - 1);

        return retorno;
    }

    public Pais getDefaultCountry(Marca marca) {
        //TODO implementar regra para retorno de Marca > Pais
        return new Pais();
    }

    public String isActive(Marca marca) {
        //retorno default para marcasVazias;
        if (getMarca().getId() == null) {
            return RadioOptions.CHECKED.getOption();
        }
        if (getMarca().getStatus().equals(OracleBoolean.TRUE.getValue())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }
    
    public String isInactive(Marca marca) {
        if (getMarca().getStatus().equals(OracleBoolean.FALSE.getValue())) {
            return RadioOptions.CHECKED.getOption();
        }
        return RadioOptions.UNCHECkED.getOption();
    }

    //TODO revisar
    public void setDataCriacao(String dataCriacao) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            getMarca().setDataCriacao(simpleDateFormat.parse(dataCriacao));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    public Marca findByDescricao(String descricao){
        Marca marcaDeRetorno = new Marca();
        try {
            marcaDeRetorno = (Marca) Conexao.singleResultNamedQuery("Marca.findByDescricao", descricao, "descricao");
        } catch (Exception e) {
            e.getStackTrace();
        }
        return marcaDeRetorno;
    }
    
}
