package com.hms.controller;

import com.hms.entity.MedicalHistory;
import com.hms.payload.MedicalHistoryDTO;
import com.hms.payload.PatientDTO;
import com.hms.service.MedicalHistoryService;
import com.hms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private PatientService patientService;
    private final MedicalHistoryService medicalHistoryService;

    @Autowired
    public PatientController(PatientService patientService, MedicalHistoryService medicalHistoryService) {
        this.patientService = patientService;
        this.medicalHistoryService = medicalHistoryService;
    }
    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO){
        PatientDTO createdPatient = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable(value = "id") Long id) {
        PatientDTO patient = patientService.getPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable(value = "id") Long id, @RequestBody PatientDTO patientDTO) {
        PatientDTO patientDTO1 = patientService.updatePatient(patientDTO, id);
        return new ResponseEntity<>(patientDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable(value = "id") Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient entity deleted successfully",HttpStatus.OK);
    }
}
