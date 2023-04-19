package br.com.hotel1800.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @Column(name = "cnpj", unique = true)
    private String cnpj;
    private String nome;
    private String logradouro;
    private String cep;
    private String uf;
    private String cidade;

    public Hotel() {
    }

    public Hotel(String cnpj, String nome, String logradouro, String cep, String uf, String cidade) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Hotel [cnpj=" + cnpj + ", nome=" + nome + ", logradouro=" + logradouro + ", cep=" + cep + ", uf=" + uf
                + ", cidade=" + cidade + "]";
    }

}
