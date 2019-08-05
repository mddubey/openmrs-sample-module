package org.openmrs.module.sample.web.controller;

import org.openmrs.module.sample.api.model.SamplePatient;
import org.openmrs.module.sample.api.service.SamplePatientService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/samplepatient")
public class SamplePatientController extends BaseRestController {
    private SamplePatientService samplePatientService;

    @Autowired
    public SamplePatientController(SamplePatientService samplePatientService) {
        this.samplePatientService = samplePatientService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    @ResponseBody
    public ResponseEntity<String> save(@RequestBody SamplePatient samplePatient) {
        samplePatientService.save(samplePatient);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    @ResponseBody
    public ResponseEntity<SamplePatient> save(@RequestParam int id) {
        SamplePatient samplePatient = samplePatientService.find(id);
        return new ResponseEntity<>(samplePatient, HttpStatus.OK);
    }
}
