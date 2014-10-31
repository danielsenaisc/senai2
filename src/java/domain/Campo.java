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
@Table(name = "CAMPO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campo.findAll", query = "SELECT c FROM Campo c"),
    @NamedQuery(name = "Campo.findById", query = "SELECT c FROM Campo c WHERE c.id = :id"),
    @NamedQuery(name = "Campo.findByDescricao", query = "SELECT c FROM Campo c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Campo.findByAjuda", query = "SELECT c FROM Campo c WHERE c.ajuda = :ajuda")})
public class Campo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMPO_SEQ")
    @SequenceGenerator(name = "CAMPO_SEQ", sequenceName="CAMPO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false, length = 100)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "AJUDA", nullable = false, length = 500)
    private String ajuda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campoId", fetch = FetchType.LAZY)
    private List<Telas> telasList;

    public Campo() {
    }

    public Campo(Long id) {
        this.id = id;
    }

    public Campo(Long id, String descricao, String ajuda) {
        this.id = id;
        this.descricao = descricao;
        this.ajuda = ajuda;
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

    public String getAjuda() {
        return ajuda;
    }

    public void setAjuda(String ajuda) {
        this.ajuda = ajuda;
    }

    @XmlTransient
    public List<Telas> getTelasList() {
        return telasList;
    }

    public void setTelasList(List<Telas> telasList) {
        this.telasList = telasList;
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
        if (!(object instanceof Campo)) {
            return false;
        }
        Campo other = (Campo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Campo[ id=" + id + " ]";
    }
    
}
