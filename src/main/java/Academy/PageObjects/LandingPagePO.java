package Academy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponents.AbstractComponents;

public class LandingPagePO extends AbstractComponents {

	WebDriver driver;
	
	public LandingPagePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent
		this.driver = driver; //The left driver is from this PO class, the right driver is from StandAloneTestAGAIN156
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	//WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
		//List<WebElement> allSuggestions = driver.findElements(By.cssSelector(".SuggestionList_suggestionsItem__4tPUf"));

		
		//PageFactory
			@FindBy(css="#keywords")
			WebElement searchBar;
			
			@FindBy(css=".SuggestionList_suggestionsItem__4tPUf")
			List<WebElement> suggestionList;
			
			
			
			//By
			By suggestionListBy = By.cssSelector(".SuggestionList_suggestionsList__X43pf");
			
			
			//Action Methods
			
			public void searchProduct(String wantedProduct)
			{
				searchBar.sendKeys(wantedProduct);
			}
			
			public List<WebElement> getSuggestionList()
			{
				waitForElementToAppear(suggestionListBy);
				return suggestionList;
			}
			
			public WebElement wantedSuggestion(String wantedCategory)
			{
				WebElement myCategory = getSuggestionList().stream().filter(oneResult -> oneResult.findElement(By.cssSelector("span")).getText().contains(wantedCategory))
						.findFirst().orElse(null);
				return myCategory;
			}
			
			public void selectWantedSuggestion(String wantedCategory)
			{
				wantedSuggestion(wantedCategory).click();
			}
			
			public void goTo()
			{
				driver.get("https://kupujemprodajem.com/");
			}
			
}
