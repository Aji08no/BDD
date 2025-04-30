package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


//@RunWith(Cucumber.class)
//C:\Users\Ajith\IdeaProjects\BDD\
@CucumberOptions(
        features = "src\\test\\java\\Features\\Login.feature",
        glue = "StepDefinition",
        dryRun = false,
        monochrome = true,
        plugin = {
                "pretty","html:target/cucumber-reports.html",
//                 "json:target/cucumber.json"
        }

)
public class TestRunner extends AbstractTestNGCucumberTests{
}
