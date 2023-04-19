package br.com.hotel1800.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cargo;
    private BigDecimal salario;

    public Cargo() {
    }

    public Cargo(Integer id, String cargo, BigDecimal salario) {
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Cargo(String cargo, BigDecimal salario) {
        this.cargo = cargo;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "ID Cargo: " + id + "\n " + cargo + "\n Salário: " + salario + "\n------";
    }
}
