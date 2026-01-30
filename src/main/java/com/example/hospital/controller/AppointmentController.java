package com.example.hospital.controller;

import com.example.hospital.entity.Appointment;
import com.example.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping
	public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
		return new ResponseEntity<>(appointmentService.saveAppointment(appointment), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
	    return ResponseEntity.ok(appointmentService.getAppointment(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Appointment>> getAllAppointments(){
		return ResponseEntity.ok(appointmentService.getAllAppointments());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointment(id);
		return ResponseEntity.ok("Appointment deleted successfully");
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllAppointments() {
		appointmentService.deleteAllAppointments();
		return ResponseEntity.ok("All appointments deleted successfully");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
	}
}
