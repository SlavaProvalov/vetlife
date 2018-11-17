package com.source.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "anamnesis")
    private String anamnesis;

    @Column(name = "inspection")
    private String inspection;

    @Column(name = "additional")
    private String additional;

    @Column(name = "therapy")
    private String therapy;

    @Column(name = "recomendations")
    private String recomendations;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "research")
    private String research;

    @Column(name = "research_result")
    private Boolean researchResult;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "appointment", fetch = FetchType.LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private List<Prophylaxy> prophylaxies;

    @OneToOne(mappedBy = "appointment", fetch = FetchType.LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private RabiesTest rabiesTests;

    public Appointment() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    public String getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(String recomendations) {
        this.recomendations = recomendations;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public Boolean getResearchResult() {
        return researchResult;
    }

    public void setResearchResult(Boolean researchResult) {
        this.researchResult = researchResult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addProphylaxy(Prophylaxy prophylaxy) {
        if (prophylaxies == null) {
            prophylaxies = new ArrayList<>();
        }
        prophylaxies.add(prophylaxy);
    }

    public RabiesTest getRabiesTests() {
        return rabiesTests;
    }

    public void setRabiesTests(RabiesTest rabiesTests) {
        this.rabiesTests = rabiesTests;
    }
}
