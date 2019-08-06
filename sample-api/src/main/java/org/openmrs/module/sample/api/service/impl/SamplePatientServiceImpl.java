package org.openmrs.module.sample.api.service.impl;

import org.openmrs.module.sample.api.dao.SamplePatientDao;
import org.openmrs.module.sample.api.model.SamplePatient;
import org.openmrs.module.sample.api.service.SamplePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SamplePatientServiceImpl implements SamplePatientService {
    private SamplePatientDao samplePatientDao;

    @Autowired
    public SamplePatientServiceImpl(SamplePatientDao samplePatientDao) {
        this.samplePatientDao = samplePatientDao;
    }

    @Override
    public void save(SamplePatient samplePatient) {
        samplePatientDao.save(samplePatient);
    }

    @Override
    public SamplePatient find(int id) {
        return samplePatientDao.find(id);
    }
}
