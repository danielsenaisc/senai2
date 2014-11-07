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
@Table(name = "CANAL", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canal.findAll", query = "SELECT c FROM Canal c"),
    @NamedQuery(name = "Canal.findById", query = "SELECT c FROM Canal c WHERE c.id = :id"),
    @NamedQuery(name = "Canal.findByDescricao", query = "SELECT c FROM Canal c WHERE c.descricao = :descricao")})
public class Canal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANAL_SEQ")
    @SequenceGenerator(name = "CANAL_SEQ", sequenceName = "CANAL_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false, length = 100)
    public String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canalId", fetch = FetchType.LAZY)
    private List<MarcaCanal> marcaCanalList;

    public Canal() {
    }

    public Canal(Long id) {
        this.id = id;
    }

    public Canal(Long id, String descricao) {
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
    public List<MarcaCanal> getMarcaCanalList() {
        return marcaCanalList;
    }

    public void setMarcaCanalList(List<MarcaCanal> marcaCanalList) {
        this.marcaCanalList = marcaCanalList;
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
        if (!(object instanceof Canal)) {
            return false;
        }
        Canal other = (Canal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getDescricao();
    }

}
