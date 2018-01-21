package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by OWL on 21.01.2018.
 */
public class ChoosePolicyPage {

    @FindBy(xpath = "//div[@class='b-form-box-title ng-binding'][text()='Минимальная']")
    public WebElement minSum;

    @FindBy(xpath = "//span[contains(text(),'Оформить')]")
    public WebElement formalizeButton;

    public ChoosePolicyPage (WebDriver driver){
        PageFactory.initElements(driver,this);

        Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);
        wait.until(ExpectedConditions.visibilityOf(minSum));
        wait.until(ExpectedConditions.visibilityOf(formalizeButton));
    }

}
