package com.example.hospital.service;

import com.example.hospital.entity.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    Appointment getAppointment(Long id);
    List<Appointment> getAllAppointments();
    void deleteAppointment(Long id);
    void deleteAllAppointments();
    Appointment updateAppointment(Long id, Appointment appointment);
}
