package dibimbing.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    @AndroidFindBy(accessibility = "title")
    private WebElement productTitle;

    public ProductPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isProductTitleDisplayed() {
        return productTitle.isDisplayed();
    }
}
