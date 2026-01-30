package com.example.hospital.service.impl;

import com.example.hospital.entity.Appointment;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Override
	public Appointment saveAppointment(Appointment a) {
		return appointmentRepository.save(a);
	}
	
	@Override
	public Appointment getAppointment(Long id) {
	    return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
	}
	
	@Override
	public List<Appointment> getAllAppointments (){
		return appointmentRepository.findAll();
	}
	
    @Override
    public void deleteAppointment (Long id) {
    	appointmentRepository.deleteById(id);
    }

    @Override
    public void deleteAllAppointments() {
    	appointmentRepository.deleteAll();
    }

    @Override
    public Appointment updateAppointment(Long id , Appointment newData ) {
    	Appointment existingData = appointmentRepository.findById(id)
    			.orElseThrow(()-> new RuntimeException("Appointment Not found"));
    	
    	existingData.setAppointmentDate(newData.getAppointmentDate());
    	existingData.setDoctorId(newData.getDoctorId());
    	existingData.setPatientId(newData.getPatientId());
    	
    	return appointmentRepository.save(existingData);
    }
}
