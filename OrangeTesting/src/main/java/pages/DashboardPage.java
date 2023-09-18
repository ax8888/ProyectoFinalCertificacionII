package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    WebDriver driver;

    @FindBy(className = "oxd-userdropdown-tab")
    WebElement userDropdownButton;

    @FindBy(css = "a[href='/web/index.php/pim/viewMyDetails']")
    WebElement myInfoLink;

    @FindBy(css="a[href='/web/index.php/admin/viewAdminModule']")
    WebElement adminLink;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickUserDropdownButton(){
        //Select selectObject = new Select(userDropdown);
        //selectObject.selectByVisibleText(selection);
        userDropdownButton.click();
    }

    public void clickDropdownOption(String option){
        WebElement dropdownOption = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText(option)));
        dropdownOption.click();
    }

    public boolean isAboutTitleDisplayed(){
        try{
            WebElement aboutTitle = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h6.orangehrm-main-title")));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    //returns About Titles list, and if there are none, it returns an empty list
    public List<String> getAboutTitlesDisplayed(){
        List<String> aboutTitles = new ArrayList<>();
        List<WebElement> webElementsAboutTitles;
        try{
            webElementsAboutTitles = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("p.orangehrm-about-title")));
        }
        catch(NoSuchElementException e){
            return aboutTitles;
        }
        for( WebElement element: webElementsAboutTitles){
            aboutTitles.add(element.getText());
        }
        return aboutTitles;
    }

    public boolean areAboutTitlesDisplayedCorrectly(List<String> expectedAboutTitles){
        List<String> displayedAboutTitles = getAboutTitlesDisplayed();
        if(displayedAboutTitles.size() != expectedAboutTitles.size()){
            return false;
        }
        for (int i = 0; i < displayedAboutTitles.size(); i++) {
            if (!expectedAboutTitles.get(i).equals(displayedAboutTitles.get(i))) {
                return false;
            }
        }
        return true;
    }

    public List<String> getAboutInformation(){
        List<String> aboutInformation= new ArrayList<>();
        List<WebElement> webElementsAboutInformation;
        try{
            webElementsAboutInformation = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("p.orangehrm-about-text")));
        }
        catch(NoSuchElementException e){
            return aboutInformation;
        }
        for( WebElement element: webElementsAboutInformation){
            aboutInformation.add(element.getText());
        }
        return aboutInformation;
    }

    public boolean isAboutInformationCorrect(List<String> expectedAboutInformation){
        List<String> displayedAboutInformation = getAboutInformation();
        if(displayedAboutInformation.size() != 4){
            return false;
        }

        for (int i = 0; i < 2; i++) {
            if (!expectedAboutInformation.get(i).equals(displayedAboutInformation.get(i))) {
                return false;
            }
        }

        if(Integer.parseInt(displayedAboutInformation.get(2)) < 0){
            return false;
        }

        if(!expectedAboutInformation.get(2).equals(displayedAboutInformation.get(3))){
            return false;
        }

        return true;
    }

    public void clickOnMyInfo(){
        myInfoLink.click();
    }

    public void clickOnAdmin(){
        adminLink.click();
    }

}
