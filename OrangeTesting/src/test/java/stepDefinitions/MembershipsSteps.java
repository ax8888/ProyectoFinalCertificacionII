package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.MembershipsPage;
import utilities.DriverManager;

import java.util.List;

public class MembershipsSteps {
    MembershipsPage membershipsPage = new MembershipsPage(DriverManager.getDriver().driver);

    @Then("The membership with the following information should be displayed")
    public void verifyMembershipInformation(DataTable dataTableMembershipInformation){
        List<String> data = dataTableMembershipInformation.transpose().asList(String.class);
        Assertions.assertTrue(membershipsPage.isMembershipInformationCorrect(data));
    }

}
