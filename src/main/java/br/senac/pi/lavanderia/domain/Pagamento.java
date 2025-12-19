/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.pi.lavanderia.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author André Lupercínio
 */
@Entity(name = "pagamento")
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo_pagamento;
    
    @Temporal(TemporalType.DATE)
    private Date data_pagamento;

    public Pagamento() {
    }

    public Pagamento(int id, String tipoPagamento, Date dataPagamento) {
        this.id = id;
        this.tipo_pagamento = tipoPagamento;
        this.data_pagamento = dataPagamento;
    }

    public Integer getId() {
        return id;
    }

    public String getTipoPagamento() {
        return tipo_pagamento;
    }

    public Date getDataPagamento() {
        return data_pagamento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipo_pagamento = tipoPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.data_pagamento = dataPagamento;
    }
}
