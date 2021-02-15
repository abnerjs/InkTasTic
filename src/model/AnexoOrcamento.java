/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abner
 */
@Entity
@Table(name = "anexo_orcamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnexoOrcamento.findAll", query = "SELECT a FROM AnexoOrcamento a"),
    @NamedQuery(name = "AnexoOrcamento.findById", query = "SELECT a FROM AnexoOrcamento a WHERE a.id = :id"),
    @NamedQuery(name = "AnexoOrcamento.findByImagem", query = "SELECT a FROM AnexoOrcamento a WHERE a.imagem = :imagem")})
public class AnexoOrcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Lob
    @Basic(optional = false)
    private byte[] imagem;
    @JoinColumn(name = "id_orcamento", referencedColumnName = "id")
    @ManyToOne
    private Orcamento idOrcamento;

    public AnexoOrcamento() {
    }

    public AnexoOrcamento(Integer id) {
        this.id = id;
    }

    public AnexoOrcamento(Integer id, byte[] imagem) {
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

    public Orcamento getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Orcamento idOrcamento) {
        this.idOrcamento = idOrcamento;
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
        if (!(object instanceof AnexoOrcamento)) {
            return false;
        }
        AnexoOrcamento other = (AnexoOrcamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AnexoOrcamento[ id=" + id + " ]";
    }
    
}
