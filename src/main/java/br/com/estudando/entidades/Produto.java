package br.com.estudando.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TB_produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double valor;
	private String imgUrl;

	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "TB_produto_categoria", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categorias = new HashSet<>();

	public Produto() {

	}

	public Produto(Long id, String nome, String descricao, Double valor, String imgUrl) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	@JsonIgnore
	public Set<Pedido> getPedido() {
		Set<Pedido> pedidosEncontrados = new HashSet<>();
		for (ItemPedido itemPedidoEncontrados : itens) {
			pedidosEncontrados.add(itemPedidoEncontrados.getPedido());
		}
		return pedidosEncontrados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
