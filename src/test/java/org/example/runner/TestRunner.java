package org.example.runner;

import io.cucumber.testng.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
//        tags = "@Smoke3",
        features = "src/test/resources/features",
        glue = {"org.example.stepDefinition","org.example.hooks","org.example.base"},
        plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner extends AbstractTestNGCucumberTests{

//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() {
//        BddLibrary.quitDriver();
//    }
}
