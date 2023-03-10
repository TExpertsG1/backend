package br.com.hotel1800.modelo;

public class Quarto {
	
	private int idquarto;
	private String hotel_cnpj;
	private String nomeQuarto;
	private int numero;
	private int capacidade;
	private double diaria;
	
	public Quarto(int idquarto, String hotel_cnpj, String nomeQuarto, int numero, int capacidade, double diaria) {
		this.idquarto = idquarto;
		this.hotel_cnpj = hotel_cnpj;
		this.nomeQuarto = nomeQuarto;
		this.numero = numero;
		this.capacidade = capacidade;
		this.diaria = diaria;
	}
	
	public Quarto(String hotel_cnpj, String nomeQuarto, int numero, int capacidade, double diaria) {
		this.hotel_cnpj = hotel_cnpj;
		this.nomeQuarto = nomeQuarto;
		this.numero = numero;
		this.capacidade = capacidade;
		this.diaria = diaria;
	}
	
	

	public Quarto() {
		// TODO Auto-generated constructor stub
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

	public String getNomeQuarto() {
		return nomeQuarto;
	}

	public void setNomeQuarto(String nomeQuarto) {
		this.nomeQuarto = nomeQuarto;
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

	public double getDiaria() {
		return diaria;
	}

	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}

	@Override
	public String toString() {
		return "ID Quarto: " + idquarto + "\n CNPJ: " + hotel_cnpj + "\n Nome Su?te: " + nomeQuarto
				+ "\n N?mero do Quarto: " + numero + "\n Capacidade: " + capacidade + " Pessoas " + "\n Valor da di?ria: R$ " + diaria + "\n------";
	}


	
}
