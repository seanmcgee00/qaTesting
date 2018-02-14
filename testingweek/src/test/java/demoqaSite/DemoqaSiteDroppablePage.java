package demoqaSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DemoqaSiteDroppablePage {
	@FindBy(css= "#ui-id-1")
	private WebElement defaultButton;
	
	@FindBy(css= "#ui-id-2")
	private WebElement acceptButton;
	
	@FindBy(css= "#ui-id-3")
	private WebElement preventPropButton;
	
	@FindBy(css= "#ui-id-4")
	private WebElement revertButton;
	
	@FindBy(css= "#ui-id-5")
	private WebElement shoppingButton;
	
	@FindBy(css= "#draggableview")
	private WebElement draggableviewDefault;
	
	@FindBy(css= "#droppableview")
	private WebElement droppableviewDefault;
	
	
	@FindBy(css= "#droppableview > p")
	private WebElement droppableDefaultResult;
	
	@FindBy(css= "#draggableaccept")
	private WebElement draggableviewAccept;
	
	@FindBy(css= "#droppableaccept")
	private WebElement droppableviewAccept;
	
	
	@FindBy(css= "#droppableaccept > p")
	private WebElement droppableAcceptResult;
	
	
	@FindBy(css= "#draggableprop")
	private WebElement draggableviewProp;
	
	@FindBy(css= "#droppableprop")
	private WebElement droppableviewProp;
	
	@FindBy(css= "#droppable-inner")
	private WebElement droppableviewPropInner;
	
	@FindBy(css= "#droppableprop2")
	private WebElement droppableviewProp2;
	
	@FindBy(css= "#droppable2-inner")
	private WebElement droppableviewPropInner2;
	
	
	@FindBy(css= "#droppableprop > p")
	private WebElement droppablePropR1;
	
	@FindBy(css= "#droppable-inner > p")
	private WebElement droppablePropR2;
	
	@FindBy(css= "#droppableprop2 > p")
	private WebElement droppablePropR3;
	
	@FindBy(css= "#droppable2-inner > p")
	private WebElement droppablePropR4;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickDefault() {
		defaultButton.click();
		
	}
	
	public void clickAccept() {
		acceptButton.click();
		
	}
	
	public void clickPrevent() {
		preventPropButton.click();
		
	}

	public void clickRevert() {
		revertButton.click();
		
	}
	
	public void clickShop() {
		shoppingButton.click();
		
	}
	
	public void defaultDragandDrop(WebDriver driver)
	{
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggableviewDefault, droppableviewDefault).perform();


	}
	
	public String defaultResult()
	{
		return droppableDefaultResult.getText();
	}
	
	
	public void acceptDragandDrop(WebDriver driver)
	{
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggableviewAccept, droppableviewAccept).perform();


	}
	
	public String acceptResult()
	{
		return droppableAcceptResult.getText();
	}
	
	
	
	public void propDragandDrop(WebDriver driver)
	{
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggableviewAccept, droppableviewAccept).perform();


	}
	
	public Boolean propResult()
	{
		Boolean check=true;
		return check;
	}
	
	
	
}
