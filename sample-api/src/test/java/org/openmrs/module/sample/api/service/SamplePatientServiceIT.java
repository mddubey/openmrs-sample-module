package org.openmrs.module.sample.api.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.module.sample.api.model.SamplePatient;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SamplePatientServiceIT extends BaseModuleContextSensitiveTest {
    @Autowired
    private SamplePatientService samplePatientService;

    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        executeDataSet("samplePatientDataset.xml");
    }

    @Test
    public void shouldFetchAnExistingSamplePatient() {
        SamplePatient samplePatient = samplePatientService.find(1);

        assertEquals("First Patient", samplePatient.getName());
        assertEquals(new Character('M'), samplePatient.getGender());
    }

    @Test
    public void shouldSaveANewSamplePatient() {
        SamplePatient samplePatient = new SamplePatient(null, "Ms. Ray", 'F');

        samplePatientService.save(samplePatient);

        Query query = sessionFactory.getCurrentSession().createQuery("from SamplePatient");
        List list = query.list();
        assertEquals(2, list.size());
        Object o = list.get(1);
        assertTrue(o instanceof SamplePatient);
        SamplePatient savedPatient = (SamplePatient) o;
        assertEquals("Ms. Ray", savedPatient.getName());
        assertEquals(new Character('F'), samplePatient.getGender());
    }
}