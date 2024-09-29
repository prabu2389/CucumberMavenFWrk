package org.example.hooks;

import io.cucumber.java.*;
import org.example.base.BddLibrary;

public class Hooks {
    @Before
    public void setUp() {
        BddLibrary.getDriver(); // This will initialize the driver if it's not already initialized
    }

    @After
    public void tearDown() {
        BddLibrary.quitDriver();
    }
}
