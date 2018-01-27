package steps_homework4;

import pages_homework4.MainPage;
import ru.yandex.qatools.allure.annotations.Step;


/**
 * Created by OWL on 23.01.2018.
 */
public class MainSteps {

    @Step("Выбран пункт меню - Застраховать себя и имущество")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Выбран пункт меню - Страхование путешественников")
    public void stepSelectSubMenu() {
        new MainPage().selectSubMenu();
    }


}
