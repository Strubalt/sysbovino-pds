package com.sysbovino.entidades;
// Generated 07/10/2015 20:17:36 by Hibernate Tools 4.0.0

import java.util.Date;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

/**
 * Pessoa generated by hbm2java
 */
@Entity
@Table(name = "pessoa", catalog = "projetoSistemas")
public class Pessoa implements java.io.Serializable {

	private Integer codPessoa;
	private int codCidade;
	private String nomePessoa;
	private String endereco;
	private Date dataNascimento;
	private String email;

	public Pessoa() {
	}

	public Pessoa(int codCidade, String nomePessoa, String endereco, Date dataNascimento) {
		this.codCidade = codCidade;
		this.nomePessoa = nomePessoa;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public Pessoa(int codCidade, String nomePessoa, String endereco, Date dataNascimento, String email) {
		this.codCidade = codCidade;
		this.nomePessoa = nomePessoa;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cod_pessoa", unique = true, nullable = false)
	public Integer getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(Integer codPessoa) {
		this.codPessoa = codPessoa;
	}

	@Column(name = "cod_cidade", nullable = false)
	public int getCodCidade() {
		return this.codCidade;
	}

	public void setCodCidade(int codCidade) {
		this.codCidade = codCidade;
	}

	@Column(name = "nome_pessoa", nullable = false, length = 150)
	public String getNomePessoa() {
		return this.nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	@Column(name = "endereco", nullable = false, length = 150)
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false, length = 10)
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "email", length = 200)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
