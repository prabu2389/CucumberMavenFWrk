package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/java/features",
        glue = {"utilities","stepDefinition"},
        plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner {

}
