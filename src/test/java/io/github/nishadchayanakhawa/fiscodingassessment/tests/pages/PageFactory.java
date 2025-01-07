package io.github.nishadchayanakhawa.fiscodingassessment.tests.pages;

import org.openqa.selenium.WebDriver;

import io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.web.WebHomePage;
import io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.web.WebProductPage;

public class PageFactory {
	protected PageFactory() {
		// Do Nothing
		// Is supposed to be accessed via static methods only and object will never be
		// instantiated
	}

	public static IHomePage getHomePage(WebDriver driver, Channel channel) {
		switch (channel) {
		case Web:
			return new WebHomePage(driver);
		default:
			// Will never reach here due to enumerated choice
			return null;
		}
	}
	
	public static IProductPage getProductPage(WebDriver driver, Channel channel) {
		switch (channel) {
		case Web:
			return new WebProductPage(driver);
		default:
			// Will never reach here due to enumerated choice
			return null;
		}
	}
}
