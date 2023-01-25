package Academy.KP18012023;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup(); // WebDriver manager for invoking the chromedriver that is not on our local machine
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://kupujemprodajem.com/");
		
		
		String wantedProduct = "Samsung";
		driver.findElement(By.cssSelector("#keywords")).sendKeys(wantedProduct);
		
		//Explicit wait - define the object of the class
				WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
				w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SuggestionList_suggestionsList__X43pf")));
		
				String wantedCategory = "Mobilni telefoni";
		List<WebElement> allSuggestions = driver.findElements(By.cssSelector(".SuggestionList_suggestionsItem__4tPUf"));
		WebElement myCategory = allSuggestions.stream().filter(oneResult -> oneResult.findElement(By.cssSelector("span")).getText().contains(wantedCategory))
		.findFirst().orElse(null);
		myCategory.click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Banner33_banner33__nUE23")));
		
		WebElement searchBradcrumbs = driver.findElement(By.cssSelector(".BreadcrumbHolder_breadcrumbHolder__HPbVd"));
		String one = searchBradcrumbs.findElement(By.cssSelector("a:nth-child(2)")).getText();
		String two = searchBradcrumbs.findElement(By.cssSelector("a:nth-child(3)")).getText();
		System.out.println(one);
		System.out.println(two);
		
		Assert.assertEquals(one, wantedCategory);
		Assert.assertEquals(two, wantedProduct);
		
		//Filter and sort functionalities
		driver.findElement(By.cssSelector("section button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Primeni filtere']")));
		driver.findElement(By.cssSelector(".Button_base__Pz8U1.ButtonPrimaryBlue_primaryBlue__Uz5k1")).click();
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sortiraj']")));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='button'] button[class*='ButtonTertiary_tertiary__dEng0']")));
		driver.findElement(By.cssSelector("div[role='button'] button[class*='ButtonTertiary_tertiary__dEng0']")).click();
		driver.findElement(By.cssSelector(".Sort_orderItem__SKNP7:nth-child(2)")).click();
		
		//Make a list of all prices
		Thread.sleep(2000);
		List<WebElement> allPrices = driver.findElements(By.cssSelector(".AdItem_price__k0rQn"));
		for(int i=0;i<allPrices.size();i++)
		{
			String singlePrice = allPrices.get(i).getText();
			System.out.println(singlePrice);
			String[] splitted01 = singlePrice.split(",");
			System.out.println(splitted01[0]);
		}
		
		
	}

	 
	
}
