/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IST-08-PC
 */
@Entity
@Table(name = "USUARIO_INDUSTRIA", catalog = "", schema = "RIGHTSIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioIndustria.findAll", query = "SELECT u FROM UsuarioIndustria u"),
    @NamedQuery(name = "UsuarioIndustria.findById", query = "SELECT u FROM UsuarioIndustria u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioIndustria.findByNome", query = "SELECT u FROM UsuarioIndustria u WHERE u.nome = :nome"),
    @NamedQuery(name = "UsuarioIndustria.findByFoto", query = "SELECT u FROM UsuarioIndustria u WHERE u.foto = :foto"),
    @NamedQuery(name = "UsuarioIndustria.findByEmail", query = "SELECT u FROM UsuarioIndustria u WHERE u.email = :email"),
    @NamedQuery(name = "UsuarioIndustria.findByStatus", query = "SELECT u FROM UsuarioIndustria u WHERE u.status = :status"),
    @NamedQuery(name = "UsuarioIndustria.findByGenero", query = "SELECT u FROM UsuarioIndustria u WHERE u.genero = :genero"),
    @NamedQuery(name = "UsuarioIndustria.findByDataNascimento", query = "SELECT u FROM UsuarioIndustria u WHERE u.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "UsuarioIndustria.findBySenhaAcesso", query = "SELECT u FROM UsuarioIndustria u WHERE u.senhaAcesso = :senhaAcesso"),
    @NamedQuery(name = "UsuarioIndustria.findByIdDepartamento", query = "SELECT u FROM UsuarioIndustria u WHERE u.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "UsuarioIndustria.findByIdCargo", query = "SELECT u FROM UsuarioIndustria u WHERE u.idCargo = :idCargo")})
public class UsuarioIndustria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_INDUSTRIA_SEQ")
    @SequenceGenerator(name = "USUARIO_INDUSTRIA_SEQ", sequenceName="USUARIO_INDUSTRIA_SEQ")

    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;
    @Column(name = "FOTO", length = 500)
    private String foto;
    @Column(name = "EMAIL", length = 100)
    private String email;
    @Basic(optional = false)
    @Column(name = "STATUS", nullable = false)
    private Character status;
    @Column(name = "GENERO")
    private Character genero;
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "SENHA_ACESSO", nullable = false)
    private BigInteger senhaAcesso;
    @Basic(optional = false)
    @Column(name = "ID_DEPARTAMENTO", nullable = false, length = 45)
    private String idDepartamento;
    @Basic(optional = false)
    @Column(name = "ID_CARGO", nullable = false, length = 45)
    private String idCargo;
    @JoinColumn(name = "PERFIL_ACESSO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PerfilAcesso perfilAcessoId;
    @JoinColumn(name = "INDUSTRIA_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Industria industriaId;

    public UsuarioIndustria() {
    }

    public UsuarioIndustria(Long id) {
        this.id = id;
    }

    public UsuarioIndustria(Long id, String nome, Character status, BigInteger senhaAcesso, String idDepartamento, String idCargo) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.senhaAcesso = senhaAcesso;
        this.idDepartamento = idDepartamento;
        this.idCargo = idCargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public BigInteger getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(BigInteger senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public PerfilAcesso getPerfilAcessoId() {
        return perfilAcessoId;
    }

    public void setPerfilAcessoId(PerfilAcesso perfilAcessoId) {
        this.perfilAcessoId = perfilAcessoId;
    }

    public Industria getIndustriaId() {
        return industriaId;
    }

    public void setIndustriaId(Industria industriaId) {
        this.industriaId = industriaId;
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
        if (!(object instanceof UsuarioIndustria)) {
            return false;
        }
        UsuarioIndustria other = (UsuarioIndustria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.UsuarioIndustria[ id=" + id + " ]";
    }
    
}
