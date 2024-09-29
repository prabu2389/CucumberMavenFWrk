package org.example.runner;

import io.cucumber.testng.*;
import org.example.base.BddLibrary;
import org.testng.annotations.AfterClass;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.stepDefinition","org.example.hooks","org.example.base"},
        plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner extends AbstractTestNGCucumberTests{

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        BddLibrary.quitDriver();
    }
}
