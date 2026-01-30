package com.example.hospital.service;

import com.example.hospital.entity.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    Doctor getDoctor(Long id);
    List<Doctor> getAllDoctors();
    void deleteDoctor(Long id);
    void deleteAllDoctors();
    Doctor updateDoctor(Long id, Doctor doctor);
}
