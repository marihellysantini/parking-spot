package com.api.parkingspot.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARKING_SPOT")
public class ParkingSpot implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String vaga;
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private LocalDateTime dataRegistro;
	private String responsavel;
	private String apartamento;
	private String bloco;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(nullable = false, unique = true, length = 10)
	public String getVaga() {
		return vaga;
	}

	@Column(nullable = false, unique = true, length = 7)
	public String getPlaca() {
		return placa;
	}

	@Column(nullable = false, length = 70)
	public String getMarca() {
		return marca;
	}

	@Column(nullable = false, length = 70)
	public String getModelo() {
		return modelo;
	}

	@Column(nullable = false, length = 70)
	public String getCor() {
		return cor;
	}

	@Column(nullable = false)
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	@Column(nullable = false, length = 130)
	public String getResponsavel() {
		return responsavel;
	}

	@Column(nullable = false, length = 30)
	public String getApartamento() {
		return apartamento;
	}

	public String getBloco() {
		return bloco;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
}
