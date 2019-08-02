package org.openmrs.module.sample.api.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {
    public String getData(String name) {
        return "Hello " + name;
    }
}
