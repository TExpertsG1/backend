package br.com.hotel1800.modelo;

import java.time.LocalDate;

public class Hospede {
	private String cpf;
	private String nome;
	private LocalDate data_nascimento;
	private String telefone;
	private String email;
	
	public Hospede(String cpf, String nome, LocalDate data_nascimento, String telefone, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.telefone = telefone;
		this.email = email;
	}

	
	
	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public LocalDate getData_nascimento() {
		return data_nascimento;
	}



	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "CPF: " + cpf + "\n Nome: " + nome + "\n Data de Nascimento: " + data_nascimento + "\n Telefone: "
				+ telefone + "\n E-mail: " + email+ "\n------";
	}
	
	
	
	
}
