package com.example.hospital.service;

import com.example.hospital.entity.Patient;
import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    Patient getPatient(Long id);
    List<Patient> getAllPatients();
    void deletePatient(Long id);
    void deleteAllPatients();
    Patient updatePatient(Long id, Patient patient);
}
