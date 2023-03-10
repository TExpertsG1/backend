package br.com.hotel1800.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "forma_de_pagamento")
public class FormaDePagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idpagamento;
	private String forma_pagamento;
	private Integer idreserva;
	
	
	public FormaDePagamento() {}
	
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
		return "Pagamento via:  " + forma_pagamento + " ID Reserva: "
				+ idreserva;
	}
	
	
	
	
	
}
