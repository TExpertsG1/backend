package br.com.hotel1800.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcargos;
    private String cargo;
    private BigDecimal salario;

    public Cargo() {
    }

    public Cargo(Integer idcargos, String cargo, BigDecimal salario) {
        this.idcargos = idcargos;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Cargo(String cargo, BigDecimal salario) {
        this.cargo = cargo;
        this.salario = salario;
    }

    public Integer getIdcargos() {
        return idcargos;
    }

    public void setIdcargos(Integer idcargos) {
        this.idcargos = idcargos;
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
        return "ID Cargo: " + idcargos + "\n " + cargo + "\n Sal�rio: " + salario + "\n------";
    }
}
