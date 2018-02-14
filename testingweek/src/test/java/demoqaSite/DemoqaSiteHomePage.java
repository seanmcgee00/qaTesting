package demoqaSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoqaSiteHomePage {
	

	@FindBy(css= "#menu-item-141")
	private WebElement droppableButton;
	
	public void clickDroppablePage() {
		droppableButton.click();
		
	}

}
