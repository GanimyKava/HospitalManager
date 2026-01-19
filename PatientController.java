package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientsServiceimpl;
import java.util.List;
@RestController
@RequestMapping ("Hospital/")

public class PatientController {

	@Autowired
	PatientsServiceimpl ps;
	
	@PostMapping ("patient")
	public String save(@RequestBody Patient p) {
		  ps.addpatient(p);
		  return "Patient Added";
	}
	
	@GetMapping ("patient/{id}")
	public Patient getpatient(@PathVariable int id) {
		return ps.getpatient(id);
		
	}
	@GetMapping ("patient")
	public List<Patient> getAllpatient(){
	return 	ps.getAllpatient();
		
	}
	
	@DeleteMapping ("patient/{id}")
	public String deletepatient(@PathVariable int id) {
		ps.deletePatient(id);
		return "student is deleted";
	}
	
	@DeleteMapping ("patient")
	public String deleteAll() {
	 	ps.deleteAll();
	 	return "All patients";
	}
	@PutMapping ("patient/{id}")
	public String updatepatient(@PathVariable int id , @RequestBody Patient p) {
		ps.updatePatient(id, p);
		return "patients updated";
	}
}
