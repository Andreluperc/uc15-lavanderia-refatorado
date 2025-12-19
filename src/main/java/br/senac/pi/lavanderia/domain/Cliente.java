/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.pi.lavanderia.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

/**
 *
 * @author André Lupercínio
 */
@Entity(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;
    
    @Column(name = "nome_cliente")
    private String nome;
    
    @Column(name = "cpf_cliente")
    private String CPF;
    
    @Column(name = "data_nasc_cliente")
    private Date dataNasc;
    
    @Column(name = "rua_cliente")
    private String rua;
    
    @Column(name = "bairro_cliente")
    private String bairro;
    
    @Column(name = "cidade_cliente")
    private String cidade;
    
    @Column(name = "estado_cliente")
    private String estado;
    
    @Column(name = "numero_cliente")
    private int numero;
    
    @Column(name = "telefone_cliente")
    private String telefone;
    
    @Column(name = "email_cliente")
    private String email;

   
    public Cliente() {
    }

    public Cliente(int id, String nome, String CPF, Date dataNasc, String rua, String bairro, String cidade, String estado, int numero, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.dataNasc = dataNasc;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
