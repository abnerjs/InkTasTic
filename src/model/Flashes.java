/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abner
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flashes.findAll", query = "SELECT f FROM Flashes f"),
    @NamedQuery(name = "Flashes.findById", query = "SELECT f FROM Flashes f WHERE f.id = :id"),
    @NamedQuery(name = "Flashes.findByImagem", query = "SELECT f FROM Flashes f WHERE f.imagem = :imagem")})
public class Flashes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Lob
    @Basic(optional = false)
    private byte[] imagem;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Flashes() {
    }

    public Flashes(Integer id) {
        this.id = id;
    }

    public Flashes(Integer id, byte[] imagem) {
        this.id = id;
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Flashes)) {
            return false;
        }
        Flashes other = (Flashes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Flashes[ id=" + id + " ]";
    }
    
}
