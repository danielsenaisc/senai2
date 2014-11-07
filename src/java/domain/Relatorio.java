/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IST-08-PC
 */
@Entity
@Table(name = "RELATORIO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatorio.findAll", query = "SELECT r FROM Relatorio r"),
    @NamedQuery(name = "Relatorio.findById", query = "SELECT r FROM Relatorio r WHERE r.id = :id"),
    @NamedQuery(name = "Relatorio.findByPeriodicidade", query = "SELECT r FROM Relatorio r WHERE r.periodicidade = :periodicidade"),
    @NamedQuery(name = "Relatorio.findByDataInicial", query = "SELECT r FROM Relatorio r WHERE r.dataInicial = :dataInicial"),
    @NamedQuery(name = "Relatorio.findByDataFinal", query = "SELECT r FROM Relatorio r WHERE r.dataFinal = :dataFinal"),
    @NamedQuery(name = "Relatorio.findByPrivacidade", query = "SELECT r FROM Relatorio r WHERE r.privacidade = :privacidade")})
public class Relatorio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELATORIO_SEQ")
    @SequenceGenerator(name = "RELATORIO_SEQ", sequenceName = "RELATORIO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Column(name = "PERIODICIDADE", length = 100)
    private String periodicidade;
    @Column(name = "DATA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicial;
    @Column(name = "DATA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinal;
    @Column(name = "PRIVACIDADE", length = 100)
    private String privacidade;
    @JoinColumn(name = "TIPO_RELATORIO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TipoRelatorio tipoRelatorioId;
    @JoinColumn(name = "INDUSTRIA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Industria industriaId;

    public Relatorio() {
    }

    public Relatorio(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(String privacidade) {
        this.privacidade = privacidade;
    }

    public TipoRelatorio getTipoRelatorioId() {
        return tipoRelatorioId;
    }

    public void setTipoRelatorioId(TipoRelatorio tipoRelatorioId) {
        this.tipoRelatorioId = tipoRelatorioId;
    }

    public Industria getIndustriaId() {
        return industriaId;
    }

    public void setIndustriaId(Industria industriaId) {
        this.industriaId = industriaId;
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
        if (!(object instanceof Relatorio)) {
            return false;
        }
        Relatorio other = (Relatorio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Relatorio[ id=" + id + " ]";
    }

}
