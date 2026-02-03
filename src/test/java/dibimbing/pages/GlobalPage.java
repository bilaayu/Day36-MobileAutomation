package dibimbing.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class GlobalPage extends BasePage {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private WebElement viewMenu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    private WebElement loginMenuItem;

    public GlobalPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickViewMenu() {
        viewMenu.click();
    }

    public void clickLoginMenuItem() {
        loginMenuItem.click();
    }
}
