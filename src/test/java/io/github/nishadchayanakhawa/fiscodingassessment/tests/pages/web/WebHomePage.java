package io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.nishadc.automationtestingframework.testinginterface.webui.ApplicationActions;
import io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.IHomePage;

/**
 * <b>Class Name</b>: WebHomePage<br>
 * <b>Description</b>: Web Home page implementation<br>
 * @author nishad.chayanakhawa
 */
public class WebHomePage extends ApplicationActions implements IHomePage {
	public WebHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='gh-ac']")
	WebElement search;

	@FindBy(xpath = "(//li[contains(@class,'ui-menu-item')])[1]")
	WebElement firstResult;

	@FindBy(xpath = "(//ul[contains(@class,'srp-results')]//li[contains(@class,'s-item ')])[1]//div[contains(@class,'s-item__image-section')]")
	WebElement firstListing;

	/**
	 * <b>Method Name</b>: searchAndSelectFirstOption<br>
	 * <b>Description</b>: Search for product and select first option<br>
	 * @param textToSearch text to search as {@link java.lang.String String}
	 */
	@Override
	public void searchAndSelectFirstOption(String textToSearch) {
		this.sendText(search, textToSearch, "'Search input'");
		this.clickElement(firstResult, "First result");
	}

	/**
	 * <b>Method Name</b>: selectFirstResult<br>
	 * <b>Description</b>: Select first result from listing and switch to new tab<br>
	 */
	@Override
	public void selectFirstResult() {
		this.clickElement(firstListing, "'First listing'");
		Object[] windowHandles = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandles[1]);
	}
}
