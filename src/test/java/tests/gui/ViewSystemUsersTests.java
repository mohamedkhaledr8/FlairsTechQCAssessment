package tests.gui;


import com.github.javafaker.Faker;
import CommonComponents.SideMenu;
import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.admin.SaveSystemUserPage;
import pages.admin.ViewSystemUsersPage;
import utils.Utility;


public class ViewSystemUsersTests {
    private final ViewSystemUsersPage viewSystemUsersPage;
    private final SaveSystemUserPage saveSystemUserPage;
    private String userName = null;
    private int currentRecordNumber = 0;
    private int recordNumberAfterUserIsAdded = 0;
    private int recordNumberAfterUserIsDeleted = 0;


    public ViewSystemUsersTests()
    {
        viewSystemUsersPage = new ViewSystemUsersPage(DriverFactory.getDriver());
        saveSystemUserPage = new SaveSystemUserPage(DriverFactory.getDriver());
    }





    @And("Admin open view system users page")
    public void openViewSystemUsersPage() {
        new SideMenu(DriverFactory.getDriver()).navigateToAdminViewSystemUserPage();
        currentRecordNumber = new Utility().getNumbersFromText(viewSystemUsersPage.getRecordsNumber());

    }

    @When("Admin click on add user button")
    public void clickAddUserButton() {
        viewSystemUsersPage.clickAddButton();

    }

    @And("Admin fill all required data")
    public void fillAllRequiredData() {
        var faker = new Faker();
        userName = faker.name().username();
        var password = faker.internet().password(12, 15, true, true, true);
        saveSystemUserPage.selectUserRole();
        saveSystemUserPage.selectUserStatus();
        saveSystemUserPage.selectEmployeeName("ti");
        saveSystemUserPage.typeUserName(userName);
        saveSystemUserPage.typePassword(password);
        saveSystemUserPage.typeConfirmPassword(password);
    }

    @And("Admin click save button")
    public void clickSaveButton() {
        saveSystemUserPage.clickSaveButton();
        recordNumberAfterUserIsAdded = new Utility().getNumbersFromText(viewSystemUsersPage.getRecordsNumber());
    }

    @When("Admin searched for added user")
    public void searchedForAddedUser() {
        viewSystemUsersPage.searchForUser(userName);
    }

    @And("Admin delete added user")
    public void deleteAddedUser() {
        viewSystemUsersPage.deleteUser(userName);
        viewSystemUsersPage.resetFilter();
        recordNumberAfterUserIsDeleted = new Utility().getNumbersFromText(viewSystemUsersPage.getRecordsNumber());
    }

    @Then("User records should be increased by one")
    public void userRecordsShouldBeIncreasedByOne() {
        Assert.assertEquals(recordNumberAfterUserIsAdded, currentRecordNumber + 1);
    }

    @Then("User records should be Decreased by one")
    public void userRecordsShouldBeDecreasedByOne() {
        Assert.assertEquals(recordNumberAfterUserIsDeleted, recordNumberAfterUserIsAdded - 1);
    }



}
