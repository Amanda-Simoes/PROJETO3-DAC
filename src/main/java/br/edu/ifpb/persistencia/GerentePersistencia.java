/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persistencia;

import br.edu.ifpb.Model.Gerente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mandy
 */
@Stateless
public class GerentePersistencia {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * Adicionar novo gerente
     * @param gerente 
     */
    public void add(Gerente gerente) {entityManager.persist(gerente);}
    
    /**
     * Atualizando um gerente
     * @param gerente 
     */
    public void update(Gerente gerente){entityManager.persist(gerente);}
    
    /**
     * Removendo gerente
     * @param gerente 
     */
    public void delete(Gerente gerente) {entityManager.remove(gerente);}
    
    /**
     * Listando os gerentes pelo FROM gerente gnt
     * @return 
     */
    public List<Gerente> list () {
        return entityManager.createQuery("FROM Gerente gnt", Gerente.class).getResultList();}
    
}
