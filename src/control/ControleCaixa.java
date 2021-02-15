/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Caixa;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import util.Conversoes;

public class ControleCaixa extends Controle<Caixa> {

    private static Caixa caixa;

    public static Caixa getCaixa() {
        return caixa;
    }

    public static void setCaixa(Caixa caixa) {
        ControleCaixa.caixa = caixa;
    }

    public ControleCaixa() {
        super(Caixa.class);
    }

    public List<Caixa> findByDatas(String data1, String data2) {
        EntityManager em = getEntityManager();
        TypedQuery<Caixa> consulta = em.createNamedQuery("Caixa.findByData", Caixa.class);
        consulta.setParameter("data1", Conversoes.getStringToDate(data1));
        consulta.setParameter("data2", Conversoes.getStringToDate(data2));
        consulta.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return consulta.getResultList();
    }

    public Caixa findAberto() {
        EntityManager em = getEntityManager();
        TypedQuery<Caixa> consulta = em.createNamedQuery("Caixa.findAberto", Caixa.class);
        consulta.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return consulta.getSingleResult();
    }

    public List<Caixa> findAll() {
        EntityManager em = getEntityManager();
        TypedQuery<Caixa> consulta = em.createNamedQuery("Caixa.findAll", Caixa.class);
        String parSQL;
        consulta.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return consulta.getResultList();
    }

}
