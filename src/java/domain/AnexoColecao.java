/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
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
@Table(name = "ANEXO_COLECAO", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnexoColecao.findAll", query = "SELECT a FROM AnexoColecao a"),
    @NamedQuery(name = "AnexoColecao.findById", query = "SELECT a FROM AnexoColecao a WHERE a.id = :id"),
    @NamedQuery(name = "AnexoColecao.findByTitulo", query = "SELECT a FROM AnexoColecao a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "AnexoColecao.findByDescricao", query = "SELECT a FROM AnexoColecao a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "AnexoColecao.findByUrl", query = "SELECT a FROM AnexoColecao a WHERE a.url = :url")})
public class AnexoColecao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANEXO_COLECAO_SEQ")
    @SequenceGenerator(name = "ANEXO_COLECAO_SEQ", sequenceName = "ANEXO_COLECAO_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false, length = 45)
    private String id;
    @Column(name = "TITULO", length = 100)
    private String titulo;
    @Column(name = "DESCRICAO", length = 500)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "URL", nullable = false, length = 500)
    private String url;
    @JoinColumn(name = "TIPO_ANEXO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TipoAnexo tipoAnexoId;
    @JoinColumn(name = "COLECAO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Colecao colecaoId;

    public AnexoColecao() {
    }

    public AnexoColecao(String id) {
        this.id = id;
    }

    public AnexoColecao(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TipoAnexo getTipoAnexoId() {
        return tipoAnexoId;
    }

    public void setTipoAnexoId(TipoAnexo tipoAnexoId) {
        this.tipoAnexoId = tipoAnexoId;
    }

    public Colecao getColecaoId() {
        return colecaoId;
    }

    public void setColecaoId(Colecao colecaoId) {
        this.colecaoId = colecaoId;
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
        if (!(object instanceof AnexoColecao)) {
            return false;
        }
        AnexoColecao other = (AnexoColecao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.AnexoColecao[ id=" + id + " ]";
    }

}
