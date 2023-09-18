package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.AdminPage;
import utilities.DriverManager;

import java.util.List;

public class AdminSteps {

    AdminPage adminPage = new AdminPage(DriverManager.getDriver().driver);

    @Then("I get a certain message when putting a certain password")
    public void verifyPasswordErrorMessage(DataTable dataTable){
        List<String> data = dataTable.transpose().asList(String.class);
        adminPage.fillPasswordField(data.get(0));
        Assertions.assertTrue(adminPage.isErrorMessageCorrect(data.get(1)));

    }

}
