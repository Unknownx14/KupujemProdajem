package Academy.KP18012023;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.IOException;
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
import org.testng.annotations.Test;

import Academy.PageObjects.LandingPagePO;
import Academy.PageObjects.ResultsPagePO;
import Academy.TestComponents.BaseTest;
import Academy.TestComponents.BaseTest02;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest05 extends BaseTest02 {

	
	
	@Test(groups={"Search"})
	public void searcProduct() throws InterruptedException, IOException
	{

		
		String wantedProduct = "Samsung";
		//LandingPagePO lppo =  new LandingPagePO(driver);
		//LandingPagePO lppo =  launchApplication();
		//lppo.goTo();
		
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
