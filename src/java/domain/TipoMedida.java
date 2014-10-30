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
@Table(name = "TIPO_MEDIDA", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMedida.findAll", query = "SELECT t FROM TipoMedida t"),
    @NamedQuery(name = "TipoMedida.findById", query = "SELECT t FROM TipoMedida t WHERE t.id = :id"),
    @NamedQuery(name = "TipoMedida.findByDescricao", query = "SELECT t FROM TipoMedida t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TipoMedida.findByAbreviacao", query = "SELECT t FROM TipoMedida t WHERE t.abreviacao = :abreviacao"),
    @NamedQuery(name = "TipoMedida.findByFormaMedidaFigura", query = "SELECT t FROM TipoMedida t WHERE t.formaMedidaFigura = :formaMedidaFigura")})
public class TipoMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_MEDIDA_SEQ")
    @SequenceGenerator(name = "TIPO_MEDIDA_SEQ", sequenceName="TIPO_MEDIDA_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false, length = 100)
    private String descricao;
    @Column(name = "ABREVIACAO", length = 4)
    private String abreviacao;
    @Column(name = "FORMA_MEDIDA_FIGURA", length = 500)
    private String formaMedidaFigura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMedidaId", fetch = FetchType.LAZY)
    private List<ModelagemDadosTamanho> modelagemDadosTamanhoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMedidaId", fetch = FetchType.LAZY)
    private List<TipoMedidaProdutos> tipoMedidaProdutosList;

    public TipoMedida() {
    }

    public TipoMedida(BigDecimal id) {
        this.id = id;
    }

    public TipoMedida(BigDecimal id, String descricao) {
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

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public String getFormaMedidaFigura() {
        return formaMedidaFigura;
    }

    public void setFormaMedidaFigura(String formaMedidaFigura) {
        this.formaMedidaFigura = formaMedidaFigura;
    }

    @XmlTransient
    public List<ModelagemDadosTamanho> getModelagemDadosTamanhoList() {
        return modelagemDadosTamanhoList;
    }

    public void setModelagemDadosTamanhoList(List<ModelagemDadosTamanho> modelagemDadosTamanhoList) {
        this.modelagemDadosTamanhoList = modelagemDadosTamanhoList;
    }

    @XmlTransient
    public List<TipoMedidaProdutos> getTipoMedidaProdutosList() {
        return tipoMedidaProdutosList;
    }

    public void setTipoMedidaProdutosList(List<TipoMedidaProdutos> tipoMedidaProdutosList) {
        this.tipoMedidaProdutosList = tipoMedidaProdutosList;
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
        if (!(object instanceof TipoMedida)) {
            return false;
        }
        TipoMedida other = (TipoMedida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TipoMedida[ id=" + id + " ]";
    }
    
}
