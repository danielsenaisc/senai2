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
import javax.persistence.JoinColumn;
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
@Table(name = "CEP", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cep.findAll", query = "SELECT c FROM Cep c"),
    @NamedQuery(name = "Cep.findById", query = "SELECT c FROM Cep c WHERE c.id = :id"),
    @NamedQuery(name = "Cep.findByRua", query = "SELECT c FROM Cep c WHERE c.rua = :rua"),
    @NamedQuery(name = "Cep.findByCidade", query = "SELECT c FROM Cep c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "Cep.findByEstado", query = "SELECT c FROM Cep c WHERE c.estado = :estado")})
public class Cep implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CEP_SEQ")
    @SequenceGenerator(name = "CEP_SEQ", sequenceName = "CEP_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Column(name = "RUA", length = 100)
    private String rua;
    @Column(name = "CIDADE", length = 100)
    private String cidade;
    @Column(name = "ESTADO", length = 100)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cepId", fetch = FetchType.LAZY)
    private List<Industria> industriaList;
    @JoinColumn(name = "PAIS_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Pais paisId;

    public Cep() {
    }

    public Cep(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Industria> getIndustriaList() {
        return industriaList;
    }

    public void setIndustriaList(List<Industria> industriaList) {
        this.industriaList = industriaList;
    }

    public Pais getPaisId() {
        return paisId;
    }

    public void setPaisId(Pais paisId) {
        this.paisId = paisId;
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
        if (!(object instanceof Cep)) {
            return false;
        }
        Cep other = (Cep) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Cep[ id=" + id + " ]";
    }

}
