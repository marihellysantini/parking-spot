package com.api.parkingspot.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingspot.model.ParkingSpot;
import com.api.parkingspot.repository.ParkingSpotRepository;

@Service
public class ParkingSportService {

	@Autowired
	public ParkingSpotRepository repository;

	@Transactional
	public ParkingSpot save(ParkingSpot parkingSpot) {
		return repository.save(parkingSpot);
	}

	public boolean existsByPlaca(String placa) {
		return repository.existsByPlaca(placa);
	}

	public boolean existsByVaga(String vaga) {
		return repository.existsByVaga(vaga);
	}

	public boolean existsByApartamentoAndBloco(String apartamento, String bloco) {
		return repository.existsByApartamentoAndBloco(apartamento, bloco);
	}

	public Page<ParkingSpot> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<ParkingSpot> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public void delete(ParkingSpot parkingSpot) {
		repository.delete(parkingSpot);
	}
}
