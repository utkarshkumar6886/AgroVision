package com.agrovision.controller;

import com.agrovision.entity.Disease;
import com.agrovision.service.DiseaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    // ADD DISEASE
    @PostMapping("/add")
    public Disease addDisease(@RequestBody Disease disease) {
        return diseaseService.addDisease(disease);
    }

    // GET ALL DISEASES
    @GetMapping("/all")
    public List<Disease> getAllDiseases() {
        return diseaseService.getAllDiseases();
    }

    // GET DISEASE BY ID
    @GetMapping("/{id}")
    public Disease getDiseaseById(@PathVariable Long id) {
        return diseaseService.getDiseaseById(id);
    }

    // UPDATE DISEASE
    @PutMapping("/update/{id}")
    public Disease updateDisease(@PathVariable Long id,
                                 @RequestBody Disease disease) {
        return diseaseService.updateDisease(id, disease);
    }

    // DELETE DISEASE
    @DeleteMapping("/delete/{id}")
    public String deleteDisease(@PathVariable Long id) {
        diseaseService.deleteDisease(id);
        return "Disease deleted successfully";
    }
}
