/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mandy
 * Created: 22 de set de 2021
 */

CREATE TABLE integrante(
    id serial PRIMARY KEY,
    nome VARCHAR(50),
    dataDeNascimento DATE,
    CPF VARCHAR(15)
);
