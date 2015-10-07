package com.sysbovino.entidades;
// Generated 07/10/2015 20:17:36 by Hibernate Tools 4.0.0

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

/**
 * Pais generated by hbm2java
 */
@Entity
@Table(name = "pais", catalog = "projetoSistemas")
public class Pais implements java.io.Serializable {

	private int codPais;
	private String nomePais;

	public Pais() {
	}

	public Pais(int codPais, String nomePais) {
		this.codPais = codPais;
		this.nomePais = nomePais;
	}

	@Id

	@Column(name = "cod_pais", unique = true, nullable = false)
	public int getCodPais() {
		return this.codPais;
	}

	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}

	@Column(name = "nome_pais", nullable = false, length = 100)
	public String getNomePais() {
		return this.nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

}
