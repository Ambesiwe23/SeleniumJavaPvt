package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class MyTests extends Base {

    public void verifyHomePageIsDisplayedTests() {
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTests")
    public void clickLearningMaterialTests() throws InterruptedException {
        homePage.clickLearningMaterial();
        Thread.sleep(2500);
    }

    @Test(dependsOnMethods = "clickLearningMaterialTests")
    public void enterLoginEmail() throws InterruptedException {
        loginPage.enterLoginEmail("mnengisaambesiwe@gmail.com");

    }

    @Test(dependsOnMethods = "enterLoginEmail")
    public void enterPasswordTests() throws InterruptedException {
        loginPage.enterPasswordId("Automation");
        Thread.sleep(1800);
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginTests() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "clickLoginTests")
    public void verifyWelcomeHeading() throws InterruptedException {
        learningMaterialPage.verifyHeading();
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "verifyWelcomeHeading")
    public void clickWebAutomationAdvanceTab() throws InterruptedException {
        learningMaterialPage.clickWebAutomationAdvanceTab();
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "clickWebAutomationAdvanceTab")
    public void verifyWebAutomationAdvancePageIsDisplayedTest() throws InterruptedException {
        webAutomationAdvancePage.verifyInventoryHeaderIsDisplayed();
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "verifyWebAutomationAdvancePageIsDisplayedTest")
    public void selectDeviceTypeTest() throws InterruptedException {
        webAutomationAdvancePage.selectDeviceType("Tablet");
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "selectDeviceTypeTest")
    public void selectDeviceBrandTest() throws InterruptedException {
        webAutomationAdvancePage.selectTabletBrand("Samsung");
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "selectDeviceBrandTest")
    public void selectStorageSizeTest() throws InterruptedException {
        webAutomationAdvancePage.selectStorageSize("64GB");
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "selectStorageSizeTest")
    public void selectColorTest() throws InterruptedException {
        webAutomationAdvancePage.selectColor("White");
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "selectColorTest")
    public void selectQuantityTest() throws InterruptedException {
        webAutomationAdvancePage.selectQuantity(Integer.parseInt("2"));
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "selectQuantityTest")
    public void enterAddressTest() throws InterruptedException {
        webAutomationAdvancePage.enterAddress("1234 Home St, EKasi");
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "enterAddressTest")
    public void nextButtonTest() throws InterruptedException {
        webAutomationAdvancePage.clickNextBtn();
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "nextButtonTest")
    public void expressButtonTest() throws InterruptedException {
        webAutomationAdvancePage.clickExpress();
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "expressButtonTest")
    public void warrantyClickTest() throws InterruptedException {
        webAutomationAdvancePage.clickWarranty();
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "warrantyClickTest")
    public void enterDiscountTest() throws InterruptedException {
        webAutomationAdvancePage.enterDiscountCode("SAVE20");
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "enterDiscountTest")
    public void clickApplyButtonTest() throws InterruptedException {
        webAutomationAdvancePage.clickApplyBtn();
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "clickApplyButtonTest")
    public void clickPurchaseButtonTest() throws InterruptedException {
        webAutomationAdvancePage.clickPurchaseBtn();
        Thread.sleep(2100);
    }

    public void VerifyInvalidLogin() {
        homePage.clickLearningMaterial();
        loginPage.enterLoginEmail("mnengisaambesiwe@gmail.com");
        loginPage.enterPasswordId("lAutomation");
        loginPage.clickLogin();
    }

    public void VerifyThatSpacesGetTrimmedOnUsernameOrPassword() {
        homePage.clickLearningMaterial();
        loginPage.enterLoginEmail(" mnengisaambesiwe@gmail.com ");
        loginPage.enterPasswordId(" Automation ");
        loginPage.clickLogin();
        learningMaterialPage.verifyHeading();
    }

    @SuppressWarnings("DuplicatedLiteral")
    @Test //(dependsOnMethods = "VerifyThatSpacesGetTrimmedOnUsernameOrPassword")
    public void WizardValidation() throws InterruptedException {
        homePage.clickLearningMaterial();
        loginPage.enterLoginEmail(" mnengisaambesiwe@gmail.com ");
        loginPage.enterPasswordId(" Automation ");
        loginPage.clickLogin();
        learningMaterialPage.verifyHeading();
        learningMaterialPage.clickWebAutomationAdvanceTab();
        webAutomationAdvancePage.selectDeviceType("Phone");
        webAutomationAdvancePage.selectTabletBrand("Xioami");
        webAutomationAdvancePage.selectStorageSize("64GB");
        webAutomationAdvancePage.selectQuantity(1);
        webAutomationAdvancePage.enterAddress("1234 Home St, EKasi");
        webAutomationAdvancePage.clickNextBtn();
        webAutomationAdvancePage.enterDiscountCode("SAVE10");
        webAutomationAdvancePage.clickApplyBtn();
        webAutomationAdvancePage.clickAddToCartBtn();
        webAutomationAdvancePage.selectDeviceType("Phone");
        webAutomationAdvancePage.selectTabletBrand("Apple");
        webAutomationAdvancePage.selectStorageSize2("128GB");
        webAutomationAdvancePage.selectQuantity(2);
        webAutomationAdvancePage.enterAddress("1234 Home St, EKasi");
        webAutomationAdvancePage.clickNextBtn();
        webAutomationAdvancePage.enterDiscountCode("SAVE20");
        webAutomationAdvancePage.clickApplyBtn();
        webAutomationAdvancePage.clickAddToCartBtn();
        webAutomationAdvancePage.selectDeviceType("Laptop");
        webAutomationAdvancePage.selectTabletBrand("Macbook air");
        webAutomationAdvancePage.selectStorageSize3("256GB");
        webAutomationAdvancePage.selectQuantity(1);
        webAutomationAdvancePage.enterAddress("1234 Home St, EKasi");
        webAutomationAdvancePage.clickNextBtn();
        webAutomationAdvancePage.clickAddToCartBtn();
        //Thread.sleep(5000);

    }



    @AfterTest

    public void closeBrowser() {
        driver.quit();
    }
}
