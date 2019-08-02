package org.openmrs.module.sample;

import org.openmrs.module.sample.api.service.SampleService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/sample/data")
public class SampleController extends BaseRestController {
    private SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    @ResponseBody
    public String getData(@RequestParam(defaultValue = "World", required = false) String name) {
        return sampleService.getData(name);
    }
}
