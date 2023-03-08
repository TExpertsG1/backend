package modelo;

public class FormaDePagamento {
	
	
	private int idpagamento;
	private String forma_pagamento;
	private int idreserva;
	
	
	public FormaDePagamento(int idpagamento, String forma_pagamento, int idreserva) {

		this.idpagamento = idpagamento;
		this.forma_pagamento = forma_pagamento;
		this.idreserva = idreserva;
	}
	

	public FormaDePagamento(String forma_pagamento, int idreserva) {
		this.forma_pagamento = forma_pagamento;
		this.idreserva = idreserva;
	}




	public int getIdpagamento() {
		return idpagamento;
	}


	public void setIdpagamento(int idpagamento) {
		this.idpagamento = idpagamento;
	}


	public String getForma_pagamento() {
		return forma_pagamento;
	}


	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}


	public int getIdreserva() {
		return idreserva;
	}


	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}


	@Override
	public String toString() {
		return "Forma de Pagamento: " + idpagamento + " Pagamento via:  " + forma_pagamento + " ID Reserva: "
				+ idreserva;
	}
	
	
	
	
	
}
