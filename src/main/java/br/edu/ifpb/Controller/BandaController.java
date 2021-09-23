/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.Controller;

import br.edu.ifpb.Model.Banda;
import br.edu.ifpb.persistencia.BandaPersistencia;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mandy
 */
public class BandaController implements Serializable{
    @Inject
    private BandaPersistencia bandas;
    private Banda banda = new Banda();

    public BandaPersistencia getBandas() {
        return bandas;
    }

    public void setBandas(BandaPersistencia bandas) {
        this.bandas = bandas;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
    
    public String adicionar () {
        if ( this.banda.getId() > 0 ) {
            this.bandas.update(banda);
        } else {
            this.bandas.add(this.banda);
        }
        this.banda = new Banda();
        return "/banda/list?faces-redirect=true";
    }
        
    public String update(Banda banda) {
        this.banda = banda;
        return "/banda/edit?faces-redirect=true";
    }
    
    public String remover (Banda banda) {
        this.bandas.delete(banda);
        return "/Banda/list";
    }
    
    public List<Banda> listar () {
        return this.bandas.Bandas();
    }
        
        
    
}
