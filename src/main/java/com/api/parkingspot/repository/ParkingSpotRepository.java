package com.api.parkingspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parkingspot.model.ParkingSpot;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

	boolean existsByPlaca(String placa);

	boolean existsByVaga(String vaga);

	boolean existsByApartamentoAndBloco(String apartamento, String bloco);
}
