import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
/**
 * Created by Administrator on 28.07.2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        plugin = {"pretty", "html:target/html/", "json:target/json/cucumber.json"})
public class  RunFeatures{
}
