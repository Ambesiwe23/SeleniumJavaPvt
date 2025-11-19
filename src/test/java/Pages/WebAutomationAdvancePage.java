package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    WebElement storageSize_id;
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


    public WebAutomationAdvancePage(WebDriver driver) {
        this.driver = driver;
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

        storageSize_id.click();
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

    public void clickExpress(){
        express_id.click();
    }
    public void clickWarranty(){
        warranty_id.click();
    }
    public void enterDiscountCode(String discount){
        discount_id.sendKeys(discount);
    }
    public void clickApplyBtn() {
        discountButton_id.click();
    }
    public void clickPurchaseBtn() {
        purchaseButton_id.click();
    }



   
}
