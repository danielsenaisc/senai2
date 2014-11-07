/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
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

/**
 *
 * @author IST-08-PC
 */
@Entity
@Table(name = "PAIS", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findById", query = "SELECT p FROM Pais p WHERE p.id = :id"),
    @NamedQuery(name = "Pais.findByNome", query = "SELECT p FROM Pais p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pais.findBySigla", query = "SELECT p FROM Pais p WHERE p.sigla = :sigla"),
    @NamedQuery(name = "Pais.findByNacionalidade", query = "SELECT p FROM Pais p WHERE p.nacionalidade = :nacionalidade")})
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAIS_SEQ")
    @SequenceGenerator(name = "PAIS_SEQ", sequenceName = "PAIS_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "NOME", nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(name = "SIGLA", nullable = false, length = 4)
    private String sigla;
    @Column(name = "NACIONALIDADE", length = 100)
    private String nacionalidade;
    @ManyToMany(mappedBy = "paisList", fetch = FetchType.LAZY)
    private List<Colecao> colecaoList;
    @ManyToMany(mappedBy = "paisList", fetch = FetchType.LAZY)
    private List<Marca> marcaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisId", fetch = FetchType.LAZY)
    private List<Cep> cepList;
    @JoinColumn(name = "IDIOMA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Idiomas idiomaId;
    @JoinColumn(name = "CONTINENTE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Continente continenteId;

    public Pais() {
    }

    public Pais(Long id) {
        this.id = id;
    }

    public Pais(Long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @XmlTransient
    public List<Colecao> getColecaoList() {
        return colecaoList;
    }

    public void setColecaoList(List<Colecao> colecaoList) {
        this.colecaoList = colecaoList;
    }

    @XmlTransient
    public List<Marca> getMarcaList() {
        return marcaList;
    }

    public void setMarcaList(List<Marca> marcaList) {
        this.marcaList = marcaList;
    }

    @XmlTransient
    public List<Cep> getCepList() {
        return cepList;
    }

    public void setCepList(List<Cep> cepList) {
        this.cepList = cepList;
    }

    public Idiomas getIdiomaId() {
        return idiomaId;
    }

    public void setIdiomaId(Idiomas idiomaId) {
        this.idiomaId = idiomaId;
    }

    public Continente getContinenteId() {
        return continenteId;
    }

    public void setContinenteId(Continente continenteId) {
        this.continenteId = continenteId;
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
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
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
