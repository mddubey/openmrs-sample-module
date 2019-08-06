package org.openmrs.module.sample.api.model;

import org.openmrs.BaseOpenmrsObject;

public class SamplePatient extends BaseOpenmrsObject {
    private Integer id;
    private String name;
    private Character gender;

    public SamplePatient() {
    }

    public SamplePatient(Integer id, String name, Character gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }
}
