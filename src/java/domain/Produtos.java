/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import utils.Genero;
import utils.OracleBoolean;

/**
 *
 * @author IST-08-PC
 */
@Entity
@Table(name = "PRODUTOS", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findById", query = "SELECT p FROM Produtos p WHERE p.id = :id"),
    @NamedQuery(name = "Produtos.findByNome", query = "SELECT p FROM Produtos p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produtos.findByStatus", query = "SELECT p FROM Produtos p WHERE p.status = :status"),
    @NamedQuery(name = "Produtos.findByGenero", query = "SELECT p FROM Produtos p WHERE p.genero = :genero"),
    @NamedQuery(name = "Produtos.findByReferencia", query = "SELECT p FROM Produtos p WHERE p.referencia = :referencia"),
    @NamedQuery(name = "Produtos.findByDescricao", query = "SELECT p FROM Produtos p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produtos.findByLikes", query = "SELECT p FROM Produtos p WHERE p.likes = :likes"),
    @NamedQuery(name = "Produtos.findByDislikes", query = "SELECT p FROM Produtos p WHERE p.dislikes = :dislikes")})
@NamedQuery(name = "Produtos.selectOrderByLikes", query = "SELECT p FROM Produtos p ORDER BY likes")
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTOS_SEQ")
    @SequenceGenerator(name = "PRODUTOS_SEQ", sequenceName = "PRODUTOS_SEQ")
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Column(name = "NOME", length = 100)
    private String nome;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "GENERO")
    private Character genero;
    @Column(name = "REFERENCIA", length = 500)
    private String referencia;
    @Column(name = "DESCRICAO", length = 500)
    private String descricao;
    @Column(name = "LIKES")
    private Long likes;
    @Column(name = "DISLIKES")
    private Long dislikes;
    @ManyToMany(mappedBy = "produtosList", fetch = FetchType.LAZY)
    private List<Tag> tagList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtosId", fetch = FetchType.LAZY)
    private List<TipoMedidaProdutos> tipoMedidaProdutosList;
    @JoinColumn(name = "COLECAO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Colecao colecaoId;
    @JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Categoria categoriaId;

    public Produtos() {
    }

    public Produtos(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNome() {
        if (nome == null) {
            return "";
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getStatus() {
        if (status == null) {
            return ' ';
        }
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getGenero() {
        if (genero == null) {
            return ' ';
        }
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getReferencia() {
        if (referencia == null) {
            return "";
        }
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        if (descricao == null) {
            return "";
        }
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getLikes() {
        if (likes == null) {
            return 0l;
        }
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        if (dislikes == null) {
            return 0l;
        }
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    @XmlTransient
    public List<Tag> getTagList() {
        if (tagList == null) {
            return new ArrayList();
        }
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @XmlTransient
    public List<TipoMedidaProdutos> getTipoMedidaProdutosList() {
        if (tipoMedidaProdutosList == null) {
            return new ArrayList();
        }
        return tipoMedidaProdutosList;
    }

    public void setTipoMedidaProdutosList(List<TipoMedidaProdutos> tipoMedidaProdutosList) {
        this.tipoMedidaProdutosList = tipoMedidaProdutosList;
    }

    public Colecao getColecaoId() {
        return colecaoId;
    }

    public void setColecaoId(Colecao colecaoId) {
        this.colecaoId = colecaoId;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Produtos[ id=" + id + " ]";
    }

    public String getListaDeTagsTratada() {
        String retorno = "";
        if (getTagList().size() <= 0) {
            return retorno;
        }

        for (Tag tagList1 : getTagList()) {
            retorno += (tagList1.getDescricao() + ",");
        }

        retorno = retorno.substring(0, retorno.length() - 1);

        return retorno;
    }

    public String isMascChecked() {
        if (getGenero().equals(Genero.MASCULINO.getDescricao())) {
            return "checked";
        }
        return "";
    }

    public String isFemChecked() {
        if (getGenero().equals(Genero.FEMININO.getDescricao())) {
            return "checked";
        }
        return "";
    }

    public String isUnissexChecked() {
        if (getGenero().equals(Genero.UNISSEX.getDescricao())) {
            return "checked";
        }
        return "";
    }

    public String isActiveChecked() {
        if (getStatus().equals(OracleBoolean.TRUE.getValue())) {
            return "checked";
        }
        return "";
    }

    public String isInactiveChecked() {
        if (getStatus().equals(OracleBoolean.FALSE.getValue())) {
            return "checked";
        }
        return "";
    }

    //TODO rever Regras de Negocio
    public int getQuantidadeVariantes() {
        return 0;
    }

    public String getStatusTratado() {
        if (getStatus().equals(OracleBoolean.TRUE.getValue())) {
            return "Ativo";
        }
        return "Inativo";
    }
    
    public String isActive() {
        if (id == null) {
            return "checked";
        }
        if (getStatus().equals(OracleBoolean.TRUE.getValue())) {
            return "checked";
        }
        return "";
    }

    public String isInactive() {
        if (getStatus().equals(OracleBoolean.FALSE.getValue())) {
            return "checked";
        }
        return "";
    }

}
