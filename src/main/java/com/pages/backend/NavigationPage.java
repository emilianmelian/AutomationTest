package com.pages.backend;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.interfaces.NavigationPageInterface;
import com.pages.AbstractPage;

/**
 * @author emilian
 *
 */
public class NavigationPage extends AbstractPage implements NavigationPageInterface {

	public void dismissPopUp() {
		WebElement popUpWindow = getDriver().findElement(By.cssSelector(element_popUpWindow));

		evaluateJavascript("jQuery.noConflict();");
		element(popUpWindow).waitUntilVisible();
		popUpWindow.click();
		waitABit(1000);
	}

	public boolean isDismissPopPresent() {
		return getDriver().findElements(By.cssSelector(".modal-header button")).size() > 0;
	}

	public void openMenu(String menuName) {

		List<WebElement> listmenu = getDriver().findElements(By.cssSelector(element_listmenu));

		for (WebElement menu : listmenu) {
			if (menu.getText().toLowerCase().contains(menuName)) {
				menu.click();
			}
		}
	}

	public void openAllCustomers() {
		WebElement allCustomers = getDriver().findElement(By.cssSelector(element_allCustomers));

		element(allCustomers).waitUntilVisible();
		allCustomers.click();
		waitABit(10000);
		element(element_loadingSpinner).waitUntilNotVisible();
		element(element_loadingSpinner).waitUntilNotVisible();
	}

	public void clickOnFilters() {
		evaluateJavascript("jQuery.noConflict();");

		WebElement collapseFilters = getDriver().findElement(By.cssSelector(element_collapseFilters));
		WebElement loadingSpinner = getDriver().findElement(By.cssSelector(element_loadingSpinner));

		element(loadingSpinner).waitUntilNotVisible();
		element(collapseFilters).waitUntilVisible();
		Actions actions = new Actions(getDriver());
		actions.moveToElement(collapseFilters).click().perform();
	}

	public void openCustomerSubMenu(String subMenuName) {
		evaluateJavascript("jQuery.noConflict();");
		List<WebElement> customerSubMenu = getDriver().findElements(By.cssSelector(element_customerSubMenu));

		element(customerSubMenu.get(0)).waitUntilVisible();
		for (WebElement subMenu : customerSubMenu) {
			if (subMenu.getText().toLowerCase().contains(subMenuName)) {
				subMenu.click();
			}
		}

	}
}
