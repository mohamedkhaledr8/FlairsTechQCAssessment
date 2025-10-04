package CucumberTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = {
                "src/test/resources/features/gui",
                //"src/test/resources/features/api" //for binding apis feature file
        },
        glue = {
               // "tests/api", //for running apis tests
                "tests/gui",
                "tests/CommonSteps",

        },
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
     //   plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
@Listeners({listeners.CucumberListener.class})
public class CucumberTests extends AbstractTestNGCucumberTests {
}
