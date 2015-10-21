package com.sysbovino.entidades;
// Generated 07/10/2015 20:17:36 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;  
import javax.persistence.Entity;  

/**
 * Propriedade generated by hbm2java
 */
@Entity
@Table(name = "propriedade", catalog = "projetoSistemas")
public class Propriedade implements java.io.Serializable {

	private Integer codPropriedade;
	private int codPessoa;
	private int codCidade;
	private Integer numIncra;
	private Integer numRegistroCartorio;
	private Integer haTotal;
	private Integer capacidadeAnimais;
	private Integer codCidadeCartorio;

	public Propriedade() {
	}

	public Propriedade(int codPessoa, int codCidade) {
		this.codPessoa = codPessoa;
		this.codCidade = codCidade;
	}

	public Propriedade(int codPessoa, int codCidade, Integer numIncra, Integer numRegistroCartorio, Integer haTotal,
			Integer capacidadeAnimais, Integer codCidadeCartorio) {
		this.codPessoa = codPessoa;
		this.codCidade = codCidade;
		this.numIncra = numIncra;
		this.numRegistroCartorio = numRegistroCartorio;
		this.haTotal = haTotal;
		this.capacidadeAnimais = capacidadeAnimais;
		this.codCidadeCartorio = codCidadeCartorio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "cod_propriedade", unique = true, nullable = false)
	public Integer getCodPropriedade() {
		return this.codPropriedade;
	}

	public void setCodPropriedade(Integer codPropriedade) {
		this.codPropriedade = codPropriedade;
	}

	@Column(name = "cod_pessoa", nullable = false)
	public int getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	@Column(name = "cod_cidade", nullable = false)
	public int getCodCidade() {
		return this.codCidade;
	}

	public void setCodCidade(int codCidade) {
		this.codCidade = codCidade;
	}

	@Column(name = "num_incra")
	public Integer getNumIncra() {
		return this.numIncra;
	}

	public void setNumIncra(Integer numIncra) {
		this.numIncra = numIncra;
	}

	@Column(name = "num_registroCartorio")
	public Integer getNumRegistroCartorio() {
		return this.numRegistroCartorio;
	}

	public void setNumRegistroCartorio(Integer numRegistroCartorio) {
		this.numRegistroCartorio = numRegistroCartorio;
	}

	@Column(name = "ha_total")
	public Integer getHaTotal() {
		return this.haTotal;
	}

	public void setHaTotal(Integer haTotal) {
		this.haTotal = haTotal;
	}

	@Column(name = "capacidade_animais")
	public Integer getCapacidadeAnimais() {
		return this.capacidadeAnimais;
	}

	public void setCapacidadeAnimais(Integer capacidadeAnimais) {
		this.capacidadeAnimais = capacidadeAnimais;
	}

	@Column(name = "cod_cidadeCartorio")
	public Integer getCodCidadeCartorio() {
		return this.codCidadeCartorio;
	}

	public void setCodCidadeCartorio(Integer codCidadeCartorio) {
		this.codCidadeCartorio = codCidadeCartorio;
	}

}