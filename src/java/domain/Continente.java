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
@Table(name = "CONTINENTE", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Continente.findAll", query = "SELECT c FROM Continente c"),
    @NamedQuery(name = "Continente.findById", query = "SELECT c FROM Continente c WHERE c.id = :id"),
    @NamedQuery(name = "Continente.findByNome", query = "SELECT c FROM Continente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Continente.findBySigla", query = "SELECT c FROM Continente c WHERE c.sigla = :sigla")})
public class Continente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTINENTE_SEQ")
    @SequenceGenerator(name = "CONTINENTE_SEQ", sequenceName = "CONTINENTE_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "NOME", nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(name = "SIGLA", nullable = false, length = 3)
    private String sigla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "continenteId", fetch = FetchType.LAZY)
    private List<Pais> paisList;

    public Continente() {
    }

    public Continente(Long id) {
        this.id = id;
    }

    public Continente(Long id, String nome, String sigla) {
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

    @XmlTransient
    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
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
        if (!(object instanceof Continente)) {
            return false;
        }
        Continente other = (Continente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Continente[ id=" + id + " ]";
    }

}
