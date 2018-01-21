package Homework2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ChoosePolicyPage;
import pages.MainPage;
import pages.RegistrationPage;
import pages.TravelInsurancePage;

import java.util.ArrayList;

/**
 * Created by OWL on 21.01.2018.
 */
public class MyRefactoringTest extends BaseTest {
    @Test
    public void newInsuranceTest() {
        //Перейти в меню страхование путешественников
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Застраховать");
        //mainPage.selectSubMenu("Страхование путешественников");
        MainPage subMenu = new MainPage(driver);
        subMenu.selectSubMenu(driver);

        //Проверить заголовок
        TravelInsurancePage getTitle = new TravelInsurancePage(driver);
        getTitle.title.getText();
        Assert.assertEquals("Отсутствует заголовок Страхование путешественников", "Страхование путешественников", getTitle.title.getText());
        //Нажать на кнопку Оформить
        new TravelInsurancePage(driver).sendButton.click();
        //Переключаемся на страницу
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //Выбираем минимальную сумму и нажимаем кнопку Оформить
        new ChoosePolicyPage(driver).minSum.click();
        new ChoosePolicyPage(driver).formalizeButton.click();
        //Заполняем форму
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.filledData("Фамилия застрахованного", "IVANOV");
        registrationPage.filledData("Имя застрахованного", "LEV");
        registrationPage.filledData("Дата рождения застрахованного", "01012011");
        registrationPage.filledData("Фамилия страхователя", "Иванова");
        registrationPage.filledData("Имя страхователя", "Елена");
        registrationPage.filledData("Отчество страхователя", "Петровна");
        registrationPage.filledData("Дата рождения страхователя", "02021984");
        registrationPage.filledData("Пол страхователя", "");
        registrationPage.filledData("Серия паспорта", "1234");
        registrationPage.filledData("Номер паспорта", "567890");
        registrationPage.filledData("Дата выдачи паспорта", "12022010");
        registrationPage.filledData("Кем выдан", "Отделением ОВД по г. Москва");
        //Проверяем введенные поля
        RegistrationPage checkField = new RegistrationPage(driver);
        checkField.checkField("Фамилия застрахованного");
        checkField.checkField("Имя застрахованного");
        checkField.checkField("Дата рождения застрахованного");
        checkField.checkField("Фамилия страхователя");
        checkField.checkField("Имя страхователя");
        checkField.checkField("Отчество страхователя");
        checkField.checkField("Дата рождения страхователя");
        checkField.checkField("Серия паспорта");
        checkField.checkField("Номер паспорта");
        checkField.checkField("Дата выдачи паспорта");
        checkField.checkField("Кем выдан");
        //Нажимаем на кнопку продолжить
        RegistrationPage clickButtonNext = new RegistrationPage(driver);
        clickButtonNext.clickButton();
        //Проверить сообщение о ошибке
        clickButtonNext.checkMassegeError();
    }
}
