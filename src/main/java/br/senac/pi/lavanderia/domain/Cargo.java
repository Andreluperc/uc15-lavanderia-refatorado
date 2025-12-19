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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author André Lupercínio
 */
@Entity(name = "cargo")
@Table(name = "cargo")
public class Cargo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private Integer idCargo;
    
    @Column(name = "nome_cargo")
    private String nomeCargo;
    
    @Column(name = "descricao_cargo")
    private String descricaoCargo;
    
    @OneToMany(mappedBy = "cargo")
    private List<Operador> operadores;

    public Cargo() {
    }

    public Cargo(int id_cargo, String nome_cargo, String descricao_cargo) {
        this.idCargo = id_cargo;
        this.nomeCargo = nome_cargo;
        this.descricaoCargo = descricao_cargo;
    }

    public Integer getId() {
        return idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public String getDescricao() {
        return descricaoCargo;
    }

    public void setId(Integer id) {
        this.idCargo = id;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public void setDescricao(String descricao) {
        this.descricaoCargo = descricao;
    }
    
    public List<Operador> getOperadores() {
        return operadores;
    }

    public void setOperadores(List<Operador> operadores) {
        this.operadores = operadores;
    }

}
