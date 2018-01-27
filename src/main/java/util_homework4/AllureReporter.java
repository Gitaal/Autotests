package util_homework4;


import gherkin.formatter.model.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.events.MakeAttachmentEvent;
import steps_homework4.BaseSteps;

import static steps_homework4.BaseSteps.getDriver;

/**
 * Created by OWL on 25.01.2018.
 */
public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

   @Override
    public void result(Result result) {
        if (result.getStatus().equals("failed")) {
            takeScreenshot();
        }
        super.result(result);
    }


    @Attachment(type = "image/png", value = "Скриншот при ошибке")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
