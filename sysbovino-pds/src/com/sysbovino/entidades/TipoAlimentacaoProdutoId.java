package com.sysbovino.entidades;
// Generated 07/10/2015 20:17:36 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TipoAlimentacaoProdutoId generated by hbm2java
 */
@Embeddable
public class TipoAlimentacaoProdutoId implements java.io.Serializable {

	private int codAlimentacao;
	private int codProduto;
	private int seqItem;

	public TipoAlimentacaoProdutoId() {
	}

	public TipoAlimentacaoProdutoId(int codAlimentacao, int codProduto, int seqItem) {
		this.codAlimentacao = codAlimentacao;
		this.codProduto = codProduto;
		this.seqItem = seqItem;
	}

	@Column(name = "cod_alimentacao", nullable = false)
	public int getCodAlimentacao() {
		return this.codAlimentacao;
	}

	public void setCodAlimentacao(int codAlimentacao) {
		this.codAlimentacao = codAlimentacao;
	}

	@Column(name = "cod_produto", nullable = false)
	public int getCodProduto() {
		return this.codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	@Column(name = "seq_item", nullable = false)
	public int getSeqItem() {
		return this.seqItem;
	}

	public void setSeqItem(int seqItem) {
		this.seqItem = seqItem;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TipoAlimentacaoProdutoId))
			return false;
		TipoAlimentacaoProdutoId castOther = (TipoAlimentacaoProdutoId) other;

		return (this.getCodAlimentacao() == castOther.getCodAlimentacao())
				&& (this.getCodProduto() == castOther.getCodProduto()) && (this.getSeqItem() == castOther.getSeqItem());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodAlimentacao();
		result = 37 * result + this.getCodProduto();
		result = 37 * result + this.getSeqItem();
		return result;
	}

}
