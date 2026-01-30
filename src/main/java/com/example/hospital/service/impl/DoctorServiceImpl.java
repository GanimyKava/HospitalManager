package com.example.hospital.service.impl;

import com.example.hospital.entity.Doctor;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor saveDoctor(Doctor d) {
		return doctorRepository.save(d);
	}

	@Override
	public Doctor getDoctor(Long id) {
		return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	@Override
	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}

	@Override
	public void deleteAllDoctors() {
		doctorRepository.deleteAll();
	}

	@Override
	public Doctor updateDoctor(Long id , Doctor newData) {
		Doctor existingData = doctorRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Doctor not found"));
		existingData.setAge(newData.getAge());
		existingData.setName(newData.getName());
		existingData.setSpecialization(newData.getSpecialization());
		
		return doctorRepository.save(existingData);
	}
}
