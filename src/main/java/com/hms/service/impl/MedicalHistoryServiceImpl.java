package com.hms.service.impl;

import com.hms.entity.MedicalHistory;
import com.hms.entity.Patient;
import com.hms.payload.MedicalHistoryDTO;
import com.hms.repository.MedicalHistoryRepository;
import com.hms.repository.PatientRepository;
import com.hms.service.MedicalHistoryService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    
    private MedicalHistoryRepository medicalHistoryRepository;
    private ModelMapper mapper;
    private PatientRepository patientRepository;

    public MedicalHistoryServiceImpl(MedicalHistoryRepository medicalHistoryRepository, ModelMapper modelMapper, PatientRepository patientRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.mapper=modelMapper;
        this.patientRepository=patientRepository;
    }

    @Override
    public MedicalHistoryDTO saveMedicalHistory(Long id,MedicalHistoryDTO medicalHistoryDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("patient not found with id:" + id));
        MedicalHistory medicalHistory=new MedicalHistory();
        medicalHistory.setDetails(medicalHistoryDTO.getDetails());
        medicalHistory.setDate(medicalHistoryDTO.getDate());
        medicalHistory.setPatient(patient);
        MedicalHistory savedMedicalHistory = medicalHistoryRepository.save(medicalHistory);
        return mapToDto(savedMedicalHistory);
    }



    @Override
    public MedicalHistoryDTO getMedicalHistoryById(Long id) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
        return mapToDto(medicalHistory);
    }

    @Override
    public List<MedicalHistoryDTO> getAllMedicalHistories() {
        List<MedicalHistory> allMedicalHistories = medicalHistoryRepository.findAll();
        List<MedicalHistoryDTO> medicalHistoryDto = allMedicalHistories.stream().map(medicalHistory -> mapToDto(medicalHistory)).collect(Collectors.toList());
        return medicalHistoryDto;
    }

    @Override
    public MedicalHistoryDTO updateMedicalHistory(MedicalHistoryDTO medicalHistoryDTO, Long id) {
        MedicalHistory medicalHistory1 = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
        medicalHistory1.setDate(medicalHistoryDTO.getDate());
        medicalHistory1.setDetails(medicalHistoryDTO.getDetails());
        MedicalHistory savedMedicalHistory = medicalHistoryRepository.save(medicalHistory1);
        return mapToDto(savedMedicalHistory);
    }

    @Override
    public void deleteMedicalHistory(Long id) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
        medicalHistoryRepository.delete(medicalHistory);
    }

    private MedicalHistoryDTO mapToDto(MedicalHistory medicalHistory) {
        return mapper.map(medicalHistory,MedicalHistoryDTO.class);
    }

    private MedicalHistory mapToEntity(MedicalHistoryDTO medicalHistoryDTO) {
        return mapper.map(medicalHistoryDTO,MedicalHistory.class);
    }
}
