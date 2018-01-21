package Homework2;

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
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Застраховать");
        mainPage.selectSubMenu("Страхование путешественников");

        new TravelInsurancePage(driver).sendButton.click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        new ChoosePolicyPage(driver).minSum.click();
        new ChoosePolicyPage(driver).formalizeButton.click();


        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.filledData("Фамилия застрахованного","IVANOV");
        registrationPage.filledData("Имя застрахованного","LEV");
        registrationPage.filledData("Дата рождения застрахованного","01012011");
        registrationPage.filledData("Фамилия страхователя","Иванова");
        registrationPage.filledData("Имя страхователя","Елена");
        registrationPage.filledData("Отчество страхователя","Петровна");
        registrationPage.filledData("Дата рождения страхователя","02021984");
        registrationPage.filledData("Пол страхователя","");
        registrationPage.filledData("Серия паспорта","1234");
        registrationPage.filledData("Номер паспорта","567890");
        registrationPage.filledData("Дата выдачи паспорта","12022010");
        registrationPage.filledData("Кем выдан","Отделением ОВД по г. Москва");

        RegistrationPage clickButtonNext = new RegistrationPage(driver);
        clickButtonNext.clickButton();
}
}
