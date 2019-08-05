package org.openmrs.module.sample.api.service;

import org.openmrs.module.sample.api.model.SamplePatient;
import org.springframework.transaction.annotation.Transactional;


public interface SamplePatientService {
    @Transactional
    void save(SamplePatient samplePatient);

    SamplePatient find(int id);
}
