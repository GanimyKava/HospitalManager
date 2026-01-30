package com.example.hospital.service.impl;

import com.example.hospital.entity.Patient;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient savePatient(Patient p ) {
		return patientRepository.save(p);
	}

	@Override
	public Patient getPatient(Long id) {
		return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
	}

	@Override
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}

	@Override
	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}

	@Override
	public void deleteAllPatients() {
		patientRepository.deleteAll();
	}

	@Override
	public Patient updatePatient(Long id, Patient newData) {
	    Patient existing = patientRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Patient not found"));

	    existing.setName(newData.getName());
	    existing.setAddress(newData.getAddress());
	    existing.setAge(newData.getAge());

	    return patientRepository.save(existing);
	}
}
