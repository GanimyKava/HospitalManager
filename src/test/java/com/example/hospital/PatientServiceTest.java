package com.example.hospital.service;

import com.example.hospital.entity.Patient;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPatientSuccess() {
        Patient patient = new Patient(1L, "John Doe", "123 Main St", 30);
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        Patient found = patientService.getPatient(1L);

        assertNotNull(found);
        assertEquals("John Doe", found.getName());
        verify(patientRepository, times(1)).findById(1L);
    }

    @Test
    void testGetPatientNotFound() {
        when(patientRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> patientService.getPatient(1L));
    }
}
