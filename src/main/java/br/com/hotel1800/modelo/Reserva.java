package br.com.hotel1800.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreserva;
	private int idquarto;
	private String hospede_cpf;
	private int quantidade_adulto;
	private int quantidade_crianca;
	private LocalDate data_check_in;
	private LocalDate data_check_out;

	public Reserva(int idreserva, int idquarto, String hospede_cpf, int quantidade_adultos, int quantidade_crianca,
			LocalDate data_check_in, LocalDate data_check_out) {
		this.idreserva = idreserva;
		this.idquarto = idquarto;
		this.hospede_cpf = hospede_cpf;
		this.quantidade_adulto = quantidade_adultos;
		this.quantidade_crianca = quantidade_crianca;
		this.data_check_in = data_check_in;
		this.data_check_out = data_check_out;
	}


	public Reserva () {}
	
	public Reserva(int idquarto, String hospede_cpf, int quantidade_adulto, int quantidade_crianca,
			LocalDate data_check_in, LocalDate data_check_out) {
		this.idquarto = idquarto;
		this.hospede_cpf = hospede_cpf;
		this.quantidade_adulto = quantidade_adulto;
		this.quantidade_crianca = quantidade_crianca;
		this.data_check_in = data_check_in;
		this.data_check_out = data_check_out;
	}
	

	public int getIdreserva() {
		return idreserva;
	}

	public int getIdquarto() {
		return idquarto;
	}

	public void setIdquarto(int idquarto) {
		this.idquarto = idquarto;
	}

	public String getHospede_cpf() {
		return hospede_cpf;
	}

	public void setHospede_cpf(String hospede_cpf) {
		this.hospede_cpf = hospede_cpf;
	}

	public int getQuantidade_adulto() {
		return quantidade_adulto;
	}

	public void setQuantidade_adultos(int quantidade_adulto) {
		this.quantidade_adulto = quantidade_adulto;
	}

	public int getQuantidade_crianca() {
		return quantidade_crianca;
	}

	public void setQuantidade_crianca(int quantidade_crianca) {
		this.quantidade_crianca = quantidade_crianca;
	}

	public LocalDate getData_check_in() {
		return data_check_in;
	}

	public void setData_check_in(LocalDate data_check_in) {
		this.data_check_in = data_check_in;
	}

	public LocalDate getData_check_out() {
		return data_check_out;
	}

	public void setData_check_out(LocalDate data_check_out) {
		this.data_check_out = data_check_out;
	}


	@Override
	public String toString() {
		return "ID Reserva: " + idreserva + "\nID Quarto: " + idquarto + "\nCPF do Hospede: " + hospede_cpf
				+ "\nQuantidade de Adultos: " + quantidade_adulto + "\nQuantidade de Crianca: " + quantidade_crianca
				+ "\nData Check-IN: "+ data_check_in.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
				+ "\nData Check-OUT: "+ data_check_out.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n------";
	}

}