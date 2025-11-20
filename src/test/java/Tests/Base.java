package Tests;

import Basics.LoginToLearningMaterials;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.WebAutomationAdvancePage;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    BrowserFactory browserFactory = new BrowserFactory();


    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
    LoginToLearningMaterials learningMaterialPage = PageFactory.initElements(driver, LoginToLearningMaterials.class);
    WebAutomationAdvancePage webAutomationAdvancePage = PageFactory.initElements(driver, WebAutomationAdvancePage.class);

}
