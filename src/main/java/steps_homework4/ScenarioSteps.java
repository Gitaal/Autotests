package steps_homework4;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by OWL on 27.01.2018.
 */
public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    ChoosePolicySteps choosePolicySteps = new ChoosePolicySteps();
    RegistrationSteps registrationSteps = new RegistrationSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMainMenuItem(String menuName) {
        mainSteps.stepSelectMainMenu(menuName);
    }

    @Then("^выбран пункт меню Страхование путешественников$")
    public void selectSubMenuItem() {
        mainSteps.stepSelectSubMenu();
    }

    @When("^выполнена проверка заголовка - \"(.+)\"$")
    public void checkTitle(String title) {
        travelInsuranceSteps.stepCheckTitle(title);
    }

    @Then("^выполнено нажатие на кнопку - Оформить Онлайн$")
    public void clickSendButton() {
        travelInsuranceSteps.stepSendButton();
    }


    @When("^выбрана минимальная сумма$")
    public void checkMinSum() {
        choosePolicySteps.stepChooseMinSum();
    }

    @Then("^выполнено нажатие на кнопку - Оформить$")
    public void clickFormalizeButton() {
        choosePolicySteps.stepClickFormalizeButton();
    }

    @When("^заполняются поля:$")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> registrationSteps.stepFillField(key, value));
    }

    @Then("^значения полей равны:$")
    public void checkFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (field, value) -> registrationSteps.stepCheckFillField(field, value)
        );
    }

    @When("^выполнено нажатие на кнопку - Продолжить$")
    public void clickNext() {
        registrationSteps.stepClickButtonNextReg();
    }

    @Then("^выполнена проверка ошибочного сообщения - \"(.+)\"$")
    public void checkMassage(String massageErr) {
        registrationSteps.stepCheckMassegeError(massageErr);
    }

}
