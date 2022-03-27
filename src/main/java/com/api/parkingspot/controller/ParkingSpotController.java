package com.api.parkingspot.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingspot.dto.ParkingSpotDTO;
import com.api.parkingspot.model.ParkingSpot;
import com.api.parkingspot.service.ParkingSportService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

	@Autowired
	ParkingSportService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid ParkingSpotDTO dto) {

		if (service.existsByPlaca(dto.getPlaca())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("A placa já está em uso");
		}
		if (service.existsByVaga(dto.getVaga())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("A vaga já está em uso");
		}
		if (service.existsByApartamentoAndBloco(dto.getApartamento(), dto.getBloco())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Já existe uma vaga registrada para esse apartamento e bloco");
		}

		ParkingSpot model = new ParkingSpot();
		BeanUtils.copyProperties(dto, model);
		model.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(model));
	}

	@GetMapping
	public ResponseEntity<Page<ParkingSpot>> getAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOne(@PathVariable(value = "id") Long id) {
		Optional<ParkingSpot> parkingSpot = service.findById(id);
		if (!parkingSpot.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A alocação da vaga não foi encontrada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpot.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOne(@PathVariable(value = "id") Long id,
			@RequestBody @Valid ParkingSpotDTO dto) {
		Optional<ParkingSpot> parkingSpot = service.findById(id);
		if (!parkingSpot.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A alocação da vaga não foi encontrada");
		}
		service.delete(parkingSpot.get());
		return ResponseEntity.status(HttpStatus.OK).body("Alocação removida com sucesso");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid ParkingSpotDTO dto) {
		Optional<ParkingSpot> parkingSpot = service.findById(id);
		if (!parkingSpot.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A alocação da vaga não foi encontrada");
		}
		ParkingSpot model = new ParkingSpot();
		BeanUtils.copyProperties(dto, model);
		model.setDataRegistro(parkingSpot.get().getDataRegistro());
		model.setId(parkingSpot.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(service.save(model));
	}

}
