package Runners;
        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;
/**
 * Unit test for simple App.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/json/results.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber"},
//        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = {"src/test/resources/features/"},
        glue = { "step_definitions",},
        tags = "@End2EndSearchProduct"
        /*name = {""}*/

)

public class TestRunner extends BaseRunner {
}







