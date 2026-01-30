package com.example.hospital.controller;

import com.example.hospital.entity.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
		return ResponseEntity.ok(patientService.getPatient(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatients(){
		return ResponseEntity.ok(patientService.getAllPatients());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
		return ResponseEntity.ok("Patient deleted successfully");
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllPatients() {
		patientService.deleteAllPatients();
		return ResponseEntity.ok("All patients deleted successfully");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		return ResponseEntity.ok(patientService.updatePatient(id, patient));
	}
}
