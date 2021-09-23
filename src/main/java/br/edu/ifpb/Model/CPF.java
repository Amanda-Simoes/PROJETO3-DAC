/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.Model;

import javax.persistence.Embeddable;

/**
 *
 * @author mandy
 */
@Embeddable
public class CPF {
    
    private static final int TAMANHO=11;
    private String numero;

    public CPF(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
