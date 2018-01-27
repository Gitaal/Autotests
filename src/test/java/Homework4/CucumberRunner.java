package Homework4;


        import cucumber.api.CucumberOptions;
        import cucumber.api.junit.Cucumber;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"steps_homework4"},//передается, что лежит в степах
        plugin = {
                "util_homework4.AllureReporter", //в каком формате формируется отчет
        }
)
public class CucumberRunner {

}