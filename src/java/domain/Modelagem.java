/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "MODELAGEM", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelagem.findAll", query = "SELECT m FROM Modelagem m"),
    @NamedQuery(name = "Modelagem.findById", query = "SELECT m FROM Modelagem m WHERE m.id = :id"),
    @NamedQuery(name = "Modelagem.findByNome", query = "SELECT m FROM Modelagem m WHERE m.nome = :nome"),
    @NamedQuery(name = "Modelagem.findByStatus", query = "SELECT m FROM Modelagem m WHERE m.status = :status"),
    @NamedQuery(name = "Modelagem.findByGenero", query = "SELECT m FROM Modelagem m WHERE m.genero = :genero"),
    @NamedQuery(name = "Modelagem.findByDescricao", query = "SELECT m FROM Modelagem m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Modelagem.findByIdInternoIndustria", query = "SELECT m FROM Modelagem m WHERE m.idInternoIndustria = :idInternoIndustria")})
public class Modelagem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MODELAGEM_SEQ")
    @SequenceGenerator(name = "MODELAGEM_SEQ", sequenceName = "MODELAGEM_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;
    @Basic(optional = false)
    @Column(name = "STATUS", nullable = false)
    private Character status;
    @Column(name = "GENERO")
    private Character genero;
    @Column(name = "DESCRICAO", length = 500)
    private String descricao;
    @Column(name = "ID_INTERNO_INDUSTRIA", length = 100)
    private String idInternoIndustria;
    @ManyToMany(mappedBy = "modelagemList", fetch = FetchType.LAZY)
    private List<Marca> marcaList;
    @ManyToMany(mappedBy = "modelagemList", fetch = FetchType.LAZY)
    private List<Categoria> categoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelagemId", fetch = FetchType.LAZY)
    private List<ModelagemDadosTamanho> modelagemDadosTamanhoList;

    public Modelagem() {
    }

    public Modelagem(BigDecimal id) {
        this.id = id;
    }

    public Modelagem(BigDecimal id, String nome, Character status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdInternoIndustria() {
        return idInternoIndustria;
    }

    public void setIdInternoIndustria(String idInternoIndustria) {
        this.idInternoIndustria = idInternoIndustria;
    }

    @XmlTransient
    public List<Marca> getMarcaList() {
        return marcaList;
    }

    public void setMarcaList(List<Marca> marcaList) {
        this.marcaList = marcaList;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @XmlTransient
    public List<ModelagemDadosTamanho> getModelagemDadosTamanhoList() {
        return modelagemDadosTamanhoList;
    }

    public void setModelagemDadosTamanhoList(List<ModelagemDadosTamanho> modelagemDadosTamanhoList) {
        this.modelagemDadosTamanhoList = modelagemDadosTamanhoList;
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
        if (!(object instanceof Modelagem)) {
            return false;
        }
        Modelagem other = (Modelagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Modelagem[ id=" + id + " ]";
    }

    //TODO Rever Regra de Negócio
    public int getQuantidadeDeColecoes() {
        return 0;
    }

    //TODO Rever Regra de Negócio
    public int getQuantidadeDeProdutos() {
        return 0;
    }

    public String getStatusTratado() {
        if (Objects.equals(getStatus(), OracleBoolean.TRUE.getValue())) {
            return "Ativo";
        }
        return "Inativo";
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

}
