package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.interfaces.Searchable;

public abstract class MedicalEntity implements Searchable {
    private int medicalEntityId;

    public MedicalEntity(int medicalEntityId) {
        this.medicalEntityId = medicalEntityId;
    }

    public int getMedicalEntityId() {
        return medicalEntityId;
    }

    public abstract void displayDetails();
}
