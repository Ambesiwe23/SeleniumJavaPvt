package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "login-email")
    WebElement loginEmail_id;
    @FindBy(id = "login-password")
    WebElement loginPassword_id;
    @FindBy(id = "login-submit")
    WebElement loginSubmit_id;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoginEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(loginEmail_id));
        loginEmail_id.sendKeys(email);
    }

    public void enterPasswordId(String password) {
        loginPassword_id.sendKeys(password);
    }

    public void clickLogin() {
        loginSubmit_id.click();
    }

    public void handleAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String alertText = alert.getText();
            System.out.println("Alert message: " + alertText);

            // ASSERTION
            Assert.assertEquals(alertText, "Expected alert message", "Alert text mismatch!");

            alert.accept();

        } catch (Exception e) {
            Assert.fail("Expected alert did not appear.");
        }
        


    }

}