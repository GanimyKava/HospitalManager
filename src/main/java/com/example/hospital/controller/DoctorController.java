package com.example.hospital.controller;

import com.example.hospital.entity.Doctor;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable Long id) {
		return ResponseEntity.ok(doctorService.getDoctor(id));
	}

	@GetMapping
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		return ResponseEntity.ok(doctorService.getAllDoctors());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
		return ResponseEntity.ok("Doctor deleted successfully");
	}

	@DeleteMapping
	public ResponseEntity<String> deleteAllDoctors() {
		doctorService.deleteAllDoctors();
		return ResponseEntity.ok("All doctors deleted successfully");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
		return ResponseEntity.ok(doctorService.updateDoctor(id, doctor));
	}
}
