package com.example.steps;

import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void envSetUp(){
        String environment = System.getenv("ENV");
        String operatingSystem = System.getenv("OS");

        System.out.println("Running tests on " + environment + " environment.");
        System.out.println("Operating System - " + operatingSystem);
    }

    public final String testSetUp() {
        return System.getenv("TEST");
    }
}
