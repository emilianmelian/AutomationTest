package com.pages.frontend;

import org.openqa.selenium.WebElement;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class HomePage extends AbstractPage {

	@FindBy(css = ".panel.header ul.header a[href*='account/create']")
	private WebElement createAccountLink;
	
	public void clickOnCreateAccountLink() {
		element(createAccountLink).waitUntilVisible();
		createAccountLink.click();

	}

}
