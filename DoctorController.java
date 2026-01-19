package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorServiceimpl;

@RestController
@RequestMapping ("Hospital/")
public class DoctorController {

	
	@Autowired
	DoctorServiceimpl doctorServiceimpl;
	
	
	@PostMapping ("Doctor")
	public String saveDoctor(@RequestBody Doctor d) {
		doctorServiceimpl.addDoctor(d);
		return "doctor is saved";
	}
	@GetMapping ("Doctor/{id}")
	public Doctor getDoctor(@PathVariable int id) {
		return doctorServiceimpl.getDoctor(id);
		
	}
	@GetMapping ("Doctor")
	public List<Doctor> getAllDoctor(){
		return doctorServiceimpl.getAllDoctor();
	}
	
	@DeleteMapping ("Doctor/{id}")
	public String deleteDoctor(@PathVariable int id) {
		doctorServiceimpl.deleteDoctor(id);
		return "doctor is deleted";
	}
	@DeleteMapping ("Doctor")
	public String deleteAllDoctor() {
		doctorServiceimpl.deleteAllDoctor();
		return "all Doctor deleted";
	}
	
	@PutMapping ("Doctor/{id}")
	public Doctor updateDoctor(@PathVariable int id , @RequestBody Doctor d) {
		return doctorServiceimpl.updateDoctor(id, d);
		
	}
}
