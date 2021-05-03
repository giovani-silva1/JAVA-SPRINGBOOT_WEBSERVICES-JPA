package br.com.estudando.entidades;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_pagamento")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant data;

	@OneToOne
	@MapsId
	private Pedido pedido;

	
	public Pagamento() {
	}


	public Pagamento(Long id, Instant data, Pedido pedido) {
	
		this.id = id;
		this.data = data;
		this.pedido = pedido;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getData() {
		return data;
	}


	public void setData(Instant data) {
		this.data = data;
	}


	@JsonIgnore
	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
	
	
}
