package Tests;

import Basics.LoginToLearningMaterials;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.WebAutomationAdvancePage;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//public class Base {
//    BrowserFactory browserFactory = new BrowserFactory();
//
//
//    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
//    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//    LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
//    LoginToLearningMaterials learningMaterialPage = PageFactory.initElements(driver, LoginToLearningMaterials.class);
//    WebAutomationAdvancePage webAutomationAdvancePage = PageFactory.initElements(driver, WebAutomationAdvancePage.class);
//
//}
public class Base {

    protected WebDriver driver;

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected LoginToLearningMaterials learningMaterialPage;
    protected WebAutomationAdvancePage webAutomationAdvancePage;

    @BeforeClass
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");

        // Initialize all page objects
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        learningMaterialPage = PageFactory.initElements(driver, LoginToLearningMaterials.class);
        webAutomationAdvancePage = PageFactory.initElements(driver, WebAutomationAdvancePage.class);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
