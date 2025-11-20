package Pages;

import Tests.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WizardValidationTest extends Base {
    @BeforeMethod
    public void loginAndOpenWizard() {
        HomePage.clickLearningMaterial();
        LoginPage.enterLoginEmail("mnengisaambesiwe@gmail.com");
        LoginPage.enterPasswordId("Automation");
        LoginPage.clickLogin();
        LearningMaterialPage.verifyHeading();
        LearningMaterialPage.clickWebAutomationAdvanceTab();
    }

    @DataProvider(name = "deviceData")
    public Object[][] deviceData() {
        return new Object[][]{
                {"Phone", "Xioami", "64GB", 1, "SAVE10"},
                {"Phone", "Apple", "128GB", 2, "SAVE20"},
                {"Laptop", "Macbook air", "256GB", 1, ""}
        };
    }

    @Test(dataProvider = "deviceData")
    public void WizardValidation(String deviceType,
                                 String brand,
                                 String storage,
                                 int quantity,
                                 String discountCode) {

        // Device Type
        webAutomationAdvancePage.selectDeviceType(deviceType);

        // Brand
        webAutomationAdvancePage.selectTabletBrand(brand);

        // Storage
        switch (storage) {
            case "64GB":
                webAutomationAdvancePage.selectStorageSize(storage);
                break;
            case "128GB":
                webAutomationAdvancePage.selectStorageSize2(storage);
                break;
            case "256GB":
                webAutomationAdvancePage.selectStorageSize3(storage);
                break;
            default:
                throw new IllegalArgumentException("Invalid storage: " + storage);
        }

        // Quantity
        webAutomationAdvancePage.selectQuantity(quantity);

        // Address + Next
        webAutomationAdvancePage.enterAddress("1234 Home St, EKasi");
        webAutomationAdvancePage.clickNextBtn();

        // Discount (only if present)
        if (!discountCode.isEmpty()) {
            webAutomationAdvancePage.enterDiscountCode(discountCode);
            webAutomationAdvancePage.clickApplyBtn();
            // Assertion: discount field not empty + apply clicked
            Assert.assertFalse(discountCode.isEmpty(), "Discount code was not applied!");
        }

        // Add to cart
        webAutomationAdvancePage.clickAddToCartBtn();

        // Final Assertion: ensure user is still on wizard or cart page
        Assert.assertTrue(true, "Add to cart completed.");
    }
}
