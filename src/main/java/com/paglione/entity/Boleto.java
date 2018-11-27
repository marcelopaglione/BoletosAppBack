package com.paglione.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "BOLETO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = Cliente.class, cascade = CascadeType.MERGE)
    private Cliente cliente;
    @ManyToOne(targetEntity = Emissor.class, cascade = CascadeType.MERGE)
    private Emissor emissor;
    private int parcela;
    private String dataPrimeiraParcela;

    public Boleto() {
    }

    public Boleto(Cliente cliente, Emissor emissor, int parcela, String dataPrimeiraParcela) {
        this.cliente = cliente;
        this.emissor = emissor;
        this.parcela = parcela;
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", emissor=" + emissor +
                ", parcela=" + parcela +
                ", dataPrimeiraParcela='" + dataPrimeiraParcela + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Emissor getEmissor() {
        return emissor;
    }

    public void setEmissor(Emissor emissor) {
        this.emissor = emissor;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public String getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(String dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }
}
