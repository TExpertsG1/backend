package br.com.hotel1800.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "quarto")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idquarto;
    private String hotel_cnpj;
    private String nome_quarto;
    private int numero;
    private int capacidade;
    private BigDecimal diaria;

    public Quarto() {
    }

    public Quarto(int idquarto, String hotel_cnpj, String nomeQuarto, int numero, int capacidade, BigDecimal diaria) {
        this.idquarto = idquarto;
        this.hotel_cnpj = hotel_cnpj;
        this.nome_quarto = nomeQuarto;
        this.numero = numero;
        this.capacidade = capacidade;
        this.diaria = diaria;
    }

    public int getIdquarto() {
        return idquarto;
    }

    public void setIdquarto(int idquarto) {
        this.idquarto = idquarto;
    }

    public String getHotel_cnpj() {
        return hotel_cnpj;
    }

    public void setHotel_cnpj(String hotel_cnpj) {
        this.hotel_cnpj = hotel_cnpj;
    }

    public String getNome_quarto() {
        return nome_quarto;
    }

    public void setNome_quarto(String nome_quarto) {
        this.nome_quarto = nome_quarto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public BigDecimal getDiaria() {
        return diaria;
    }

    public void setDiaria(BigDecimal diaria) {
        this.diaria = diaria;
    }

    @Override
    public String toString() {
        return "ID Quarto: " + idquarto + "\n CNPJ: " + hotel_cnpj + "\n Nome Su�te: " + nome_quarto
                + "\n N�mero do Quarto: " + numero + "\n Capacidade: " + capacidade + " Pessoas " + "\n Valor da di�ria: R$ " + diaria + "\n------";
    }

}
