package pages_homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps_homework4.BaseSteps;

import java.util.ArrayList;

/**
 * Created by OWL on 21.01.2018.
 */
public class ChoosePolicyPage {

    @FindBy(xpath = "//div[@class='b-form-box-title ng-binding'][text()='Минимальная']")
    public WebElement minSum;

    @FindBy(xpath = "//span[contains(text(),'Оформить')]")
    public WebElement formalizeButton;


    public ChoosePolicyPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        ArrayList<String> tabs2 = new ArrayList<String>(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(tabs2.get(1));

        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(minSum));
        wait.until(ExpectedConditions.visibilityOf(formalizeButton));
    }

}