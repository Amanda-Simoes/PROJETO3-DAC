/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.Model;

import br.edu.ifpb.converter.ConversorData;
import br.edu.ifpb.converter.ConversorDataNascimento;
import br.edu.ifpb.convertercolumn.ConverterLocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mandy
 */
@Entity
public class Integrante implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String  cpf;
    
    @Temporal(value = TemporalType.DATE)
    @Convert(converter = ConverterLocalDate.class)
    private LocalDate dataDeNascimento;
    
    /**
     * Construtor vazio
     */
    public Integrante(){}
    
    public Integrante(String nome, LocalDate dataDeNascimento, String cpf){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public Integrante(int id, String nome, String cpf, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    
    
    /**
     * Getter e Setter
     * @return 
     */
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}