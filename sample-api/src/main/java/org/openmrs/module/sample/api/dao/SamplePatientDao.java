package org.openmrs.module.sample.api.dao;

import org.hibernate.SessionFactory;
import org.openmrs.module.sample.api.model.SamplePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SamplePatientDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(SamplePatient samplePatient) {
        sessionFactory.getCurrentSession().save(samplePatient);
    }

    public SamplePatient find(int id) {
        return (SamplePatient) sessionFactory.getCurrentSession().get(SamplePatient.class, id);
    }
}
