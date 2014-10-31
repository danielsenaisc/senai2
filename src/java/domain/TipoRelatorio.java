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
@Table(name = "TIPO_RELATORIO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRelatorio.findAll", query = "SELECT t FROM TipoRelatorio t"),
    @NamedQuery(name = "TipoRelatorio.findById", query = "SELECT t FROM TipoRelatorio t WHERE t.id = :id"),
    @NamedQuery(name = "TipoRelatorio.findByDescricao", query = "SELECT t FROM TipoRelatorio t WHERE t.descricao = :descricao")})
public class TipoRelatorio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_RELATORIO_SEQ")
    @SequenceGenerator(name = "TIPO_RELATORIO_SEQ", sequenceName="TIPO_RELATORIO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false, length = 100)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRelatorioId")
    private List<Relatorio> relatorioList;

    public TipoRelatorio() {
    }

    public TipoRelatorio(BigDecimal id) {
        this.id = id;
    }

    public TipoRelatorio(BigDecimal id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Relatorio> getRelatorioList() {
        return relatorioList;
    }

    public void setRelatorioList(List<Relatorio> relatorioList) {
        this.relatorioList = relatorioList;
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
        if (!(object instanceof TipoRelatorio)) {
            return false;
        }
        TipoRelatorio other = (TipoRelatorio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TipoRelatorio[ id=" + id + " ]";
    }
    
}
