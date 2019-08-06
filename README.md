## OpenMRS-Sample-Omod
A sample omod for openmrs with step wise commits for adding a functionality.

#### Deploying the omod
- Run `mvn clean install`.
- Find the generated omod file in `sample-omod/target/sample-omod-1.0-SNAPSHOT.omod`. Put this in openmrs modules directory and restart openmrs.
- By default it will just runs Unit Tests, to include integration tests run `mvn clean install -PIT`. 

#### Usage
Once the server is up we can execute below commands from out terminal

```
#Create a new sample patient
curl -X POST http://localhost:8080/openmrs/ws/rest/v1/samplepatient -H 'Authorization: Basic YWRtaW46QWRtaW4xMjM=' -H 'Content-Type: application/json' -d '{ "name": "John","gender": "M"}'

#Find patient with ID `1`
curl -X GET http://localhost:8080/openmrs/ws/rest/v1/samplepatient?id=1 -H 'Authorization: Basic YWRtaW46QWRtaW4xMjM='
```

