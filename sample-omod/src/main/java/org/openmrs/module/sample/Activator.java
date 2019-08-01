package org.openmrs.module.sample;

import org.openmrs.module.BaseModuleActivator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator extends BaseModuleActivator {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void started() {
        log.info("Started the OpenMRS Sample module");
    }

    @Override
    public void stopped() {
        log.info("Started the OpenMRS Sample module");
    }
}
