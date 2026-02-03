package dibimbing.tests;

import dibimbing.core.BaseTest;
import dibimbing.pages.GlobalPage;
import dibimbing.pages.LoginPage;
import dibimbing.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        GlobalPage globalPage = new GlobalPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        globalPage.clickViewMenu();
        globalPage.clickLoginMenuItem();
        loginPage.inputUsername("bod@example.com");
        loginPage.inputPassword("10203040");
        loginPage.clickLoginButton();

        Assert.assertTrue(productPage.isProductTitleDisplayed(), "Product title is not displayed");
    }

    @Test
    public void failedloginWithBlankInputUsername() {
        GlobalPage globalPage = new GlobalPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        globalPage.clickViewMenu();
        globalPage.clickLoginMenuItem();

        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickLoginButton();

        String actualError = loginPage.getErrorUsernameText();
        System.out.println("Error message: " + actualError);

            Assert.assertEquals(
                    actualError,
                    "Username is required"
            );
        }
    }

