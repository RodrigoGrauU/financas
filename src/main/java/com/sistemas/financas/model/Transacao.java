package com.sistemas.financas.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private int id;

    @Column(name = "id_tipo")
    private int tipo;

    @Column(name = "id_conta")
    private int idConta;

    @Column(name = "valor_transacao")
    private double valorTransacao;

    @Column(name = "descricao_transacao")
    private String descricaoTransacao;

    @JsonFormat(pattern="yyyy-MM-dd", timezone="EST")
    @Column(name = "data_transacao")
    @Temporal(TemporalType.DATE)
    private java.util.Date dataTransacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public java.util.Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(java.util.Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getDescricaoTransacao() {
        return descricaoTransacao;
    }

    public void setDescricaoTransacao(String descricaoTransacao) {
        this.descricaoTransacao = descricaoTransacao;
    }
}
