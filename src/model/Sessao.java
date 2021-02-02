/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abner
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessao.findAll", query = "SELECT s FROM Sessao s"),
    @NamedQuery(name = "Sessao.findById", query = "SELECT s FROM Sessao s WHERE s.id = :id"),
    @NamedQuery(name = "Sessao.findByValor", query = "SELECT s FROM Sessao s WHERE s.valor = :valor"),
    @NamedQuery(name = "Sessao.findByHorario", query = "SELECT s FROM Sessao s WHERE s.horario = :horario"),
    @NamedQuery(name = "Sessao.findByDuracaoMaxima", query = "SELECT s FROM Sessao s WHERE s.duracaoMaxima = :duracaoMaxima"),
    @NamedQuery(name = "Sessao.findByPago", query = "SELECT s FROM Sessao s WHERE s.pago = :pago")})
public class Sessao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private double valor;
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @Column(name = "duracao_maxima")
    @Temporal(TemporalType.TIME)
    private Date duracaoMaxima;
    private Boolean pago;
    @JoinColumn(name = "caixa", referencedColumnName = "id")
    @ManyToOne
    private Caixa caixa;
    @JoinColumn(name = "id_orcamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Orcamento idOrcamento;

    public Sessao() {
    }

    public Sessao(Integer id) {
        this.id = id;
    }

    public Sessao(Integer id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Date getDuracaoMaxima() {
        return duracaoMaxima;
    }

    public void setDuracaoMaxima(Date duracaoMaxima) {
        this.duracaoMaxima = duracaoMaxima;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
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
        if (!(object instanceof Sessao)) {
            return false;
        }
        Sessao other = (Sessao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sessao[ id=" + id + " ]";
    }
    
}
