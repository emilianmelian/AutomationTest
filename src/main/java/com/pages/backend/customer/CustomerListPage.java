package com.pages.backend.customer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pages.AbstractPage;
import com.tools.constants.TimeConstants;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CustomerListPage extends AbstractPage {

	@FindBy(css = ".admin__control-text[name='email']:nth-child(1)")
	private WebElement emailFilterInput;

	@FindBy(css = ".admin__data-grid-wrap >table[data-role]")
	private WebElement listContainer;
	
	@FindBy(css = "td.filter-actions.a-right button:nth-child(1)")
	private WebElement resetFilter;

	@FindBy(css = ".admin__footer-main-actions button.action-secondary span")
	private WebElement applyFilters;
	
	@FindBy(css = ".data-grid.data-grid-draggable> tbody > tr.data-row > td.data-grid-actions-cell > a")
	private WebElement clickOnEdit;
	
	@FindBy(css = "#container .admin__data-grid-outer-wrap .admin__data-grid-loading-mask")
	private WebElement loadingSpinner;
	
	public void inputEmailFilter(String emailText) {
		evaluateJavascript("jQuery.noConflict();");
		element(emailFilterInput).waitUntilVisible();
		emailFilterInput.clear();
		emailFilterInput.sendKeys(emailText);
	}

	public void clickOnSearch() {
		evaluateJavascript("jQuery.noConflict();");
		element(applyFilters).waitUntilVisible();
		applyFilters.click();
		waitABit(TimeConstants.TIME_CONSTANT);
	}
	public void clickOnResetFilter() {
		evaluateJavascript("jQuery.noConflict();");
		element(resetFilter).waitUntilVisible();
		resetFilter.click();
	}
	
	public void openCustomerDetails(String searchTerm) {
		evaluateJavascript("jQuery.noConflict();");
		element(listContainer).waitUntilVisible();
		List<WebElement> listElements = listContainer.findElements(By.cssSelector("tbody > tr"));

		theFor: for (WebElement elementNow : listElements) {
			String currentEmail = elementNow.findElement(By.cssSelector("*:nth-child(4)")).getText();
			WebElement currentLink = elementNow.findElement(By.cssSelector("*:nth-child(4)"));
			System.out.println("Current Email: " + currentEmail);
			if (currentEmail.trim().contentEquals(searchTerm)) {
				clickElement(currentLink);
				//currentLink.click();
				waitABit(1000);
				break theFor;
			}
		}
	}

	public void clickOnEditCustomers() {
		evaluateJavascript("jQuery.noConflict();");
		element(clickOnEdit).waitUntilVisible();
		clickElement(clickOnEdit);
	}
}
