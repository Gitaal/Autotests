package util_homework3;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import steps_homework3.BaseSteps;

/**
 * Created by OWL on 25.01.2018.
 */
public class AllureListener extends ru.yandex.qatools.allure.junit.AllureRunListener {
    @Override
    public void testFailure(Failure failure){
          takeScreenshot();
          super.testFailure(failure);
    }

    @Attachment(type = "image/png", value = "Скриншот при ошибке")
    public byte[] takeScreenshot (){
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
