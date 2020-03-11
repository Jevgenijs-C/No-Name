package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/resources/features/Login.feature",
                    "src/test/resources/features/UserStory12.feature" },
            plugin = {"pretty", "html:cucumber-report/html-report",
                    "junit:cucumber-report/junit-report.xml",
                    "json:cucumber-report/json-report.json"},
            tags = {/*"@Login", "@UserStory12"*/},
            glue = {"stepDefinitions"}
    )
    public class Runner_UserStory12 {


}
