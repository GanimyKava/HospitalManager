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

import com.example.demo.entity.Appoinment;
import com.example.demo.service.AppoinmentServiceimpl;

@RestController
@RequestMapping ("Hospital/")
public class AppoinmentContoller {
	
	@Autowired
	AppoinmentServiceimpl appoinmentServiceimpl;
	
	
	@PostMapping ("Appoinment")
	public String saveAppoinment(@RequestBody Appoinment a) {
		appoinmentServiceimpl.addAppoinment(a);
		return "Appoinment saved";
	}
	
	@GetMapping ("Appoinment/{id}")
	public Appoinment getAppoinment(@PathVariable int id) {
	return 	appoinmentServiceimpl.getAppoinment(id);
	}
	
	@GetMapping ("Appoinment")
	public List<Appoinment> getAllAppoinment(){
		return appoinmentServiceimpl.getAllAppoinment();
		
	}
	
	@DeleteMapping ("Appoinment/{id}")
	public String deleteAppoinment(@PathVariable int id) {
		appoinmentServiceimpl.deleteAppoinment(id);
		return " Appoinment is deleted";
	}
	
	@DeleteMapping ("Appoinment")
	public String deleteAllAppoinment() {
		appoinmentServiceimpl.deleteAllAppoinment();
		return "All Appoinment is deleted";
	}
	
	@PutMapping ("Appoinment/{id}")
	public Appoinment updateAppoinment(@PathVariable int id, @RequestBody Appoinment a) {
		return appoinmentServiceimpl.updateAppoinment(id, a);
	}

	
}
