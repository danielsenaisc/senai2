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

/**
 *
 * @author IST-08-PC
 */
@Entity
@Table(name = "MARCA_CANAL", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaCanal.findAll", query = "SELECT m FROM MarcaCanal m"),
    @NamedQuery(name = "MarcaCanal.findByFormaAcesso", query = "SELECT m FROM MarcaCanal m WHERE m.formaAcesso = :formaAcesso"),
    @NamedQuery(name = "MarcaCanal.findByObservacoes", query = "SELECT m FROM MarcaCanal m WHERE m.observacoes = :observacoes"),
    @NamedQuery(name = "MarcaCanal.findById", query = "SELECT m FROM MarcaCanal m WHERE m.id = :id")})
public class MarcaCanal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "FORMA_ACESSO", length = 100)
    private String formaAcesso;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARCA_CANAL_SEQ")
    @SequenceGenerator(name = "MARCA_CANAL_SEQ", sequenceName="MARCA_CANAL_SEQ")

    @Basic(optional = false)
    @Column(name = "OBSERVACOES", nullable = false, length = 100)
    private String observacoes;
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private BigInteger id;
    @JoinColumn(name = "MARCA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Marca marcaId;
    @JoinColumn(name = "CANAL_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Canal canalId;
    @JoinColumn(name = "ABRANGENCIA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Abrangencia abrangenciaId;

    public MarcaCanal() {
    }

    public MarcaCanal(String observacoes) {
        this.observacoes = observacoes;
    }

    public MarcaCanal(String observacoes, BigInteger id) {
        this.observacoes = observacoes;
        this.id = id;
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

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Marca getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marca marcaId) {
        this.marcaId = marcaId;
    }

    public Canal getCanalId() {
        return canalId;
    }

    public void setCanalId(Canal canalId) {
        this.canalId = canalId;
    }

    public Abrangencia getAbrangenciaId() {
        return abrangenciaId;
    }

    public void setAbrangenciaId(Abrangencia abrangenciaId) {
        this.abrangenciaId = abrangenciaId;
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
