package steps_homework3;

import pages_homework2.ChoosePolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps_homework3.BaseSteps.driver;

/**
 * Created by OWL on 23.01.2018.
 */
public class ChoosePolicySteps {

    @Step("Выбрана минимальная сумма")
    public void stepChooseMinSum() {
        new ChoosePolicyPage(driver).minSum.click();
    }

    @Step("Нажата кнопка - Оформить")
    public void stepClickFormalizeButton() {
        new ChoosePolicyPage(driver).formalizeButton.click();
    }
}
