/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.Controller;

import br.edu.ifpb.Model.Integrante;
import br.edu.ifpb.persistencia.IntegrantePersistencia;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mandy
 */
@SessionScoped
@Named
public class IntegranteController implements Serializable {
    
    @Inject
    private IntegrantePersistencia persistencia;
    private Integrante integrante = new Integrante();

    /**
     * Getter e Setter
     * @return 
     */
    public IntegrantePersistencia getPersistencia() {
        return persistencia;
    }

    public void setPersistencia(IntegrantePersistencia persistencia) {
        this.persistencia = persistencia;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }
    
    /**
     * Adicionar um novo integrante
     * @return 
     */
    public String add() {
        if(this.integrante.getId() > 0){
            this.persistencia.updateIntegrante(this.integrante);
        } else {
            this.persistencia.addIntegrante(
                    this.integrante
            );
        }
        this.integrante = new Integrante();
        return "/integrante/list?faces-redirect=true";
    }
    
    /**
     * Atualiza um integrante
     * @param integrante
     * @return 
     */
    public String update(Integrante integrante) {
        this.integrante = integrante;
        return "/integrante/edit?faces-redirect=true";
        
    }
    
    /**
     * Remover um integrante
     * @param integrante
     * @return 
     */
    public String delete(Integrante integrante) {
        this.persistencia.deleteIntegrante(integrante);
        return "/integrante/list";
    }
    
    /**
     * Listar todos os integrantes
     * @return 
     */
    public List<Integrante> list() {
        return this.persistencia.listIntegrantes();
    }
    
}