package steps_homework4;


import pages_homework4.ChoosePolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps_homework4.BaseSteps.driver;

/**
 * Created by OWL on 23.01.2018.
 */
public class ChoosePolicySteps {

    @Step("Выбрана минимальная сумма")
    public void stepChooseMinSum() {
        new ChoosePolicyPage().minSum.click();
    }

    @Step("Нажата кнопка - Оформить")
    public void stepClickFormalizeButton() {
        new ChoosePolicyPage().formalizeButton.click();
    }
}
