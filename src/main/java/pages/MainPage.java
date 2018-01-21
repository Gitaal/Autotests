package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by OWL on 21.01.2018.
 */
public class MainPage {
    //*[contains(text(),'Застраховать')]
    @FindBy(xpath = "//ul[contains(@class,'alt-menu-mid')]/li[5]/a")
    WebElement mainMenuItem;

    @FindBy(xpath = "//li[5]//div[contains(@class,'list__item_level_1')]")
    WebElement subMenuItem;

    //Выполняем инициализацию элементов
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    // Застраховать

    public void selectMainMenu(String menuItem) {
        mainMenuItem.findElement(By.xpath(".//span[@class='multiline']/*[contains(text(),'" + menuItem + "')]")).click();
    }

    // Страхование путешественников
    public void selectSubMenu(String menuItem) {
        subMenuItem.findElement(By.xpath("//a[contains(@class,'link_level_1')][contains(text(),'" + menuItem + "')]")).click();
    }
}
