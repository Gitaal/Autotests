package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by OWL on 21.01.2018.
 */
public class TravelInsurancePage {
    @FindBy(xpath = "//img[contains(@src,'id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53')]")
    public WebElement sendButton;

    @FindBy(xpath = "//h1[text()='Страхование путешественников']")
    public WebElement title;

    public TravelInsurancePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);
        wait.until(ExpectedConditions.visibilityOf(title));
        wait.until(ExpectedConditions.visibilityOf(sendButton));

    }

}
