package Academy.KP18012023;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.PageObjects.LandingPagePO;
import Academy.PageObjects.ResultsPagePO;
import Academy.TestComponents.BaseTest;
import Academy.TestComponents.BaseTest02;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest08 extends BaseTest02 {

	
	
	@Test(dataProvider="getData", groups={"Search"})
	public void searcProduct(HashMap<String, String> input) throws InterruptedException, IOException
	{

		
		//String wantedProduct = "Samsung";
		//LandingPagePO lppo =  new LandingPagePO(driver);
		//LandingPagePO lppo =  launchApplication();
		//lppo.goTo();
		
		lppo.searchProduct(input.get("wantedProductHM"));

		//String wantedCategory = "Mobilni telefoni";
		
		lppo.selectWantedSuggestion(input.get("wantedCategoryHM"));
		
		ResultsPagePO rppo = new ResultsPagePO(driver);
		String one = rppo.verifyBreadcrumbCategory();
		String two = rppo.verifyBreadcrumbProduct();
		
		Assert.assertEquals(one, input.get("wantedCategoryHM"));
		Assert.assertEquals(two, input.get("wantedProductHM"));
		
		
		//Filter and sort functionalities
		rppo.clickSectionButton();
		rppo.closeBanner();
		rppo.clickSortButton();
		rppo.sortSkuplje();

		
		//Make a list of all prices
		int ratio = 117;
		
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
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
	/*	HashMap<String, String> hm01 = new HashMap<String, String>();
		hm01.put("wantedProductHM", "Samsung");
		hm01.put("wantedCategoryHM", "Mobilni telefoni");
		
		HashMap<Object, Object> hm02 = new HashMap<Object, Object>();
		hm02.put("wantedProductHM", "Apple iPhone");
		hm02.put("wantedCategoryHM", "Mobilni telefoni");*/
		
		
		List<HashMap<String, String>> data = getJsonDataToHashMap(System.getProperty("user.dir") + "\\src\\test\\java\\Academy\\Data\\Search.json");
		//Now we have all the data we need in one json file and for this TC we state the path of this josn file
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
		//return new Object[][] {{hm01}, {hm02}};
		
		//return new Object[][] {{"Samsung", "Mobilni telefoni"}, {"Apple iPhone", "Mobilni telefoni"}};
	}
	
 
	
}
