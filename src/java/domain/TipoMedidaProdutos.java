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
@Table(name = "TIPO_MEDIDA_PRODUTOS", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMedidaProdutos.findAll", query = "SELECT t FROM TipoMedidaProdutos t"),
    @NamedQuery(name = "TipoMedidaProdutos.findByIdSequencialOrdem", query = "SELECT t FROM TipoMedidaProdutos t WHERE t.idSequencialOrdem = :idSequencialOrdem"),
    @NamedQuery(name = "TipoMedidaProdutos.findByValorMedida", query = "SELECT t FROM TipoMedidaProdutos t WHERE t.valorMedida = :valorMedida")})
public class TipoMedidaProdutos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_MEDIDA_PRODUTOS_SEQ")
    @SequenceGenerator(name = "TIPO_MEDIDA_PRODUTOS_SEQ", sequenceName="TIPO_MEDIDA_PRODUTOS_SEQ")

    @Basic(optional = false)
    @Column(name = "ID_SEQUENCIAL_ORDEM", nullable = false, precision = 19, scale = 0)
    private BigDecimal idSequencialOrdem;
    @Basic(optional = false)
    @Column(name = "VALOR_MEDIDA", nullable = false)
    private double valorMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMedidaProdutoId", fetch = FetchType.LAZY)
    private List<AnexosVarianteProduto> anexosVarianteProdutoList;
    @JoinColumn(name = "TIPO_TECIDO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TipoTecido tipoTecidoId;
    @JoinColumn(name = "TIPO_MEDIDA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TipoMedida tipoMedidaId;
    @JoinColumn(name = "TIPO_GRADE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TipoGrade tipoGradeId;
    @JoinColumn(name = "TAMANHO_TIPO_GRADE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TamanhoTipoGrade tamanhoTipoGradeId;
    @JoinColumn(name = "PRODUTOS_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Produtos produtosId;
    @JoinColumn(name = "PADRAO_MEDIDA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PadraoMedida padraoMedidaId;

    public TipoMedidaProdutos() {
    }

    public TipoMedidaProdutos(BigDecimal idSequencialOrdem) {
        this.idSequencialOrdem = idSequencialOrdem;
    }

    public TipoMedidaProdutos(BigDecimal idSequencialOrdem, double valorMedida) {
        this.idSequencialOrdem = idSequencialOrdem;
        this.valorMedida = valorMedida;
    }

    public BigDecimal getIdSequencialOrdem() {
        return idSequencialOrdem;
    }

    public void setIdSequencialOrdem(BigDecimal idSequencialOrdem) {
        this.idSequencialOrdem = idSequencialOrdem;
    }

    public double getValorMedida() {
        return valorMedida;
    }

    public void setValorMedida(double valorMedida) {
        this.valorMedida = valorMedida;
    }

    @XmlTransient
    public List<AnexosVarianteProduto> getAnexosVarianteProdutoList() {
        return anexosVarianteProdutoList;
    }

    public void setAnexosVarianteProdutoList(List<AnexosVarianteProduto> anexosVarianteProdutoList) {
        this.anexosVarianteProdutoList = anexosVarianteProdutoList;
    }

    public TipoTecido getTipoTecidoId() {
        return tipoTecidoId;
    }

    public void setTipoTecidoId(TipoTecido tipoTecidoId) {
        this.tipoTecidoId = tipoTecidoId;
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

    public Produtos getProdutosId() {
        return produtosId;
    }

    public void setProdutosId(Produtos produtosId) {
        this.produtosId = produtosId;
    }

    public PadraoMedida getPadraoMedidaId() {
        return padraoMedidaId;
    }

    public void setPadraoMedidaId(PadraoMedida padraoMedidaId) {
        this.padraoMedidaId = padraoMedidaId;
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
        if (!(object instanceof TipoMedidaProdutos)) {
            return false;
        }
        TipoMedidaProdutos other = (TipoMedidaProdutos) object;
        if ((this.idSequencialOrdem == null && other.idSequencialOrdem != null) || (this.idSequencialOrdem != null && !this.idSequencialOrdem.equals(other.idSequencialOrdem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TipoMedidaProdutos[ idSequencialOrdem=" + idSequencialOrdem + " ]";
    }
    
}
