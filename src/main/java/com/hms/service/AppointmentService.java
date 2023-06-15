package com.hms.service;

import com.hms.entity.Appointment;
import com.hms.payload.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO createAppointment(Long id,AppointmentDTO appointmentDTO);

    Appointment getAppointmentById(Long appointmentId);

    List<Appointment> getAllAppointments();

    void updateAppointment(Appointment appointment);

    void deleteAppointment(Long appointmentId);
}
