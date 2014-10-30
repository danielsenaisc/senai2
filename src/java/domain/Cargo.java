/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CARGO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findById", query = "SELECT c FROM Cargo c WHERE c.id = :id"),
    @NamedQuery(name = "Cargo.findByNomeFuncao", query = "SELECT c FROM Cargo c WHERE c.nomeFuncao = :nomeFuncao"),
    @NamedQuery(name = "Cargo.findByDescricaoFuncao", query = "SELECT c FROM Cargo c WHERE c.descricaoFuncao = :descricaoFuncao")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARGO_SEQ")
    @SequenceGenerator(name = "CARGO_SEQ", sequenceName="CARGO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NOME_FUNCAO", nullable = false, length = 100)
    private String nomeFuncao;
    @Column(name = "DESCRICAO_FUNCAO", length = 200)
    private String descricaoFuncao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoId", fetch = FetchType.LAZY)
    private List<Profissional> profissionalList;

    public Cargo() {
    }

    public Cargo(BigDecimal id) {
        this.id = id;
    }

    public Cargo(BigDecimal id, String nomeFuncao) {
        this.id = id;
        this.nomeFuncao = nomeFuncao;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    public String getDescricaoFuncao() {
        return descricaoFuncao;
    }

    public void setDescricaoFuncao(String descricaoFuncao) {
        this.descricaoFuncao = descricaoFuncao;
    }

    @XmlTransient
    public List<Profissional> getProfissionalList() {
        return profissionalList;
    }

    public void setProfissionalList(List<Profissional> profissionalList) {
        this.profissionalList = profissionalList;
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
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Cargo[ id=" + id + " ]";
    }
    
}
