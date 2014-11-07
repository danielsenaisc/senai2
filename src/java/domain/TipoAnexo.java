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
@Table(name = "TIPO_ANEXO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAnexo.findAll", query = "SELECT t FROM TipoAnexo t"),
    @NamedQuery(name = "TipoAnexo.findById", query = "SELECT t FROM TipoAnexo t WHERE t.id = :id"),
    @NamedQuery(name = "TipoAnexo.findByDescricaoReduzida", query = "SELECT t FROM TipoAnexo t WHERE t.descricaoReduzida = :descricaoReduzida"),
    @NamedQuery(name = "TipoAnexo.findByDescricao", query = "SELECT t FROM TipoAnexo t WHERE t.descricao = :descricao")})
public class TipoAnexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_ANEXO_SEQ")
    @SequenceGenerator(name = "TIPO_ANEXO_SEQ", sequenceName = "TIPO_ANEXO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "DESCRICAO_REDUZIDA", nullable = false, length = 100)
    private String descricaoReduzida;
    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false, length = 500)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAnexoId", fetch = FetchType.LAZY)
    private List<AnexoColecao> anexoColecaoList;

    public TipoAnexo() {
    }

    public TipoAnexo(Long id) {
        this.id = id;
    }

    public TipoAnexo(Long id, String descricaoReduzida, String descricao) {
        this.id = id;
        this.descricaoReduzida = descricaoReduzida;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoReduzida() {
        return descricaoReduzida;
    }

    public void setDescricaoReduzida(String descricaoReduzida) {
        this.descricaoReduzida = descricaoReduzida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<AnexoColecao> getAnexoColecaoList() {
        return anexoColecaoList;
    }

    public void setAnexoColecaoList(List<AnexoColecao> anexoColecaoList) {
        this.anexoColecaoList = anexoColecaoList;
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
        if (!(object instanceof TipoAnexo)) {
            return false;
        }
        TipoAnexo other = (TipoAnexo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TipoAnexo[ id=" + id + " ]";
    }

}
