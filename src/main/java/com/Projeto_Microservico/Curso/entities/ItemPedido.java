package com.Projeto_Microservico.Curso.entities;

import java.io.Serializable;
import java.util.Objects;

import com.Projeto_Microservico.Curso.entities.pk.PkItemPedido;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PkItemPedido id = new PkItemPedido();

	private Integer quantidade;
	private Double preco;

	public ItemPedido() {
	}

	public ItemPedido(Pedidos pedidos, Produto produto, Integer quantidade, Double preco) {
		id.setPedidos(pedidos);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Pedidos getPedidos() {
		return id.getPedidos();
	}

	public void setPedidos(Pedidos pedidos) {
		id.setPedidos(pedidos);
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getSubTotal() {
		return preco * quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}

}
