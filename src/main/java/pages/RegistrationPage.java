package pages;

        import org.junit.Assert;
        import org.openqa.selenium.By;
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
public class RegistrationPage {

    @FindBy(name = "insured0_surname")
    WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    WebElement insuredBirthDate;

    @FindBy(name = "surname")
    WebElement surname;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(name = "female")
    WebElement female;

    @FindBy(name = "passport_series")
    WebElement passportSeries;

    @FindBy(name = "passport_number")
    WebElement passportNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//span[text()='Продолжить']")
    WebElement nextReg;

    @FindBy(xpath="//div[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    WebElement errorMassage;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
      // (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(title));
        Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);
        wait.until(ExpectedConditions.visibilityOf(birthDate));
        wait.until(ExpectedConditions.visibilityOf(nextReg));
            }

    public void clickButton(){
        nextReg.click();
            }
    public void checkMassegeError(){
        Assert.assertEquals("Отсутствует сообщение об ошибке","Заполнены не все обязательные поля",errorMassage.getText());
    }

    public void filledData(String fieldName, String value){
        switch (fieldName) {
            case "Фамилия застрахованного":
                filledData(insuredSurname,value);
                break;
            case "Имя застрахованного":
                filledData(insuredName,value);
                break;
            case "Дата рождения застрахованного":
                filledData(insuredBirthDate,value);
                break;
            case "Фамилия страхователя":
                filledData(surname,value);
                break;
            case "Имя страхователя":
                filledData(name,value);
                break;
            case "Отчество страхователя":
                filledData(middlename,value);
                break;
            case "Дата рождения страхователя":
                birthDate.click();
                filledData(birthDate,value);
                break;
            case "Пол страхователя":
                female.click();
                break;
            case "Серия паспорта":
                filledData(passportSeries,value);
                break;
            case "Номер паспорта":
                filledData(passportNumber,value);
                break;
            case "Дата выдачи паспорта":
                filledData(issueDate,value);
                break;
            case "Кем выдан":
                filledData(issuePlace,value);
                break;
            default: throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");

                    }
    }
    //Метод для заполнения полей
    public void filledData(WebElement element, String value){
        element.clear();//очищаем поле перед заполнением
        element.sendKeys(value);//заполнение
    }

    public void checkField(String checkFieldName) {
        switch (checkFieldName) {
            case "Фамилия застрахованного":
                Assert.assertEquals("Неверно заполнено поле","IVANOV",insuredSurname.getAttribute("value") );
                break;
            case "Имя застрахованного":
                Assert.assertEquals("Неверно заполнено поле","LEV",insuredName.getAttribute("value"));
                break;
            case "Дата рождения застрахованного":
                Assert.assertEquals("Неверно заполнено поле","01.01.2011", insuredBirthDate.getAttribute("value"));
                break;
            case "Фамилия страхователя":
                Assert.assertEquals("Неверно заполнено поле","Иванова", surname.getAttribute("value"));
                break;
            case "Имя страхователя":
                Assert.assertEquals("Неверно заполнено поле","Елена", name.getAttribute("value"));
                break;
            case "Отчество страхователя":
                Assert.assertEquals("Неверно заполнено поле","Петровна", middlename.getAttribute("value"));
                break;
            case "Дата рождения страхователя":
                Assert.assertEquals("Неверно заполнено поле","02.02.1984", birthDate.getAttribute("value"));
                break;
            case "Серия паспорта":
                Assert.assertEquals("Неверно заполнено поле","1234", passportSeries.getAttribute("value"));
                break;
            case "Номер паспорта":
                Assert.assertEquals("Неверно заполнено поле","567890", passportNumber.getAttribute("value"));
                break;
            case "Дата выдачи паспорта":
                Assert.assertEquals("Неверно заполнено поле","12.02.2010", issueDate.getAttribute("value"));
                break;
            case "Кем выдан":
                Assert.assertEquals("Неверно заполнено поле","Отделением ОВД по г. Москва", issuePlace.getAttribute("value"));
                break;
            default: throw new AssertionError("Поле '"+checkFieldName+"' не объявлено на странице");
        }


    }
}

