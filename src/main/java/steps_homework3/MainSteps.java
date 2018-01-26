package steps_homework3;

import pages_homework3.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by OWL on 23.01.2018.
 */
public class MainSteps extends BaseSteps {

    @Step("Выбран пункт меню - Застраховать себя и имущество")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage(driver).selectMainMenu(menuItem);
    }

    @Step("Выбран пункт меню - Страхование путешественников")
    public void setSelectSubMenu() {
        new MainPage(driver).selectSubMenu(driver);
    }


}
