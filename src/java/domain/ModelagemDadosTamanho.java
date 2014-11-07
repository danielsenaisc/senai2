F/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IST-08-PC
 */
@Entity
@Table(name = "MODELAGEM_DADOS_TAMANHO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelagemDadosTamanho.findAll", query = "SELECT m FROM ModelagemDadosTamanho m"),
    @NamedQuery(name = "ModelagemDadosTamanho.findByIdSequencialOrdem", query = "SELECT m FROM ModelagemDadosTamanho m WHERE m.idSequencialOrdem = :idSequencialOrdem"),
    @NamedQuery(name = "ModelagemDadosTamanho.findByValorMedidaInicial", query = "SELECT m FROM ModelagemDadosTamanho m WHERE m.valorMedidaInicial = :valorMedidaInicial"),
    @NamedQuery(name = "ModelagemDadosTamanho.findByValorMedidaFinal", query = "SELECT m FROM ModelagemDadosTamanho m WHERE m.valorMedidaFinal = :valorMedidaFinal")})
public class ModelagemDadosTamanho implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MODELAGEM_DADOS_TAMANHO_SEQ")
    @SequenceGenerator(name = "MODELAGEM_DADOS_TAMANHO_SEQ", sequenceName = "MODELAGEM_DADOS_TAMANHO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID_SEQUENCIAL_ORDEM", nullable = false, precision = 19, scale = 0)
    private BigDecimal idSequencialOrdem;
    @Basic(optional = false)
    @Column(name = "VALOR_MEDIDA_INICIAL", nullable = false)
    private double valorMedidaInicial;
    @Basic(optional = false)
    @Column(name = "VALOR_MEDIDA_FINAL", nullable = false)
    private double valorMedidaFinal;
    @JoinColumn(name = "TIPO_MEDIDA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TipoMedida tipoMedidaId;
    @JoinColumn(name = "TIPO_GRADE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TipoGrade tipoGradeId;
    @JoinColumn(name = "TAMANHO_TIPO_GRADE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TamanhoTipoGrade tamanhoTipoGradeId;
    @JoinColumn(name = "PADRAO_MEDIDA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PadraoMedida padraoMedidaId;
    @JoinColumn(name = "MODELAGEM_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Modelagem modelagemId;

    public ModelagemDadosTamanho() {
    }

    public ModelagemDadosTamanho(BigDecimal idSequencialOrdem) {
        this.idSequencialOrdem = idSequencialOrdem;
    }

    public ModelagemDadosTamanho(BigDecimal idSequencialOrdem, double valorMedidaInicial, double valorMedidaFinal) {
        this.idSequencialOrdem = idSequencialOrdem;
        this.valorMedidaInicial = valorMedidaInicial;
        this.valorMedidaFinal = valorMedidaFinal;
    }

    public BigDecimal getIdSequencialOrdem() {
        return idSequencialOrdem;
    }

    public void setIdSequencialOrdem(BigDecimal idSequencialOrdem) {
        this.idSequencialOrdem = idSequencialOrdem;
    }

    public double getValorMedidaInicial() {
        return valorMedidaInicial;
    }

    public void setValorMedidaInicial(double valorMedidaInicial) {
        this.valorMedidaInicial = valorMedidaInicial;
    }

    public double getValorMedidaFinal() {
        return valorMedidaFinal;
    }

    public void setValorMedidaFinal(double valorMedidaFinal) {
        this.valorMedidaFinal = valorMedidaFinal;
    }

    public TipoMedida getTipoMedidaId() {
        return tipoMedidaId;
    }

    public void setTipoMedidaId(TipoMedida tipoMedidaId) {
        this.tipoMedidaId = tipoMedidaId;
    }

    public TipoGrade getTipoGradeId() {
        return tipoGradeId;
    }

    public void setTipoGradeId(TipoGrade tipoGradeId) {
        this.tipoGradeId = tipoGradeId;
    }

    public TamanhoTipoGrade getTamanhoTipoGradeId() {
        return tamanhoTipoGradeId;
    }

    public void setTamanhoTipoGradeId(TamanhoTipoGrade tamanhoTipoGradeId) {
        this.tamanhoTipoGradeId = tamanhoTipoGradeId;
    }

    public PadraoMedida getPadraoMedidaId() {
        return padraoMedidaId;
    }

    public void setPadraoMedidaId(PadraoMedida padraoMedidaId) {
        this.padraoMedidaId = padraoMedidaId;
    }

    public Modelagem getModelagemId() {
        return modelagemId;
    }

    public void setModelagemId(Modelagem modelagemId) {
        this.modelagemId = modelagemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSequencialOrdem != null ? idSequencialOrdem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelagemDadosTamanho)) {
            return false;
        }
        ModelagemDadosTamanho other = (ModelagemDadosTamanho) object;
        if ((this.idSequencialOrdem == null && other.idSequencialOrdem != null) || (this.idSequencialOrdem != null && !this.idSequencialOrdem.equals(other.idSequencialOrdem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.ModelagemDadosTamanho[ idSequencialOrdem=" + idSequencialOrdem + " ]";
    }

}
