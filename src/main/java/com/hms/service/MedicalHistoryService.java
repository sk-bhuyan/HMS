package com.hms.service;

import com.hms.entity.MedicalHistory;
import com.hms.payload.MedicalHistoryDTO;

import java.util.List;

public interface MedicalHistoryService {
    MedicalHistoryDTO saveMedicalHistory(Long id,MedicalHistoryDTO medicalHistoryDTO);

    MedicalHistoryDTO getMedicalHistoryById(Long id);

    List<MedicalHistoryDTO> getAllMedicalHistories();

    MedicalHistoryDTO updateMedicalHistory(MedicalHistoryDTO medicalHistoryDTO, Long id);

    void deleteMedicalHistory(Long id);
}
