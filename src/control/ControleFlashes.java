/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Flashes;

public class ControleFlashes extends Controle<Flashes> {
    
    public ControleFlashes() {
        super(Flashes.class);
    }

    public List<Flashes> findAll() {
        EntityManager em = getEntityManager();
        TypedQuery<Flashes> consulta = em.createNamedQuery("Flashes.findAll", Flashes.class);
        return consulta.getResultList();
    }
    
}
