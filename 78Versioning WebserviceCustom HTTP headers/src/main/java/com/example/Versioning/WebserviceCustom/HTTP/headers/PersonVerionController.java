package com.example.Versioning.WebserviceCustom.HTTP.headers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVerionController {

    // 3) Header versioning

    @GetMapping(value = "/person/header", headers = "MY-API-VERSION=1")
    public PersonV1 getPersonHeaderV1() {
        return new PersonV1("Mohit");
    }

    @GetMapping(value = "/person/header", headers = "MY-API-VERSION=2")
    public PersonV2 getPersonHeaderV2() {
        return new PersonV2("Mohit", "Malhotra");
    }
}