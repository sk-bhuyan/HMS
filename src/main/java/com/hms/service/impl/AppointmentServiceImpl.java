package com.hms.service.impl;

import com.hms.entity.Appointment;
import com.hms.entity.Patient;
import com.hms.payload.AppointmentDTO;
import com.hms.repository.AppointmentRepository;
import com.hms.repository.PatientRepository;
import com.hms.service.AppointmentService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;
    private ModelMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, ModelMapper mapper){
        this.appointmentRepository=appointmentRepository;
        this.patientRepository=patientRepository;
        this.mapper=mapper;
    }


    @Override
    public AppointmentDTO createAppointment(Long id, AppointmentDTO appointmentDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("patient not found with id: " + id));
        Appointment appointment=new Appointment();
        appointment.setDate(appointmentDTO.getDate());
        appointment.setTime(appointmentDTO.getTime());
        appointment.setDoctor(appointmentDTO.getDoctor());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setPatient(patient);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return mapToDto(savedAppointment);
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return null;
    }

    @Override
    public void updateAppointment(Appointment appointment) {

    }

    @Override
    public void deleteAppointment(Long appointmentId) {

    }

    //Convert entity to DTO
    private AppointmentDTO mapToDto(Appointment appointment) {
        return mapper.map(appointment,AppointmentDTO.class);
    }

    //Convert DTO to Entity
    private Appointment mapToEntity(AppointmentDTO appointmentDTO) {
        return mapper.map(appointmentDTO, Appointment.class);
    }
}
