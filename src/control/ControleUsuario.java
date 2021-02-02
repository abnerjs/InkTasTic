/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Usuario;

public class ControleUsuario extends Controle<Usuario> {
    
    private static Usuario logado;

    public ControleUsuario() {
        super(Usuario.class);
    }

    public static Usuario getLogado() {
        return logado;
    }

    public static void setLogado(Usuario logado) {
        ControleUsuario.logado = logado;
    }

    public List<Usuario> findByNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findByNome", Usuario.class);
        String parSQL;
        parSQL = "%" + nome + "%";
        consulta.setParameter("nome", parSQL);
        return consulta.getResultList();
    }
    public Usuario findByLoginSenha(String login, String senha) {
        EntityManager em = getEntityManager();
        TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findByLoginESenha", Usuario.class);
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        return consulta.getSingleResult();
    }

    public Usuario findById(int cod) {
        EntityManager em = getEntityManager();
        TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findById", Usuario.class);
        consulta.setParameter("codigo", cod);
        return consulta.getSingleResult();
    }
    
}
