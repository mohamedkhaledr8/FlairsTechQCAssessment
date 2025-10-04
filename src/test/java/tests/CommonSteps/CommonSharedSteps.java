package tests.CommonSteps;

import driver.CookiesFactory;
import driver.DriverFactory;
import gui.browser.BrowserActions;
import io.cucumber.java.en.Given;
import pages.login.LoginPage;

public class CommonSharedSteps {
    @Given("Admin user login with valid email and password")
    public void LoginWithValidUserNameAndPassword() {
        new LoginPage(DriverFactory.getDriver()).login(System.getProperty("admin.user.name"), System.getProperty("password"));
        CookiesFactory.saveCookies(DriverFactory.getDriver());
    }
    @Given("Admin navigate to url")
    public void theAdminNavigateToUrl() {
        new BrowserActions(DriverFactory.getDriver()).navigateTo(System.getProperty("url"));

    }

}
