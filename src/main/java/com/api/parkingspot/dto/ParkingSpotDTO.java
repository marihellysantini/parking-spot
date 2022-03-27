package com.api.parkingspot.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDTO {

	private String vaga;
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private String responsavel;
	private String apartamento;
	private String bloco;

	@NotBlank
	public String getVaga() {
		return vaga;
	}

	@NotBlank
	@Size(max = 7)
	public String getPlaca() {
		return placa;
	}

	@NotBlank
	public String getMarca() {
		return marca;
	}

	@NotBlank
	public String getModelo() {
		return modelo;
	}

	@NotBlank
	public String getCor() {
		return cor;
	}

	@NotBlank
	public String getResponsavel() {
		return responsavel;
	}

	@NotBlank
	public String getApartamento() {
		return apartamento;
	}

	@NotBlank
	public String getBloco() {
		return bloco;
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
