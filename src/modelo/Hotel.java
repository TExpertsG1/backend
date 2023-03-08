package modelo;

public class Hotel {
	
	private String cnpj;
	private String nome_hotel;
	private String logradouro;
	private String cep;
	private String uf;
	private String cidade;
	
	
	public Hotel(String cnpj, String nome_hotel, String logradouro, String cep, String uf, String estado) {
	
		this.cnpj = cnpj;
		this.nome_hotel = nome_hotel;
		this.logradouro = logradouro;
		this.cep = cep;
		this.uf = uf;
		this.estado = estado;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getNome_hotel() {
		return nome_hotel;
	}


	public void setNome_hotel(String nome_hotel) {
		this.nome_hotel = nome_hotel;
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
		return "CNPJ: " + cnpj + "\nNome do Hotel: " + nome_hotel + "\nLogradouro: " + logradouro + ", CEP: " + cep
				+ ", UF: " + uf + ", Cidade: " + cidade;
	}
	
	

}
