/*
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
@Table(name = "ANEXOS_VARIANTE_PRODUTO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnexosVarianteProduto.findAll", query = "SELECT a FROM AnexosVarianteProduto a"),
    @NamedQuery(name = "AnexosVarianteProduto.findByIdAnexoImagemVideo", query = "SELECT a FROM AnexosVarianteProduto a WHERE a.idAnexoImagemVideo = :idAnexoImagemVideo"),
    @NamedQuery(name = "AnexosVarianteProduto.findByAnexo", query = "SELECT a FROM AnexosVarianteProduto a WHERE a.anexo = :anexo")})
public class AnexosVarianteProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANEXOS_VARIANTE_PRODUTO_SEQ")
    @SequenceGenerator(name = "ANEXOS_VARIANTE_PRODUTO_SEQ", sequenceName = "ANEXOS_VARIANTE_PRODUTO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID_ANEXO_IMAGEM_VIDEO", nullable = false, precision = 19, scale = 0)
    private BigDecimal idAnexoImagemVideo;
    @Basic(optional = false)
    @Column(name = "ANEXO", nullable = false, length = 500)
    private String anexo;
    @JoinColumn(name = "TIPO_MEDIDA_PRODUTO_ID", referencedColumnName = "ID_SEQUENCIAL_ORDEM", nullable = false)
    @ManyToOne(optional = false)
    private TipoMedidaProdutos tipoMedidaProdutoId;

    public AnexosVarianteProduto() {
    }

    public AnexosVarianteProduto(BigDecimal idAnexoImagemVideo) {
        this.idAnexoImagemVideo = idAnexoImagemVideo;
    }

    public AnexosVarianteProduto(BigDecimal idAnexoImagemVideo, String anexo) {
        this.idAnexoImagemVideo = idAnexoImagemVideo;
        this.anexo = anexo;
    }

    public BigDecimal getIdAnexoImagemVideo() {
        return idAnexoImagemVideo;
    }

    public void setIdAnexoImagemVideo(BigDecimal idAnexoImagemVideo) {
        this.idAnexoImagemVideo = idAnexoImagemVideo;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public TipoMedidaProdutos getTipoMedidaProdutoId() {
        return tipoMedidaProdutoId;
    }

    public void setTipoMedidaProdutoId(TipoMedidaProdutos tipoMedidaProdutoId) {
        this.tipoMedidaProdutoId = tipoMedidaProdutoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnexoImagemVideo != null ? idAnexoImagemVideo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnexosVarianteProduto)) {
            return false;
        }
        AnexosVarianteProduto other = (AnexosVarianteProduto) object;
        if ((this.idAnexoImagemVideo == null && other.idAnexoImagemVideo != null) || (this.idAnexoImagemVideo != null && !this.idAnexoImagemVideo.equals(other.idAnexoImagemVideo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.AnexosVarianteProduto[ idAnexoImagemVideo=" + idAnexoImagemVideo + " ]";
    }

}
