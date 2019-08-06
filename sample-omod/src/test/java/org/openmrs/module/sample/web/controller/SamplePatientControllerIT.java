package org.openmrs.module.sample.web.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openmrs.module.sample.api.model.SamplePatient;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:TestingApplicationContext.xml"})
public class SamplePatientControllerIT extends BaseModuleWebContextSensitiveTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        executeDataSet("samplePatientDataset.xml");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void shouldFindAmExistingSamplePatient() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/rest/v1/samplepatient")
                        .param("id", "1"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        SamplePatient existingPatient = new ObjectMapper().readValue(content, SamplePatient.class);
        assertEquals("First Patient", existingPatient.getName());
        assertEquals(new Character('M'), existingPatient.getGender());
    }

    @Test
    public void shouldSaveANewSamplePatient() throws Exception {
        SamplePatient samplePatient = new SamplePatient(null, "Ms. Ray", 'F');
        byte[] body = new ObjectMapper().writeValueAsBytes(samplePatient);

        MvcResult result = mockMvc.perform(
                post("/rest/v1/samplepatient")
                        .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isCreated())
                .andReturn();
        assertEquals("Created", result.getResponse().getContentAsString());
    }
}