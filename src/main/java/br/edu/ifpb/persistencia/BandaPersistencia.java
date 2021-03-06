/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persistencia;

import br.edu.ifpb.Model.Banda;
import br.edu.ifpb.Model.Gerente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mandy
 */
@Stateless
public class BandaPersistencia {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * Adicionando uma nova banda
     * @param banda 
     */
    public void add(Banda banda) {entityManager.persist(banda);}
    
    /**
     * Atualizando uma banda
     * @param banda 
     */
    public void update(Banda banda) {entityManager.merge(banda);}
    
    /**
     * Remover uma banda
     * @param banda 
     */
    public void delete(Banda banda) {entityManager.remove(entityManager.merge(banda));}
    
    /**
     * Listando bandas apartir do FROM banda bd
     * @return 
     */
    public List<Banda> Bandas() {
        return entityManager
                .createQuery("FROM Banda bd", Banda.class)
                .getResultList();
    }
    
    /**
     * Listando gerentes apartir do FROM gerente grt
     * @return 
     */
    public List<Gerente> Gerentes () {
       return entityManager
               .createQuery("FROM Gerente grt", Gerente.class)
               .getResultList();
   }
    
    public List<Banda> search(String local) {
        
        List<Banda> resultBandas = new ArrayList<>();       
        
        List<Banda> bandas = entityManager.createQuery("FROM Banda bd", Banda.class).getResultList();
        
        for ( Banda banda : bandas ) {
            
            if ( banda.getLocalDeOrigem().equals(local) ) {
                resultBandas.add(banda);
            }            
        }
        return resultBandas;
    }

}
