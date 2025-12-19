/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.pi.lavanderia.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author André Lupercínio
 */
@Entity(name = "operador")
@Table(name = "operador")
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_operador;
    
    @Column(name = "nome_operador")
    private String nome_operador;
    
    @Column(name = "cpf_operador")
    private String cpf_operador;
    
    @Column(name = "matricula_operador")
    private String matricula_operador;
    
    @Column(name = "telefone_operador")
    private String telefone_operador;
    
    @Column(name = "email_operador")
    private String email_operador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    public Operador() {
    }

    public Operador(int id, String nome, String CPF, String matricula, String telefone, String email, Cargo cargo) {
        this.id_operador = id;
        this.nome_operador = nome;
        this.cpf_operador = CPF;
        this.matricula_operador = matricula;
        this.telefone_operador = telefone;
        this.email_operador = email;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id_operador;
    }

    public String getNome() {
        return nome_operador;
    }

    public String getCPF() {
        return cpf_operador;
    }

    public String getMatricula() {
        return matricula_operador;
    }

    public String getTelefone() {
        return telefone_operador;
    }

    public String getEmail() {
        return email_operador;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setId(Integer id) {
        this.id_operador = id;
    }

    public void setNome(String nome) {
        this.nome_operador = nome;
    }

    public void setCPF(String CPF) {
        this.cpf_operador = CPF;
    }

    public void setMatricula(String matricula) {
        this.matricula_operador = matricula;
    }

    public void setTelefone(String telefone) {
        this.telefone_operador = telefone;
    }

    public void setEmail(String email) {
        this.email_operador = email;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
