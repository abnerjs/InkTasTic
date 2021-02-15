/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abner
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c"),
    @NamedQuery(name = "Caixa.findById", query = "SELECT c FROM Caixa c WHERE c.id = :id"),
    @NamedQuery(name = "Caixa.findByAbertura", query = "SELECT c FROM Caixa c WHERE c.abertura = :abertura"),
    @NamedQuery(name = "Caixa.findByFechamento", query = "SELECT c FROM Caixa c WHERE c.fechamento = :fechamento"),
    @NamedQuery(name = "Caixa.findAberto", query = "SELECT c FROM Caixa c WHERE c.fechamento = null"),
    @NamedQuery(name = "Caixa.findBySaldoInicial", query = "SELECT c FROM Caixa c WHERE c.saldoInicial = :saldoInicial"),
    @NamedQuery(name = "Caixa.findBySaldoFinal", query = "SELECT c FROM Caixa c WHERE c.saldoFinal = :saldoFinal"),
    @NamedQuery(name = "Caixa.findByEntradas", query = "SELECT c FROM Caixa c WHERE c.entradas = :entradas"),
    @NamedQuery(name = "Caixa.findBySaidas", query = "SELECT c FROM Caixa c WHERE c.saidas = :saidas")})
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date abertura;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo_inicial")
    private Double saldoInicial;
    @Basic(optional = false)
    @Column(name = "saldo_final")
    private double saldoFinal;
    private Double entradas;
    private Double saidas;
    @OneToMany(mappedBy = "caixa")
    private Collection<Sessao> sessaoCollection;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(mappedBy = "caixa")
    private Collection<Gasto> gastoCollection;

    public Caixa() {
    }

    public Caixa(Integer id) {
        this.id = id;
    }

    public Caixa(Integer id, Date abertura, Date fechamento, double saldoFinal) {
        this.id = id;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.saldoFinal = saldoFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Double getEntradas() {
        return entradas;
    }

    public void setEntradas(Double entradas) {
        this.entradas = entradas;
    }

    public Double getSaidas() {
        return saidas;
    }

    public void setSaidas(Double saidas) {
        this.saidas = saidas;
    }

    @XmlTransient
    public Collection<Sessao> getSessaoCollection() {
        return sessaoCollection;
    }

    public void setSessaoCollection(Collection<Sessao> sessaoCollection) {
        this.sessaoCollection = sessaoCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<Gasto> getGastoCollection() {
        return gastoCollection;
    }

    public void setGastoCollection(Collection<Gasto> gastoCollection) {
        this.gastoCollection = gastoCollection;
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
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Caixa[ id=" + id + " ]";
    }
    
}
