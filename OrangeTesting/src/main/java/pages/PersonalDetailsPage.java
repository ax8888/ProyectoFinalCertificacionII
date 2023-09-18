package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {
    WebDriver driver;

    @FindBy(css = "a[href='/web/index.php/pim/viewMemberships/empNumber/7']")
    WebElement membershipLink;

    public PersonalDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMembership(){
        membershipLink.click();
    }

}
