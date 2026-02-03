package dibimbing.tests;

import dibimbing.core.BaseTest;
import dibimbing.pages.GlobalPage;
import dibimbing.pages.LoginPage;
import dibimbing.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        // Step 1: Login dulu
        GlobalPage globalPage = new GlobalPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        globalPage.clickViewMenu();
        globalPage.clickLoginMenuItem();
        loginPage.inputUsername("bod@example.com");
        loginPage.inputPassword("10203040");
        loginPage.clickLoginButton();

        // Step 2: Tambah product ke cart
        productPage.clickAddToCart();

        // Step 3: Verifikasi product sudah masuk cart
        Assert.assertTrue(productPage.isCartBadgeDisplayed(), "Product was not added to cart");
    }
}
