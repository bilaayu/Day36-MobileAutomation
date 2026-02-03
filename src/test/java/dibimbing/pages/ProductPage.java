package dibimbing.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    public ProductPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "title")
    private WebElement productTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement cartIcon;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productIV")
    private WebElement chooseProduct;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement cartButton;

    public boolean isProductTitleDisplayed() {
        return productTitle.isDisplayed();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickCartButton() {
        if (cartButton.isDisplayed()) {
            cartButton.click();
        }
    }

    public void clickChooseProduct() {
        chooseProduct.click();
    }
}
