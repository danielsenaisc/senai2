/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import utils.Formatador;
import utils.Genero;
import utils.RadioOptions;

/**
 *
 * @author IST-08-PC
 */
@Entity
@Table(name = "COLECAO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colecao.findAll", query = "SELECT c FROM Colecao c"),
    @NamedQuery(name = "Colecao.findById", query = "SELECT c FROM Colecao c WHERE c.id = :id"),
    @NamedQuery(name = "Colecao.findByNome", query = "SELECT c FROM Colecao c WHERE c.nome = :nome"),
    @NamedQuery(name = "Colecao.findByVigenciaInicial", query = "SELECT c FROM Colecao c WHERE c.vigenciaInicial = :vigenciaInicial"),
    @NamedQuery(name = "Colecao.findByVigenciaFinal", query = "SELECT c FROM Colecao c WHERE c.vigenciaFinal = :vigenciaFinal"),
    @NamedQuery(name = "Colecao.findByDescricao", query = "SELECT c FROM Colecao c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Colecao.findByIdadeInicial", query = "SELECT c FROM Colecao c WHERE c.idadeInicial = :idadeInicial"),
    @NamedQuery(name = "Colecao.findByIdadeFinal", query = "SELECT c FROM Colecao c WHERE c.idadeFinal = :idadeFinal"),
    @NamedQuery(name = "Colecao.findByGenero", query = "SELECT c FROM Colecao c WHERE c.genero = :genero"),
    @NamedQuery(name = "Colecao.findByIdLivre", query = "SELECT c FROM Colecao c WHERE c.idLivre = :idLivre"),
    @NamedQuery(name = "Colecao.findByLikes", query = "SELECT c FROM Colecao c WHERE c.likes = :likes"),
    @NamedQuery(name = "Colecao.findByDislikes", query = "SELECT c FROM Colecao c WHERE c.dislikes = :dislikes")})
@NamedQuery(name = "Colecao.selectOrderByLikes", query = "SELECT c FROM Colecao c ORDER BY likes")
public class Colecao implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLECAO_SEQ")
    @SequenceGenerator(name = "COLECAO_SEQ", sequenceName = "COLECAO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;
    @Column(name = "VIGENCIA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenciaInicial;
    @Column(name = "VIGENCIA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenciaFinal;
    @Column(name = "DESCRICAO", length = 200)
    private String descricao;
    @Column(name = "IDADE_INICIAL")
    private Long idadeInicial;
    @Column(name = "IDADE_FINAL")
    private Long idadeFinal;
    @Column(name = "GENERO")
    private Character genero;
    @Column(name = "ID_LIVRE", length = 45)
    private String idLivre;
    @Column(name = "LIKES")
    private Long likes;
    @Column(name = "DISLIKES")
    private Long dislikes;
    @JoinTable(name = "TAG_COLECAO", joinColumns = {
        @JoinColumn(name = "COLECAO_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "TAG_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tag> tagList;
    @JoinTable(name = "PAIS_COLECAO", joinColumns = {
        @JoinColumn(name = "COLECAO_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "PAIS_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Pais> paisList;
    @JoinTable(name = "ESTILO_COLECAO", joinColumns = {
        @JoinColumn(name = "COLECAO_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "ESTILO_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Estilo> estiloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colecaoId", fetch = FetchType.LAZY)
    private List<AnexoColecao> anexoColecaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colecaoId", fetch = FetchType.LAZY)
    private List<Produtos> produtosList;
    @JoinColumn(name = "MARCA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Marca marcaId;
    @JoinColumn(name = "COLECAO_STATUS_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ColecaoStatus colecaoStatusId;

    public Colecao() {
    }

    public Colecao(BigDecimal id) {
        this.id = id;
    }

    public Colecao(BigDecimal id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Date getVigenciaInicial() {
        if (vigenciaInicial == null) {
            return new Date();
        }
        return vigenciaInicial;
    }

    public void setVigenciaInicial(Date vigenciaInicial) {
        this.vigenciaInicial = vigenciaInicial;
    }

    public Date getVigenciaFinal() {
        if (vigenciaFinal == null) {
            return new Date();
        }
        return vigenciaFinal;
    }

    public void setVigenciaFinal(Date vigenciaFinal) {
        this.vigenciaFinal = vigenciaFinal;
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

    public Long getIdadeInicial() {
        if (idadeInicial == null) {
            return 1l;
        }
        return idadeInicial;
    }

    public void setIdadeInicial(Long idadeInicial) {
        this.idadeInicial = idadeInicial;
    }

    public Long getIdadeFinal() {
        if (idadeFinal == null) {
            return 1l;
        }
        return idadeFinal;
    }

    public void setIdadeFinal(Long idadeFinal) {
        this.idadeFinal = idadeFinal;
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

    public String getIdLivre() {
        if (idLivre == null) {
            return "";
        }
        return idLivre;
    }

    public void setIdLivre(String idLivre) {
        this.idLivre = idLivre;
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
    public List<Pais> getPaisList() {
        if (paisList == null) {
            return new ArrayList();
        }
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    @XmlTransient
    public List<Estilo> getEstiloList() {
        if (estiloList == null) {
            return new ArrayList();
        }
        return estiloList;
    }

    public void setEstiloList(List<Estilo> estiloList) {
        this.estiloList = estiloList;
    }

    @XmlTransient
    public List<AnexoColecao> getAnexoColecaoList() {
        if (anexoColecaoList == null) {
            return new ArrayList();
        }
        return anexoColecaoList;
    }

    public void setAnexoColecaoList(List<AnexoColecao> anexoColecaoList) {
        this.anexoColecaoList = anexoColecaoList;
    }

    @XmlTransient
    public List<Produtos> getProdutosList() {
        if (produtosList == null) {
            return new ArrayList();
        }
        return produtosList;
    }

    public void setProdutosList(List<Produtos> produtosList) {
        this.produtosList = produtosList;
    }

    public Marca getMarcaId() {
        if (marcaId == null) {
            return new Marca();
        }
        return marcaId;
    }

    public void setMarcaId(Marca marcaId) {
        this.marcaId = marcaId;
    }

    public ColecaoStatus getColecaoStatusId() {
        if (colecaoStatusId == null) {
            return new ColecaoStatus();
        }
        return colecaoStatusId;
    }

    public void setColecaoStatusId(ColecaoStatus colecaoStatusId) {
        this.colecaoStatusId = colecaoStatusId;
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
        if (!(object instanceof Colecao)) {
            return false;
        }
        Colecao other = (Colecao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
