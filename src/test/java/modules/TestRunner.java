package modules;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/json/results.json"},
        features = {"src/test/java/features/"},
        glue = { "step_definitions",},
        tags = "@log01",
        name = {""}
)

public class TestRunner {

}

