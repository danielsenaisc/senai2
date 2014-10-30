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
@Table(name = "TAMANHO_TIPO_GRADE", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TamanhoTipoGrade.findAll", query = "SELECT t FROM TamanhoTipoGrade t"),
    @NamedQuery(name = "TamanhoTipoGrade.findById", query = "SELECT t FROM TamanhoTipoGrade t WHERE t.id = :id"),
    @NamedQuery(name = "TamanhoTipoGrade.findByDescricao", query = "SELECT t FROM TamanhoTipoGrade t WHERE t.descricao = :descricao")})
public class TamanhoTipoGrade implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAMANHO_TIPO_GRADE_SEQ")
    @SequenceGenerator(name = "TAMANHO_TIPO_GRADE_SEQ", sequenceName="TAMANHO_TIPO_GRADE_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false, length = 500)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tamanhoTipoGradeId", fetch = FetchType.LAZY)
    private List<ModelagemDadosTamanho> modelagemDadosTamanhoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tamanhoTipoGradeId", fetch = FetchType.LAZY)
    private List<TipoMedidaProdutos> tipoMedidaProdutosList;
    @JoinColumn(name = "TIPO_GRADE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TipoGrade tipoGradeId;

    public TamanhoTipoGrade() {
    }

    public TamanhoTipoGrade(BigDecimal id) {
        this.id = id;
    }

    public TamanhoTipoGrade(BigDecimal id, String descricao) {
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

    public TipoGrade getTipoGradeId() {
        return tipoGradeId;
    }

    public void setTipoGradeId(TipoGrade tipoGradeId) {
        this.tipoGradeId = tipoGradeId;
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
        if (!(object instanceof TamanhoTipoGrade)) {
            return false;
        }
        TamanhoTipoGrade other = (TamanhoTipoGrade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TamanhoTipoGrade[ id=" + id + " ]";
    }
    
}
