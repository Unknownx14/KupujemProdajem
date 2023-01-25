package Academy.KP18012023;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Academy.PageObjects.LandingPagePO;
import Academy.PageObjects.ResultsPagePO;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest04 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup(); // WebDriver manager for invoking the chromedriver that is not on our local machine
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://kupujemprodajem.com/");
		
		
		String wantedProduct = "Samsung";
		LandingPagePO lppo =  new LandingPagePO(driver);
		
		lppo.searchProduct(wantedProduct);

		String wantedCategory = "Mobilni telefoni";
		
		lppo.selectWantedSuggestion(wantedCategory);
		
		ResultsPagePO rppo = new ResultsPagePO(driver);
		String one = rppo.verifyBreadcrumbCategory();
		String two = rppo.verifyBreadcrumbProduct();
		
		Assert.assertEquals(one, wantedCategory);
		Assert.assertEquals(two, wantedProduct);
		
		
		//Filter and sort functionalities
		rppo.clickSectionButton();
		rppo.closeBanner();
		rppo.clickSortButton();
		rppo.sortSkuplje();

		
		//Make a list of all prices
		int ratio = 118;
		
		//ArrayList<Integer> a = rppo.methodJK(ratio);
		//int sum =rppo.validateSortingFunctionality(ratio);
		int sum =rppo.somethingJK(ratio);

		
		//Assert.assertEquals(sum, a.size()-1);
		Assert.assertEquals(sum, rppo.getAllPricesList().size()-1);
		
		
		//Instead of manually entering the ratio, it could be derived from the website
		/*
		WebElement srednjiKurs = driver.findElement(By.xpath("//span[text()='sred']"));
		String iznosSrednjegKursa = driver.findElement(with(By.tagName("div")).below(srednjiKurs)).getText();
		System.out.println(iznosSrednjegKursa);
		*/
		
	}
 
	
}
