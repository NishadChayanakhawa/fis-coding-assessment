package io.github.nishadchayanakhawa.fiscodingassessment.tests.web;

//import section
//jassert libraries
import org.assertj.core.api.Assertions;
//selenium libraries
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//testng libraries
import org.testng.annotations.Test;
//pages
import io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.Channel;
import io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.IHomePage;
import io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.IProductPage;
import io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.PageFactory;
import io.nishadc.automationtestingframework.testngcustomization.TestFactory;

/**
 * <b>Class Name</b>: EBayIT<br>
 * <b>Description</b>: Web UI testing assessment<br>
 * 
 * @author nishad.chayanakhawa
 */
public class EBayIT {

	// Defining constants for the test URL and search keyword
	private static final String URL = "https://www.ebay.com/"; // URL for eBay homepage
	private static final String SEARCH_TEXT = "book"; // Search text to look for on eBay

	@Test
	void shoppingCartTest() {
		// Creating a new WebDriver instance using WebDriverManager
		WebDriver driver = WebDriverManager.chromedriver().create();

		// Recording the start of the test
		TestFactory.recordTest("Shopping cart test", driver);

		// Navigating to the eBay homepage
		driver.get(EBayIT.URL);
		TestFactory.recordTestStep(String.format("Navigate to %s", EBayIT.URL), true);

		// Getting the home page object using the PageFactory
		// This initializes the page object for the web version of the homepage
		IHomePage homePage = PageFactory.getHomePage(driver, Channel.Web);

		// Searching for the specified text and selecting the first search result
		homePage.searchAndSelectFirstOption(EBayIT.SEARCH_TEXT);
		TestFactory.recordTestStep(String.format("Search for text '%s' and select first option.", EBayIT.SEARCH_TEXT),
				true);

		// Selecting the first product from the search results
		homePage.selectFirstResult();

		// Getting the product page object using the PageFactory
		IProductPage productPage = PageFactory.getProductPage(driver, Channel.Web);

		// Adding the selected product to the shopping cart
		productPage.addProductToCart();
		TestFactory.recordTestStep(String.format("Selected first listing"), true);

		// Retrieving the current item count from the cart
		int cartItemCount = productPage.getCartItemCount();
		TestFactory.recordTestStep(String.format("Added last product to cart. Cart items count: %d", cartItemCount),
				true);

		// Asserting that the cart contains exactly 1 item
		Assertions.assertThat(cartItemCount).isEqualTo(1);

		// Quitting the browser driver and closing the session
		driver.quit();
	}
}
