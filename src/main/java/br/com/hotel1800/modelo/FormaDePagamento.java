package br.com.hotel1800.modelo;

public class FormaDePagamento {
	
	
	private Integer idpagamento;
	private String forma_pagamento;
	private Integer idreserva;
	
	
	public FormaDePagamento(Integer idpagamento, String forma_pagamento, Integer idreserva) {

		this.idpagamento = idpagamento;
		this.forma_pagamento = forma_pagamento;
		this.idreserva = idreserva;
	}
	

	public FormaDePagamento(String forma_pagamento, Integer idreserva) {
		this.forma_pagamento = forma_pagamento;
		this.idreserva = idreserva;
	}




	public Integer getIdpagamento() {
		return idpagamento;
	}


	public void setIdpagamento(Integer idpagamento) {
		this.idpagamento = idpagamento;
	}


	public String getForma_pagamento() {
		return forma_pagamento;
	}


	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}


	public Integer getIdreserva() {
		return idreserva;
	}


	public void setIdreserva(Integer idreserva) {
		this.idreserva = idreserva;
	}


	@Override
	public String toString() {
		return "Forma de Pagamento: " + idpagamento + " Pagamento via:  " + forma_pagamento + " ID Reserva: "
				+ idreserva;
	}
	
	
	
	
	
}
