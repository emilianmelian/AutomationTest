package com.steps.backend.customer;

import com.steps.AbstractSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.data.frontend.CustomerFormModel;
import com.tools.utils.SerenitySessionUtils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Title;

public class CustomerDetailsBackendSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	
	@Step
	public void openCustomerSubMenu(){
		navigationPage().openCustomerSubMenu("account");
	}
	
	@Title("Validate Customer Details")
	@StepGroup
	public void validateCustomerDetails() {
		CustomerFormModel customerModel=SerenitySessionUtils.getFromSession(SerenityKeyConstants.CUSTOMER_MODEL);

		validateFirstName(customerModel.getFirstName());
		validateLastName(customerModel.getLastName());
		validateEmailAddress(customerModel.getEmailName());
	}

	@Step
	public void validateFirstName(String customerModel) {
		customerDetailsHomePage().validateFirstName(customerModel);
	}

	@Step
	public void validateLastName(String customerModel) {
		customerDetailsHomePage().validateLastName(customerModel);
	}
	
	@Step
	public void validateEmailAddress(String customerModel) {
		customerDetailsHomePage().validateEmailAddress(customerModel);
	}
}
