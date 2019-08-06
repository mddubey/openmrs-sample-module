package org.openmrs.module.sample.api.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.openmrs.module.sample.api.model.SamplePatient;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SamplePatientDaoTest {
    @Mock
    private SessionFactory sessionFactory;
    @Mock
    private Session session;

    private SamplePatientDao samplePatientDao;

    @Before
    public void setUp() {
        initMocks(this);
        samplePatientDao = new SamplePatientDao(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    @Test
    public void shouldSaveASamplePatient() {
        SamplePatient samplePatient = new SamplePatient(1, "name", 'G');
        when(session.save(samplePatient)).thenReturn(samplePatient);

        samplePatientDao.save(samplePatient);

        verify(session, times(1)).save(samplePatient);
    }

    @Test
    public void shouldFindASamplePatient() {
        SamplePatient samplePatient = new SamplePatient(1, "name", 'G');
        when(session.get(SamplePatient.class, 1)).thenReturn(samplePatient);

        SamplePatient findResult = samplePatientDao.find(1);

        assertEquals(samplePatient, findResult);
        verify(session, times(1)).get(SamplePatient.class, 1);
    }
}