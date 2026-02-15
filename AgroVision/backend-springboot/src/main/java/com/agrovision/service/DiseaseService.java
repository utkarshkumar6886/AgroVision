package com.agrovision.service;

import com.agrovision.entity.Disease;
import com.agrovision.repository.DiseaseRepository;
import com.agrovision.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    // ADD DISEASE (ADMIN USE)
    public Disease addDisease(Disease disease) {
        return diseaseRepository.save(disease);
    }

    // GET ALL DISEASES
    public List<Disease> getAllDiseases() {
        return diseaseRepository.findAll();
    }

    // GET DISEASE BY ID
    public Disease getDiseaseById(Long id) {
        return diseaseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Disease not found with ID: " + id));
    }

    // UPDATE DISEASE
    public Disease updateDisease(Long id, Disease updatedDisease) {

        Disease existing = diseaseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Disease not found with ID: " + id));

        existing.setDiseaseName(updatedDisease.getDiseaseName());
        existing.setSymptoms(updatedDisease.getSymptoms());
        existing.setTreatment(updatedDisease.getTreatment());
        existing.setPrevention(updatedDisease.getPrevention());
        existing.setCropType(updatedDisease.getCropType());
        existing.setRiskLevel(updatedDisease.getRiskLevel());

        return diseaseRepository.save(existing);
    }

    // DELETE DISEASE
    public void deleteDisease(Long id) {

        Disease disease = diseaseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Disease not found with ID: " + id));

        diseaseRepository.delete(disease);
    }
}
