/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.infra.persistencia;

import br.edu.ifpb.Model.Integrante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mandy
 */
@Stateless
public class IntegrantePersistencia {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * Adicionar um novo integrante
     * @param integrante 
     */
    public void addIntegrante(Integrante integrante) {
        entityManager.persist(integrante);   
    }
    
    /**
     * Atualizar um integrante
     * @param integrante 
     */
    public void updateIntegrante (Integrante integrante) {
      entityManager.merge(integrante);
    }
    
    /**
     * Deletar um integrante
     * @param integrante 
     */
    public void deleteIntegrante (Integrante integrante) {
        entityManager.remove(entityManager.merge(integrante));
    }
    
    /**
     * Listar integrantes
     * @return 
     */
    public List<Integrante>  listIntegrantes() {
        return entityManager.createQuery("FROM Integrante i", Integrante.class).getResultList();
    }
    
    public Integrante searchCPF(String cpf) {
        
        List<Integrante> allIntegrantes = entityManager.createQuery("FROM Integrante a", Integrante.class).getResultList();
        
        for ( Integrante integrante : allIntegrantes ) {  
            if ( integrante.getCpf().equals(cpf) ) {
                return integrante;
            }
        }
        return null;
    }
    
}
