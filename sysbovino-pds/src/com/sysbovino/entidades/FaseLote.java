package com.sysbovino.entidades;
// Generated 07/10/2015 20:17:36 by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Table;  
import javax.persistence.Entity;  

/**
 * FaseLote generated by hbm2java
 */
@Entity
@Table(name = "fase_lote", catalog = "projetoSistemas")
public class FaseLote implements java.io.Serializable {

	private FaseLoteId id;
	private Date dataInicio;
	private Date dataFim;

	public FaseLote() {
	}

	public FaseLote(FaseLoteId id) {
		this.id = id;
	}

	public FaseLote(FaseLoteId id, Date dataInicio, Date dataFim) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "codLote", column = @Column(name = "cod_lote", nullable = false) ),
			@AttributeOverride(name = "codItem", column = @Column(name = "cod_item", nullable = false) ),
			@AttributeOverride(name = "codFase", column = @Column(name = "cod_fase", nullable = false) ) })
	public FaseLoteId getId() {
		return this.id;
	}

	public void setId(FaseLoteId id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio", length = 10)
	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_fim", length = 10)
	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
