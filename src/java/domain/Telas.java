/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
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
import javax.persistence.ManyToMany;
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
@Table(name = "TELAS", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telas.findAll", query = "SELECT t FROM Telas t"),
    @NamedQuery(name = "Telas.findById", query = "SELECT t FROM Telas t WHERE t.id = :id"),
    @NamedQuery(name = "Telas.findByDescricao", query = "SELECT t FROM Telas t WHERE t.descricao = :descricao")})
public class Telas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TELAS_SEQ")
    @SequenceGenerator(name = "TELAS_SEQ", sequenceName="TELAS_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false, length = 140)
    private String descricao;
    @ManyToMany(mappedBy = "telasList", fetch = FetchType.LAZY)
    private List<Idiomas> idiomasList;
    @JoinColumn(name = "CAMPO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Campo campoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telasId", fetch = FetchType.LAZY)
    private List<PerfilAcesso> perfilAcessoList;

    public Telas() {
    }

    public Telas(Long id) {
        this.id = id;
    }

    public Telas(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Idiomas> getIdiomasList() {
        return idiomasList;
    }

    public void setIdiomasList(List<Idiomas> idiomasList) {
        this.idiomasList = idiomasList;
    }

    public Campo getCampoId() {
        return campoId;
    }

    public void setCampoId(Campo campoId) {
        this.campoId = campoId;
    }

    @XmlTransient
    public List<PerfilAcesso> getPerfilAcessoList() {
        return perfilAcessoList;
    }

    public void setPerfilAcessoList(List<PerfilAcesso> perfilAcessoList) {
        this.perfilAcessoList = perfilAcessoList;
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
        if (!(object instanceof Telas)) {
            return false;
        }
        Telas other = (Telas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Telas[ id=" + id + " ]";
    }
    
}
