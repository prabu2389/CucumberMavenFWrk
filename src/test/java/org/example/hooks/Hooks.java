package org.example.hooks;

import io.cucumber.java.*;
import org.example.base.BddLibrary;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    private static final String SCREENSHOT_FORMAT = System.getProperty("screenshot.format", "png");
    private static final String SCREENSHOT_MIME_TYPE = "image/" + SCREENSHOT_FORMAT;
    @Before
    public void setUp() {
        BddLibrary.getDriver(); // This will initialize the driver if it's not already initialized
    }

    @After(order = 0)
    public void tearDown() {
        BddLibrary.quitDriver();
    }

    @After(order = 1)
    public void failScenario(Scenario scenario) {
        if (scenario.isFailed()){
            try {
                String screenshotName = scenario.getName()
                                .replaceAll(" ","_")
                        +"_"+System.currentTimeMillis();
                byte [] sourcePath = ((TakesScreenshot)BddLibrary.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(sourcePath, SCREENSHOT_MIME_TYPE, screenshotName);
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: "+e.getMessage());
            }

        }
    }

}
