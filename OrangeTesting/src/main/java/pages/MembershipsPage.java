package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MembershipsPage {
    WebDriver driver;


    public MembershipsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getInformationAboutMemberships(){
        List<String> membershipInformation= new ArrayList<>();
        List<WebElement> webElementsmembershipInformation;
        try{
            webElementsmembershipInformation = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@data-v-6c07a142='']")));
        }
        catch(NoSuchElementException e){
            return membershipInformation;
        }
        for( WebElement element: webElementsmembershipInformation){
            membershipInformation.add(element.getText());
        }
        return membershipInformation;
    }

    public boolean isMembershipInformationCorrect(List<String> expectedInformation){
        List<String> displayedMembershipInformation = getInformationAboutMemberships();
        if(displayedMembershipInformation.size() != expectedInformation.size()){
            return false;
        }

        for (int i = 0; i < expectedInformation.size(); i++) {
            if (!expectedInformation.get(i).equals(displayedMembershipInformation.get(i))) {
                return false;
            }
        }

        return true;
    }


}
