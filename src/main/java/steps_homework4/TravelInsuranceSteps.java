package steps_homework4;


import pages_homework4.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertEquals;

/**
 * Created by OWL on 23.01.2018.
 */
public class TravelInsuranceSteps {

    @Step("Выполнена проверка наличия на странице заголовка - Страхование путешественников")
    public void stepCheckTitle(String expectedTitle) {
        String actualTitle = new TravelInsurancePage().title.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), expectedTitle, actualTitle);
    }

    @Step("Выполнено нажатие на кнопку - Оформить Онлайн")
    public void stepSendButton() {
        new TravelInsurancePage().sendButton.click();
    }
}
