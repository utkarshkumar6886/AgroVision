package com.agrovision.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diseases")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diseaseId;

    private String diseaseName;
    private String symptoms;
    private String treatment;
    private String prevention;
    private String cropType;
    private String riskLevel;

    public Disease() {}

    public Disease(String diseaseName, String symptoms, String treatment,
                   String prevention, String cropType, String riskLevel) {
        this.diseaseName = diseaseName;
        this.symptoms = symptoms;
        this.treatment = treatment;
        this.prevention = prevention;
        this.cropType = cropType;
        this.riskLevel = riskLevel;
    }

    public Long getDiseaseId() { return diseaseId; }

    public String getDiseaseName() { return diseaseName; }
    public void setDiseaseName(String diseaseName) { this.diseaseName = diseaseName; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    public String getPrevention() { return prevention; }
    public void setPrevention(String prevention) { this.prevention = prevention; }

    public String getCropType() { return cropType; }
    public void setCropType(String cropType) { this.cropType = cropType; }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
}
