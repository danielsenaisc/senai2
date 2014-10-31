/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "PERFIL_ACESSO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilAcesso.findAll", query = "SELECT p FROM PerfilAcesso p"),
    @NamedQuery(name = "PerfilAcesso.findById", query = "SELECT p FROM PerfilAcesso p WHERE p.id = :id"),
    @NamedQuery(name = "PerfilAcesso.findByIdTipoPermissao", query = "SELECT p FROM PerfilAcesso p WHERE p.idTipoPermissao = :idTipoPermissao")})
public class PerfilAcesso implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERFIL_ACESSO_SEQ")
    @SequenceGenerator(name = "PERFIL_ACESSO_SEQ", sequenceName="PERFIL_ACESSO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 19, scale = 0)
    private BigDecimal id;
    @Column(name = "ID_TIPO_PERMISSAO")
    private BigInteger idTipoPermissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfilAcessoId", fetch = FetchType.LAZY)
    private List<UsuarioIndustria> usuarioIndustriaList;
    @JoinColumn(name = "TELAS_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Telas telasId;

    public PerfilAcesso() {
    }

    public PerfilAcesso(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getIdTipoPermissao() {
        return idTipoPermissao;
    }

    public void setIdTipoPermissao(BigInteger idTipoPermissao) {
        this.idTipoPermissao = idTipoPermissao;
    }

    @XmlTransient
    public List<UsuarioIndustria> getUsuarioIndustriaList() {
        return usuarioIndustriaList;
    }

    public void setUsuarioIndustriaList(List<UsuarioIndustria> usuarioIndustriaList) {
        this.usuarioIndustriaList = usuarioIndustriaList;
    }

    public Telas getTelasId() {
        return telasId;
    }

    public void setTelasId(Telas telasId) {
        this.telasId = telasId;
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
        if (!(object instanceof PerfilAcesso)) {
            return false;
        }
        PerfilAcesso other = (PerfilAcesso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PerfilAcesso[ id=" + id + " ]";
    }
    
}
