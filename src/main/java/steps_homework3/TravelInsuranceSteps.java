package steps_homework3;

import pages_homework2.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.*;

/**
 * Created by OWL on 23.01.2018.
 */
public class TravelInsuranceSteps extends BaseSteps {

    @Step("Выполнена проверка наличия на странице заголовка - Страхование путешественников")
    public void stepCheckTitle(String expectedTitle) {
        String actualTitle = new TravelInsurancePage(driver).title.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), expectedTitle, actualTitle);
    }

    @Step("Выполнено нажатие на кнопку - Оформить Онлайн")
    public void stepSendButton() {
        new TravelInsurancePage(driver).sendButton.click();
    }
}
