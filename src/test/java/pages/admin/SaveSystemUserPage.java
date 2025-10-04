package pages.admin;

import gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SaveSystemUserPage {
    private final ElementActions elementActions;

    public SaveSystemUserPage(WebDriver driver) {
        elementActions = new ElementActions(driver);
    }

    public void selectUserRole() {
        elementActions.click(By.xpath("(//div[@class='oxd-select-wrapper'])[1]/div"));

        var options = elementActions.getElements(By.xpath("//div[@role='listbox']/div[@role='option']/span"));


        String optionText = options.getLast().getText();
        elementActions.click(By.xpath("//div[@role='listbox']/div[@role='option']/span[text()= '" + optionText + "']"));
    }

    public void selectUserStatus() {
        elementActions.click(By.xpath("(//div[@class='oxd-select-wrapper'])[2]/div"));

        var options = elementActions.getElements(By.xpath("//div[@role='listbox']/div[@role='option']/span"));


        String optionText = options.getLast().getText();
        elementActions.click(By.xpath("//div[@role='listbox']/div[@role='option']/span[text()= '" + optionText + "']"));
    }

    public void selectEmployeeName(String subName) {
        elementActions.type(By.xpath("//div[@class='oxd-autocomplete-wrapper']/descendant::input"), subName);
        var options = elementActions.getElements(By.xpath("//div[@role='listbox']/div[@role='option']/span"));

        //int randomIndex = new Random().nextInt(options.size());
        String optionText = options.getFirst().getText();
        elementActions.click(By.xpath("//div[@role='listbox']/div[@role='option']/span[text()= '" + optionText + "']"));

    }

    public void typeUserName(String userName) {
        elementActions.type(By.xpath("(//input[@autocomplete='off'])[1]"), userName);
    }

    public void typePassword(String password) {
        elementActions.type(By.xpath("(//input[@autocomplete='off'])[2]"), password);
    }

    public void typeConfirmPassword(String confirmPassword) {
        elementActions.type(By.xpath("(//input[@autocomplete='off'])[3]"), confirmPassword);
    }

    public void clickSaveButton() {
        elementActions.click(By.xpath("//button[@type='submit']"));
    }

}
