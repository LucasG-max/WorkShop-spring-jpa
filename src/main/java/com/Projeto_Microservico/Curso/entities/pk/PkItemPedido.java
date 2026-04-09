package com.Projeto_Microservico.Curso.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.Projeto_Microservico.Curso.entities.Pedidos;
import com.Projeto_Microservico.Curso.entities.Produto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PkItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "pedidos_id")
	private Pedidos pedidos;
	
	public PkItemPedido() {}
	
	public PkItemPedido(Produto produto, Pedidos pedidos) {
		super();
		this.produto = produto;
		this.pedidos = pedidos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedidos, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PkItemPedido other = (PkItemPedido) obj;
		return Objects.equals(pedidos, other.pedidos) && Objects.equals(produto, other.produto);
	}
	
	

	
	
	

}
