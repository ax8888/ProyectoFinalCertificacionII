package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.DriverManager;

public class CommonSteps {

    @Given("I am in Orange HRM web page")
    public void goToOrangeHRMPage() throws InterruptedException {
        DriverManager.getDriver().driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        DriverManager.getDriver().driver.manage().window().maximize();
        Thread.sleep(3000); //due to slow connection
    }
}
