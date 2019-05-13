package com.example.Versioning.WebserviceMIME.content.negotiation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVerionController {

    // 4) using media type MIME or accept

    @GetMapping(value = "/person/produces", produces = "application/my.company.app-v1+json")
    public PersonV1 getPersonProducesV1() {
        return new PersonV1("Mohit");
    }

    @GetMapping(value = "/person/produces", produces = "application/my.company.app-v2+json")
    public PersonV2 getPersonProducesV2() {
        return new PersonV2("Mohit", "Malhotra");
    }
}