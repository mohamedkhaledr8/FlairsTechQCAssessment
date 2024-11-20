package tests;


import Browser.BrowserManager;
import com.github.javafaker.Faker;
import commonComponents.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.admin.SaveSystemUserPage;
import pages.admin.ViewSystemUsersPage;
import pages.login.LoginPage;
import utils.Utils;

public class ViewSystemUsersTests {
    private ViewSystemUsersPage viewSystemUsersPage;
    private SaveSystemUserPage saveSystemUserPage;
    private Utils utils;
    private String userName = null;
    private int currentRecordNumber = 0;
    private int recordNumberAfterUserIsAdded = 0;
    private int recordNumberAfterUserIsDeleted = 0;

    public ViewSystemUsersTests() {
        BrowserManager.getInstance().getDriver().get(System.getProperty("url"));
        viewSystemUsersPage = new ViewSystemUsersPage(BrowserManager.getInstance().getDriver());
        saveSystemUserPage = new SaveSystemUserPage(BrowserManager.getInstance().getDriver());
        utils = new Utils();


    }

    @Given("the admin user login")
    public void Login() {
        new LoginPage(BrowserManager.getInstance().getDriver()).login(System.getProperty("admin.user.name"), System.getProperty("password"));
    }

    @And("the admin open view system users page")
    public void openViewSystemUsersPage() {
        new SideMenu(BrowserManager.getInstance().getDriver()).navigateToAdminViewSystemUserPage();
        currentRecordNumber = utils.getNumbersFromText(viewSystemUsersPage.getRecordsNumber());

    }

    @When("the admin click on add user button")
    public void clickAddUserButton() {
        viewSystemUsersPage.clickAddButton();

    }

    @And("the admin fill all required data")
    public void fillAllRequiredData() {
        var faker = new Faker();
        userName = faker.name().username();
        var password = faker.internet().password(12, 15, true, true, true);
        saveSystemUserPage.selectUserRole(2);
        saveSystemUserPage.selectUserStatus(2);
        saveSystemUserPage.selectEmployeeName("ti");
        saveSystemUserPage.typeUserName(userName);
        saveSystemUserPage.typePassword(password);
        saveSystemUserPage.typeConfirmPassword(password);
    }

    @And("the admin click save button")
    public void clickSaveButton() {
        saveSystemUserPage.clickSaveButton();
        recordNumberAfterUserIsAdded = utils.getNumbersFromText(viewSystemUsersPage.getRecordsNumber());
    }

    @When("the admin searched for added user")
    public void searchedForAddedUser() {
        viewSystemUsersPage.searchForUser(userName);
    }

    @And("the admin delete added user")
    public void deleteAddedUser() {
        viewSystemUsersPage.deleteUser(userName);
        viewSystemUsersPage.resetFilter();
        recordNumberAfterUserIsDeleted = utils.getNumbersFromText(viewSystemUsersPage.getRecordsNumber());
    }

    @Then("the user records should be increased by one")
    public void userRecordsShouldBeIncreasedByOne() {
        Assert.assertEquals(recordNumberAfterUserIsAdded, currentRecordNumber + 1);
    }

    @Then("the user records should be Decreased by one")
    public void userRecordsShouldBeDecreasedByOne() {
        Assert.assertEquals(recordNumberAfterUserIsDeleted, recordNumberAfterUserIsAdded - 1);
    }


}
