package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repo.Doctorrepo;

@Service
public class DoctorServiceimpl {

	@Autowired
	Doctorrepo doctorrepo;

	public void addDoctor(Doctor d) {
		doctorrepo.save(d);

	}

	public Doctor getDoctor(int id) {
		return doctorrepo.findById(id).get();
	}

	public List<Doctor> getAllDoctor() {
		return doctorrepo.findAll();
	}
	
	public void deleteDoctor(int id) {
		doctorrepo.deleteById(id);
	}
	public void deleteAllDoctor() {
		doctorrepo.deleteAll();
	}
	public Doctor updateDoctor(int id , Doctor newData) {
		
		Doctor existingdata= doctorrepo.findById(id)
				.orElseThrow(()-> new RuntimeException("doctor not found"));
		existingdata.setAge(newData.getAge());
		existingdata.setName(newData.getName());
		existingdata.setSpecfication(newData.getSpecfication());
		
		return doctorrepo.save(existingdata);
		
	}

}
