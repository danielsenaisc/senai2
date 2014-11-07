/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author brunoazzi
 */
public class Conexao {

    private static final String PERSISTENCE_UNIT = "TesteDependenciaOraclePU";

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    private static final EntityManager em = factory.createEntityManager();

    protected static void getTransaction() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    protected static void commit() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    /**
     * Método que permite a persistencia de Objetos no Banco de Dados
     *
     * @param aThis Objeto a ser persistida
     */
    public static void persist(Object aThis) {
        getTransaction();
        em.persist(aThis);
        commit();
    }

    /**
     * Método que permite a remoção de Entidades do Banco de Dados
     *
     * @param aThis Objeto a ser removida
     */
    protected static void remove(Object aThis) {
        getTransaction();
        em.remove(aThis);
        commit();
    }

    protected static List<Object> namedQuery(String namedQuery) {
        Query query = em.createNamedQuery(namedQuery);
        return query.getResultList();
    }

    protected static List<Object> namedQuery(String namedQuery, List<Object> values, String[] parameters) {
        Query query = em.createNamedQuery(namedQuery);

        for (int iterador = 0; iterador < values.size(); iterador++) {
            query.setParameter(parameters[iterador], values.get(iterador));
        }

        return query.getResultList();
    }

    protected static List<Object> namedQuery(String namedQuery, Object value, String parameter) {
        List<Object> result;

        getTransaction();
        Query query = em.createNamedQuery(namedQuery);
        query.setParameter(parameter, value);
        result = query.getResultList();
        commit();

        return result;
    }

    protected static Object singleResultNamedQuery(String namedQuery, List<Object> values, String[] parameters) {
        Query query = em.createNamedQuery(namedQuery);

        for (int iterador = 0; iterador < values.size(); iterador++) {
            query.setParameter(parameters[iterador], values.get(iterador));
        }

        return query.getSingleResult();
    }

    protected static Object singleResultNamedQuery(String namedQuery, Object value, String parameter) {
        Query query = em.createNamedQuery(namedQuery);
        query.setParameter(parameter, value);
        return query.getSingleResult();
    }

    protected static List<Object> queryResultList(String query) {
        Query selectAll = em.createNamedQuery(query);
        return selectAll.getResultList();
    }

    protected static Object querySingleResult(String query) {
        Query select = em.createNamedQuery(query);
        return select.getSingleResult();
    }

    protected static EntityManager getEm() {
        return em;
    }

}
