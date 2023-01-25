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

public class ErrorValidationTest extends BaseTest02 {

	
	
	@Test(groups={"ErrorValidations"})
	public void WrongCrededntials() throws InterruptedException, IOException
	{

		//@Before Method
		String userEmail = "unknownxjk@gmail.com";
		String userPassword = "kojikurac123";
		String expectedErrorMessage = "Nalog sa ovom e-mail adresom nije pronađen";
		
		driver.findElement(By.cssSelector(".MyKpMenu_loginButton___m443")).click();
		//wait for //.LoginModal_title__kSZeY    .LoginModal_loginButton__LifZm
		driver.findElement(By.cssSelector("#email")).sendKeys(userEmail);
		driver.findElement(By.cssSelector("#password")).sendKeys(userPassword);
		driver.findElement(By.cssSelector(".LoginModal_loginButton__LifZm")).click();
		
		String errorMessage = driver.findElement(By.cssSelector(".ErrorFormField_error__hm4lk")).getText();
		System.out.println(errorMessage);
		Assert.assertEquals(errorMessage, expectedErrorMessage);
		
		
		
	}
 
	
}
