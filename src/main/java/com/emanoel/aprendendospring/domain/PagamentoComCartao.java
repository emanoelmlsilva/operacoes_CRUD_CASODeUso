package com.emanoel.aprendendospring.domain;

import javax.persistence.Entity;

import com.emanoel.aprendendospring.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
		super();
	}
	
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido,Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelos() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelos(Integer numeroDeParcelos) {
		this.numeroDeParcelas = numeroDeParcelos;
	}
	

}
