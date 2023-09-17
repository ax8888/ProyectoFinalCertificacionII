package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.DashboardPage;
import utilities.DriverManager;

import java.util.List;

public class DashboardSteps {
    DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver().driver);

    @And("I select {string}")
    public void selectUserDropdownMenu(String selection) throws InterruptedException {
        dashboardPage.clickUserDropdownButton();
        dashboardPage.clickDropdownOption(selection);
        Thread.sleep(3000);

    }

    @Then("About title should show")
    public void verifyAboutTitleIsDisplayed(){
        Assertions.assertTrue(dashboardPage.isAboutTitleDisplayed());
    }

    @And("The following information titles should be displayed")
    public void verifyAboutTitles(DataTable expectedAboutTitles){
        List<String> data = expectedAboutTitles.transpose().asList(String.class);
        Assertions.assertTrue(dashboardPage.areAboutTitlesDisplayedCorrectly(data));
    }

    @And("The following information text should be displayed")
    public void verifyAboutInformation(DataTable expectedAboutInformation){
        List<String> data = expectedAboutInformation.transpose().asList(String.class);
        Assertions.assertTrue(dashboardPage.isAboutInformationCorrect(data));
    }


}
