/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author IST-08-PC
 */
@Entity
@Table(name = "ESTILO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estilo.findAll", query = "SELECT e FROM Estilo e"),
    @NamedQuery(name = "Estilo.findById", query = "SELECT e FROM Estilo e WHERE e.id = :id"),
    @NamedQuery(name = "Estilo.findByDescricao", query = "SELECT e FROM Estilo e WHERE e.descricao = :descricao")})
public class Estilo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTILO_SEQ")
    @SequenceGenerator(name = "ESTILO_SEQ", sequenceName = "ESTILO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false, length = 100)
    private String descricao;
    @JoinTable(name = "ESTILO_MARCA", joinColumns = {
        @JoinColumn(name = "ESTILO_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "MARCA_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Marca> marcaList;
    @ManyToMany(mappedBy = "estiloList", fetch = FetchType.LAZY)
    private List<Colecao> colecaoList;

    public Estilo() {
    }

    public Estilo(Long id) {
        this.id = id;
    }

    public Estilo(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Marca> getMarcaList() {
        return marcaList;
    }

    public void setMarcaList(List<Marca> marcaList) {
        this.marcaList = marcaList;
    }

    @XmlTransient
    public List<Colecao> getColecaoList() {
        return colecaoList;
    }

    public void setColecaoList(List<Colecao> colecaoList) {
        this.colecaoList = colecaoList;
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
        if (!(object instanceof Estilo)) {
            return false;
        }
        Estilo other = (Estilo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Estilo[ id=" + id + " ]";
    }

}
