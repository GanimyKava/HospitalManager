package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Patient;


public interface Patientrepo extends JpaRepository<Patient, Integer>{

}
