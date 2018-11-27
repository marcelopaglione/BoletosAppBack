package com.paglione.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "ENDERECO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String numero;
    private String complemento;
    private String rua;
    private String bairro;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Cidade.class, cascade = CascadeType.MERGE)
    private Cidade cidade;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Estado.class, cascade = CascadeType.MERGE)
    private Estado estado;

    public Endereco() {
    }

    public Endereco(String cep, String numero, String complemento, String rua, String bairro, Cidade cidade, Estado estado) {
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade=" + cidade +
                ", estado=" + estado +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
