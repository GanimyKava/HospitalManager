package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Patient;
import com.example.demo.repo.Patientrepo;
import java.util.List;

@Service
public class PatientsServiceimpl {
	
	@Autowired
	Patientrepo prepo;
	
	public void addpatient(Patient p ) {
		prepo.save(p);
	}
	public Patient getpatient(int id) {
		return prepo.findById(id).get();
		
	}
	public List<Patient> getAllpatient(){
		return prepo.findAll();
		
	}
	public  void deletePatient(int id) {
		prepo.deleteById(id);
	}
	public void deleteAll() {
		prepo.deleteAll();
	}

	public Patient updatePatient(int id, Patient newData) {
	    Patient existing = prepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Patient not found"));

	   
	    existing.setName(newData.getName());
	    existing.setAddress(newData.getAddress());
	    existing.setAge(newData.getAge());

	    return prepo.save(existing);
	}

	
}
