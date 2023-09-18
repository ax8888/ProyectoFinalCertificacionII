package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;

public class AdminPage {
    WebDriver driver;

    @FindBy(css="input[type='password'][data-v-1f99f73c]")
    WebElement passwordField;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillPasswordField(String password){
        passwordField.sendKeys(password);
    }

    public boolean isErrorMessageCorrect(String expectedMessage){
        WebElement actualMessage;
        try{
            actualMessage = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("WebElement inputElement = driver.findElement(By.cssSelector(\"input.oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message[data-v-7b563373][data-v-957b4417]")));

        }catch(TimeoutException e){
            return false;
        }

        if(actualMessage.getText().equals(expectedMessage)) {
            return true;
        }else{
            return false;
        }

    }

}
