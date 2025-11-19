package Basics;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginToLearningMaterials {
    WebDriver driver;
    @FindBy(id = "practice-heading")
    WebElement welcomeHeading_id;
    @FindBy(id = "tab-btn-web")
    WebElement WebAutomationAdvanceTab_id;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void startBrowser() throws InterruptedException {
        // driver = new ChromeDriver();
        driver.get("https://www.ndosiautomation.co.za/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void verifyHomePageIsDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"overview-hero\"]/h2")).isDisplayed();
    }

    @Test(priority = 2)
    public void clickLearningMaterials() throws InterruptedException {
        driver.findElement(By.id("nav-btn-practice")).click();
        Thread.sleep(2000);
    }


    @Test(priority = 3)
    public void enterEmail() {
        driver.findElement(By.id("login-email")).sendKeys("mnengisambesiwe@gmail.com");
    }

    @Test(priority = 4)
    public void enterPassword() {
        driver.findElement(By.id("login-password")).sendKeys("Automation");
    }

    @Test(priority = 5)
    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();

    }




    public void verifyHeading() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(welcomeHeading_id));
        welcomeHeading_id.isDisplayed();
    }

    public void clickWebAutomationAdvanceTab() {
        WebAutomationAdvanceTab_id.click();
    }
}
