package steps_homework4;

import org.openqa.selenium.WebElement;

import pages_homework4.RegistrationPage;
import ru.yandex.qatools.allure.annotations.Step;


import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by OWL on 23.01.2018.
 */
public class RegistrationSteps{

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String fieldName, String value) {
        new RegistrationPage().filledData(fieldName, value);
    }


    @Step("поле {0} заполнено значением {1}")
    public void stepCheckFillField(String field, String value) {

        String actual = new RegistrationPage().getCheckField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("Пол заполнен верно")
    public void stepCheckMale(WebElement female){
        new RegistrationPage().female.click();
        assertTrue("Неверно заполнен пол", female.isSelected());
    }


    @Step("Выполнено нажатие на кнопку - Продолжить")
    public void stepClickButtonNextReg() {
        new RegistrationPage().nextReg.click();
    }

    @Step("Выполнена проверка наличия ошибки на странице")
    public void stepCheckMassegeError(String expecteErrorMassage) {
        String actualErrorMassage = new RegistrationPage().errorMassage.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualErrorMassage, expecteErrorMassage), expecteErrorMassage, actualErrorMassage);
    }

}
