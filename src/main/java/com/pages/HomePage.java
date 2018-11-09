package com.pages;

import com.interfaces.HomePageInterface;

public class HomePage extends AbstractPage implements HomePageInterface{
	
/*    @FindBy(css =HomePageInterface.loginButton )
    WebElementFacade loginButton;
*/
	

	
    public void clickLogin(){
    	//WebElement loginButton=getDriver().findElement(By.cssSelector(element_loginButton));
        getElement(element_loginButton).click();
    }
    
 
}
