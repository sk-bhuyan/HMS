package com.hms.service.impl;

import com.hms.entity.Patient;
import com.hms.payload.PatientDTO;
import com.hms.repository.PatientRepository;
import com.hms.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private ModelMapper mapper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.mapper=modelMapper;
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient=mapToEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        PatientDTO patientDTO1=mapToDto(savedPatient);
        return patientDTO1;
    }


    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
        return mapToDto(patient);
    }


    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDTO> collect = patients.stream().map(patient -> mapToDto(patient)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public PatientDTO updatePatient(PatientDTO patientDTO, Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
        patient.setName(patientDTO.getName());
        patient.setGender(patientDTO.getGender());
        patient.setAge(patientDTO.getAge());
        patient.setContactInformation(patientDTO.getContactInformation());

        Patient savedPatient = patientRepository.save(patient);
        return mapToDto(savedPatient);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
        patientRepository.delete(patient);
    }

    private Patient mapToEntity(PatientDTO patientDTO) {
        Patient patient = mapper.map(patientDTO, Patient.class);
        return patient;
    }

    private PatientDTO mapToDto(Patient patient) {
        PatientDTO patientDTO = mapper.map(patient, PatientDTO.class);
        return patientDTO;
    }
}
