package runners;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "features",
    plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"},
    monochrome = true
)
public class TestRunner {
	
	@AfterClass
    public static void setup() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = Arrays.asList("target/cucumber.json");
        String buildNumber = "1";
        String projectName = "cucumber-project";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "release/1.0");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }


}
