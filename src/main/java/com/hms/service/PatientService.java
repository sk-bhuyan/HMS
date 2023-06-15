package com.hms.service;

import com.hms.entity.Patient;
import com.hms.payload.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);
    PatientDTO getPatientById(Long id);
    List<PatientDTO> getAllPatients();
    PatientDTO updatePatient(PatientDTO patientDTO, Long id);
    void deletePatient(Long id);
}
