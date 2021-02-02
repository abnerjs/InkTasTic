/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abner
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o"),
    @NamedQuery(name = "Orcamento.findById", query = "SELECT o FROM Orcamento o WHERE o.id = :id"),
    @NamedQuery(name = "Orcamento.findByDescricao", query = "SELECT o FROM Orcamento o WHERE o.descricao = :descricao"),
    @NamedQuery(name = "Orcamento.findByCliente", query = "SELECT o FROM Orcamento o WHERE o.cliente = :cliente"),
    @NamedQuery(name = "Orcamento.findByTelefone", query = "SELECT o FROM Orcamento o WHERE o.telefone = :telefone"),
    @NamedQuery(name = "Orcamento.findByValorEstimado", query = "SELECT o FROM Orcamento o WHERE o.valorEstimado = :valorEstimado")})
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String descricao;
    @Basic(optional = false)
    private String cliente;
    @Basic(optional = false)
    private String telefone;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_estimado")
    private Double valorEstimado;
    @OneToMany(mappedBy = "idOrcamento")
    private Collection<AnexoOrcamento> anexoOrcamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrcamento")
    private Collection<Sessao> sessaoCollection;

    public Orcamento() {
    }

    public Orcamento(Integer id) {
        this.id = id;
    }

    public Orcamento(Integer id, String descricao, String cliente, String telefone) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(Double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    @XmlTransient
    public Collection<AnexoOrcamento> getAnexoOrcamentoCollection() {
        return anexoOrcamentoCollection;
    }

    public void setAnexoOrcamentoCollection(Collection<AnexoOrcamento> anexoOrcamentoCollection) {
        this.anexoOrcamentoCollection = anexoOrcamentoCollection;
    }

    @XmlTransient
    public Collection<Sessao> getSessaoCollection() {
        return sessaoCollection;
    }

    public void setSessaoCollection(Collection<Sessao> sessaoCollection) {
        this.sessaoCollection = sessaoCollection;
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
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Orcamento[ id=" + id + " ]";
    }
    
}
