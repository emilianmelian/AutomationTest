package com.pages.backend.customer.details;

import org.openqa.selenium.WebElement;

import com.pages.AbstractPage;
import com.tools.CustomVerification;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CustomerDetailsPage extends AbstractPage {

	@FindBy(css = "fieldset > div:nth-child(4) .admin__field-control input")
	private WebElement firstName;
	
	@FindBy(css = "fieldset > div:nth-child(6) .admin__field-control input")
	private WebElement lastName;
	
	@FindBy(css = "fieldset > div:nth-child(8) .admin__field-control input")
	private WebElement emailAddress;

	public void validateFirstName(String firstname) {
		evaluateJavascript("jQuery.noConflict();");
		String valueJQuery = getValueByJQuery("fieldset > div:nth-child(4) .admin__field-control input");
		element(firstName).waitUntilVisible();
		CustomVerification.verifyTrue("Failure: Firstname field does not contains correct first name, expected:"
				+ firstname + " -grabbed: " + valueJQuery, valueJQuery.contains(firstname));
	}

	public void validateLastName(String lastname) {
		evaluateJavascript("jQuery.noConflict();");
		String valueJQuery = getValueByJQuery("fieldset > div:nth-child(6) .admin__field-control input");
		element(lastName).waitUntilVisible();
		CustomVerification.verifyTrue("Failure: Lastname field does not contains correct last name, expected:"
				+ lastname + " -grabbed: " + valueJQuery, valueJQuery.contains(lastname));
	}

	public void validateEmailAddress(String emailName) {
		evaluateJavascript("jQuery.noConflict();");
		String valueJQuery = getValueByJQuery("fieldset > div:nth-child(8) .admin__field-control input");
		element(emailAddress).waitUntilVisible();
		CustomVerification.verifyTrue("Failure: EmailAddress field does not contains correct email address, expected:"
				+ emailName + " -grabbed: " + valueJQuery, valueJQuery.contains(emailName));
		
	}
}
