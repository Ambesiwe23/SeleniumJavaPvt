package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WebAutomationAdvancePage {

    WebDriver driver;

    @FindBy(id = "inventory-title")
    WebElement inventoryHeader_id;
    @FindBy(id = "deviceType")
    WebElement deviceTypeDropDown_id;
    @FindBy(id = "brand")
    WebElement tabletBrand_id;
    @FindBy(id = "storage-64GB")
    WebElement storageSize1_id;
    @FindBy(id = "storage-128GB")
    WebElement storageSize2_id;
    @FindBy(id = "storage-256GB")
    WebElement storageSize3_id;
    @FindBy(id = "color")
    WebElement colorDropdown_id;
    @FindBy(id = "quantity")
    WebElement quantitySpinner_id;
    @FindBy(id = "address")
    WebElement addressBox_id;
    @FindBy(id = "inventory-next-btn")
    WebElement nextButton_id;
    @FindBy(id = "shipping-option-express")
    WebElement express_id;
    @FindBy(id = "warranty-option-1yr")
    WebElement warranty_id;
    @FindBy(id = "discount-code")
    WebElement discount_id;
    @FindBy(id = "apply-discount-btn")
    WebElement discountButton_id;
    @FindBy(id = "purchase-device-btn")
    WebElement purchaseButton_id;
    @FindBy(id = "add-to-cart-btn")
    WebElement addToCartBtn_id;
    @FindBy(id = "purchase-success-toast")   // <-- change if your ID is different
    WebElement orderSuccessMessage;


    public WebAutomationAdvancePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void fillAddressAndContinue(String s) {
    }

    public void verifyInventoryHeaderIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(inventoryHeader_id));
        inventoryHeader_id.isDisplayed();
    }

    public void selectDeviceType(String deviceType) {
        deviceTypeDropDown_id.sendKeys(deviceType);
    }

    public void selectTabletBrand(String deviceBrand) {
        tabletBrand_id.sendKeys(deviceBrand);
    }

    public void selectStorageSize(String storageSize) {

        storageSize1_id.click();

    }

    public void selectStorageSize2(String storageSize) {

        storageSize2_id.click();

    }

    public void selectStorageSize3(String storageSize) {

        storageSize3_id.click();

    }

    public void selectColor(String colorType) {
        colorDropdown_id.sendKeys(colorType);
    }

    public void selectQuantity(int deviceQuantity) {
        quantitySpinner_id.clear();
        quantitySpinner_id.sendKeys(String.valueOf(deviceQuantity));
    }

    public void enterAddress(String address) {
        addressBox_id.sendKeys(address);
    }

    public void clickNextBtn() {
        nextButton_id.click();
    }

    public void clickExpress() {
        express_id.click();
    }

    public void clickWarranty() {
        warranty_id.click();
    }

    public void enterDiscountCode(String discount) {
        discount_id.sendKeys(discount);
    }

    public void clickApplyBtn() {
        discountButton_id.click();
    }

    public void clickPurchaseBtn() {
        purchaseButton_id.click();
    }

    public void clickAddToCartBtn() {
        addToCartBtn_id.click();
    }
    public boolean isOrderSuccessful() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(orderSuccessMessage));
            return orderSuccessMessage.getText().contains("Order Successful");
        } catch (Exception e) {
            return false;
        }
    }

}





   

