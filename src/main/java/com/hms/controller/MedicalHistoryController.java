package com.hms.controller;

import com.hms.payload.MedicalHistoryDTO;
import com.hms.service.MedicalHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class MedicalHistoryController {

    private MedicalHistoryService medicalHistoryService;
    public MedicalHistoryController(MedicalHistoryService medicalHistoryService){
        this.medicalHistoryService=medicalHistoryService;
    }

    //Medical History endpoints
    // Endpoint to add a medical history for a patient
    @PostMapping("/patients/{id}/medical-history")
    public ResponseEntity<MedicalHistoryDTO> addMedicalHistory(@PathVariable(value = "id") Long id, @RequestBody MedicalHistoryDTO medicalHistoryDTO){
        MedicalHistoryDTO medicalHistoryDTO1 = medicalHistoryService.saveMedicalHistory(id, medicalHistoryDTO);
        return new ResponseEntity<>(medicalHistoryDTO1, HttpStatus.CREATED);
    }

    //get medical history

    //update medical history

    //delete medical history
}
