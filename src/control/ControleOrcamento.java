/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.AnexoOrcamento;
import model.Orcamento;

public class ControleOrcamento extends Controle<Orcamento> {
    
    ControleAnexos ca = new ControleAnexos();
    
    public ControleOrcamento() {
        super(Orcamento.class);
    }
    
    @Override
    public void persist(Orcamento objeto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        for (AnexoOrcamento anexoOrcamento : objeto.getAnexoOrcamentoCollection()) {
            anexoOrcamento.setIdOrcamento(objeto);
        }
        em.getTransaction().commit();
    }
    
    @Override
    public void delete(Orcamento objeto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        for (AnexoOrcamento anexoOrcamento : objeto.getAnexoOrcamentoCollection()) {
            ca.delete(anexoOrcamento);
        }
        em.remove(em.merge(objeto));
        em.getTransaction().commit();
    }

    @Override
    public void alter(Orcamento objeto) {
        for (AnexoOrcamento anexoOrcamento : objeto.getAnexoOrcamentoCollection()) {
            anexoOrcamento.setIdOrcamento(objeto);
        }
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    public List<Orcamento> findByCliente(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Orcamento> consulta = em.createNamedQuery("Orcamento.findByCliente", Orcamento.class);
        String parSQL;
        parSQL = "%" + nome + "%";
        consulta.setParameter("cliente", parSQL);
        return consulta.getResultList();
    }
    
}
