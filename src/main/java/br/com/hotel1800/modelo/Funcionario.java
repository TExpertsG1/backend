package br.com.hotel1800.modelo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    private String cpf;
    private int idcargos;
    private String hotel_cnpj;
    private String nome;
    private String imagem;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_nascimento;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_admissao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_demissao;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String cpf, int idcargos, String hotel_cnpj, String nome, String imagem, LocalDate data_nascimento, LocalDate data_admissao, LocalDate data_demissao, String logradouro, int numero, String complemento, String bairro, String cidade, String uf, String cep, String senha) {
        this.cpf = cpf;
        this.idcargos = idcargos;
        this.hotel_cnpj = hotel_cnpj;
        this.nome = nome;
        this.imagem = imagem;
        this.data_nascimento = data_nascimento;
        this.data_admissao = data_admissao;
        this.data_demissao = data_demissao;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.senha = senha;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdcargos() {
        return idcargos;
    }

    public void setIdcargos(int idcargos) {
        this.idcargos = idcargos;
    }

    public String getHotel_cnpj() {
        return hotel_cnpj;
    }

    public void setHotel_cnpj(String hotel_cnpj) {
        this.hotel_cnpj = hotel_cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public LocalDate getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(LocalDate data_admissao) {
        this.data_admissao = data_admissao;
    }

    public LocalDate getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(LocalDate data_demissao) {
        this.data_demissao = data_demissao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }



    @Override
    public String toString() {
        return "CPF: " + cpf + "\n ID Cargo: " + idcargos + "\n CNPJ: " + hotel_cnpj + "\n Nome: " + nome
                + "\n Data Nascimento: " + data_nascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + "\n Data Admissao: " + data_admissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + "\n Data Demissao: " + data_demissao
                + "\n Endere�o, " + logradouro + " n� " + numero + ", Complemento: " + complemento + ", Bairro: "
                + bairro + ", Cidade: " + cidade + ", UF: " + uf + ", CEP: " + cep + ", senha: " + senha + "\n------";
    }
}