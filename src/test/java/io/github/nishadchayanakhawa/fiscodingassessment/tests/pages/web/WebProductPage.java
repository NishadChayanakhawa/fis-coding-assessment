package io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.IProductPage;
import io.nishadc.automationtestingframework.testinginterface.webui.ApplicationActions;

/**
 * <b>Class Name</b>: WebProductPage<br>
 * <b>Description</b>: Web product opage implementation<br>
 * 
 * @author nishad.chayanakhawa
 */
public class WebProductPage extends ApplicationActions implements IProductPage {

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartButton;

	@FindBy(xpath = "//i[@id='gh-cart-n']")
	WebElement cartItemCount;

	public WebProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * <b>Method Name</b>: addProductToCart<br>
	 * <b>Description</b>: Click on add car button.<br>
	 */
	public void addProductToCart() {
		this.clickElement(addToCartButton, "'Add to cart button'");
	}

	/**
	 * <b>Method Name</b>: getCartItemCount<br>
	 * <b>Description</b>: Get number of items displayed tagged to shopping cart
	 * icon.<br>
	 * 
	 * @return number of products in cart as integer
	 */
	@Override
	public int getCartItemCount() {
		String cartItemCountText = this.getInnerText(cartItemCount);
		return Integer.parseInt(cartItemCountText);
	}
}
