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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author André Lupercínio
 */
@Entity(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    @Column(name = "quantidade_pecas_pedido")
    private int quantidadePecas;

    @Column(name = "data_entrada_pedido")
    private String dataEntrada;

    @Column(name = "data_entrega_pedido")
    private String dataEntrega;

    @ManyToOne
    @JoinColumn(name = "cliente_id") // nome da coluna FK no banco de dados
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(int id, int quantidadePecas, String dataEntrada, String dataEntrega) {
        this.id = id;
        this.quantidadePecas = quantidadePecas;
        this.dataEntrada = dataEntrada;
        this.dataEntrega = dataEntrega;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantidadePecas() {
        return quantidadePecas;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuantidadePecas(Integer quantidadePecas) {
        this.quantidadePecas = quantidadePecas;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
