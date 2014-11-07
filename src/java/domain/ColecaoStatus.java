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
@Table(name = "COLECAO_STATUS", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColecaoStatus.findAll", query = "SELECT c FROM ColecaoStatus c"),
    @NamedQuery(name = "ColecaoStatus.findById", query = "SELECT c FROM ColecaoStatus c WHERE c.id = :id"),
    @NamedQuery(name = "ColecaoStatus.findByDescricao", query = "SELECT c FROM ColecaoStatus c WHERE c.descricao = :descricao")})
public class ColecaoStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLECAO_STATUS_SEQ")
    @SequenceGenerator(name = "COLECAO_STATUS_SEQ", sequenceName = "COLECAO_STATUS_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false, length = 100)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colecaoStatusId", fetch = FetchType.LAZY)
    private List<Colecao> colecaoList;

    public ColecaoStatus() {
    }

    public ColecaoStatus(Long id) {
        this.id = id;
    }

    public ColecaoStatus(Long id, String descricao) {
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
    public List<Colecao> getColecaoList() {
        return colecaoList;
    }

    public void setColecaoList(List<Colecao> colecaoList) {
        this.colecaoList = colecaoList;
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
        if (!(object instanceof ColecaoStatus)) {
            return false;
        }
        ColecaoStatus other = (ColecaoStatus) object;
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
