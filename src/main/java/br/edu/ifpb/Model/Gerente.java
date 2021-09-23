/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author mandy
 */
@Entity
public class Gerente implements Serializable{
    
    /**
     * Atribuindo um ID e geração de um id serial
     */
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String email;
    private String cpf;
    
    /**
     * Relacionamento 1 pra 1
     */
    @OneToOne
    private Banda banda;
    
    /**
     * Construtor vazio
     */
    public Gerente(){}

    public Gerente(int id, String nome, String email, String cpf, Banda banda) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.banda = banda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
    
}
