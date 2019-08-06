package org.openmrs.module.sample.api.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.openmrs.module.sample.api.dao.SamplePatientDao;
import org.openmrs.module.sample.api.model.SamplePatient;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SamplePatientServiceImplTest {
    @Mock
    private SamplePatientDao samplePatientDao;

    private SamplePatientServiceImpl samplePatientService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        this.samplePatientService = new SamplePatientServiceImpl(samplePatientDao);
    }

    @Test
    public void shouldSaveASamplePatient() {
        SamplePatient samplePatient = new SamplePatient(1, "name", 'G');
        doNothing().when(samplePatientDao).save(samplePatient);

        samplePatientService.save(samplePatient);

        verify(samplePatientDao, times(1)).save(samplePatient);
    }

    @Test
    public void shouldFindASamplePatient() {
        SamplePatient samplePatient = new SamplePatient(1, "name", 'G');
        when(samplePatientDao.find(1)).thenReturn(samplePatient);

        SamplePatient findResult = samplePatientDao.find(1);

        assertEquals(samplePatient, findResult);
        verify(samplePatientDao, times(1)).find(1);
    }
}