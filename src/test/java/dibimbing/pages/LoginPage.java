package dibimbing.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement nameET;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement passwordET;

    @AndroidFindBy(accessibility = "Tap to login with given credentials")
    private WebElement loginButton;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void inputUsername(String username) {
        nameET.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordET.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
