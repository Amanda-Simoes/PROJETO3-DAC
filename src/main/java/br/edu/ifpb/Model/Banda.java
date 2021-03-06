/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author mandy
 */
@Entity
public class Banda implements Serializable{
    
    /**
     * Atribuindo um ID e geração de um id serial
     */
    @Id
    @GeneratedValue
    private int id;
    private String localDeOrigem;
    private String nomeFantasia;
    
    /**
     * Relacionamento 1 pra 1
     */
    @OneToOne
    private Gerente gerente; 
    
    /**
     * Relacionamento 1 pra N
     */
    @OneToMany
    @JoinColumn(name = "banda_id")
    private List<Integrante> integrantes;
    
    /**
     * Construtor vazio
     */
    public Banda () {}

    public Banda(int id, String localDeOrigem, String nomeFantasia, Gerente gerente, List<Integrante> integrantes) {
        this.id = id;
        this.localDeOrigem = localDeOrigem;
        this.nomeFantasia = nomeFantasia;
        this.gerente = gerente;
        this.integrantes = integrantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }
    
}
