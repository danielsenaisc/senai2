/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.math.BigInteger;

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

@Entity
@Table(name = "MARCA_CANAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaCanal.findAll", query = "SELECT m FROM MarcaCanal m"),
    @NamedQuery(name = "MarcaCanal.findByFormaAcesso", query = "SELECT m FROM MarcaCanal m WHERE m.formaAcesso = :formaAcesso"),
    @NamedQuery(name = "MarcaCanal.findByObservacoes", query = "SELECT m FROM MarcaCanal m WHERE m.observacoes = :observacoes"),
    @NamedQuery(name = "MarcaCanal.findByCodigo", query = "SELECT m FROM MarcaCanal m WHERE m.codigo = :codigo")})
public class MarcaCanal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "FORMA_ACESSO")
    private String formaAcesso;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARCA_CANAL_SEQ")
    @SequenceGenerator(name = "MARCA_CANAL_SEQ", sequenceName = "MARCA_CANAL_SEQ")
    @Basic(optional = false)
    @Column(name = "OBSERVACOES")
    private String observacoes;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private BigInteger codigo;
    @JoinColumn(name = "MARCA_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Marca marcaCodigo;
    @JoinColumn(name = "CANAL_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Canal canalCodigo;
    @JoinColumn(name = "ABRANGENCIA_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Abrangencia abrangenciaCodigo;

    public MarcaCanal() {
    }

    public MarcaCanal(String observacoes) {
        this.observacoes = observacoes;
    }

    public MarcaCanal(String observacoes, BigInteger codigo) {
        this.observacoes = observacoes;
        this.codigo = codigo;
    }

    public String getFormaAcesso() {
        return formaAcesso;
    }

    public void setFormaAcesso(String formaAcesso) {
        this.formaAcesso = formaAcesso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public BigInteger getCodigo() {
        return codigo;
    }

    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    public Marca getMarcaCodigo() {
        return marcaCodigo;
    }

    public void setMarcaCodigo(Marca marcaCodigo) {
        this.marcaCodigo = marcaCodigo;
    }

    public Canal getCanalCodigo() {
        return canalCodigo;
    }

    public void setCanalCodigo(Canal canalCodigo) {
        this.canalCodigo = canalCodigo;
    }

    public Abrangencia getAbrangenciaCodigo() {
        return abrangenciaCodigo;
    }

    public void setAbrangenciaCodigo(Abrangencia abrangenciaCodigo) {
        this.abrangenciaCodigo = abrangenciaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observacoes != null ? observacoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaCanal)) {
            return false;
        }
        MarcaCanal other = (MarcaCanal) object;
        if ((this.observacoes == null && other.observacoes != null) || (this.observacoes != null && !this.observacoes.equals(other.observacoes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.MarcaCanal[ observacoes=" + observacoes + " ]";
    }
    
}
