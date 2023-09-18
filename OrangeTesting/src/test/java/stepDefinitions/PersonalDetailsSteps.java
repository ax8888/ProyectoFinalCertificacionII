package stepDefinitions;

import io.cucumber.java.en.And;
import pages.DashboardPage;
import pages.PersonalDetailsPage;
import utilities.DriverManager;

public class PersonalDetailsSteps {
    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(DriverManager.getDriver().driver);

    @And("I select Memberships")
    public void selectMemberships() throws InterruptedException {
        Thread.sleep(3000);
        personalDetailsPage.clickOnMembership();
    }

}
