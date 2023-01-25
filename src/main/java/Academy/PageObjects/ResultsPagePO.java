package Academy.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponents.AbstractComponents;

public class ResultsPagePO extends AbstractComponents {

	WebDriver driver;
	
	public ResultsPagePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent
		this.driver = driver; //The left driver is from this PO class, the right driver is from StandAloneTestAGAIN156
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	//WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
		//List<WebElement> allPrices = driver.findElements(By.cssSelector(".AdItem_price__k0rQn"));


		
		//PageFactory
			@FindBy(css=".BreadcrumbHolder_breadcrumbHolder__HPbVd")
			WebElement breadcrumb;
			
			@FindBy(css="section button")
			WebElement sectionButton;
			
			@FindBy(css=".Button_base__Pz8U1.ButtonPrimaryBlue_primaryBlue__Uz5k1")
			WebElement closeBannerButton;
			
			@FindBy(css="div[role='button'] button[class*='ButtonTertiary_tertiary__dEng0']")
			WebElement sortButton;
			
			@FindBy(css=".Sort_orderItem__SKNP7:nth-child(2)")
			WebElement sortSkupljeButton;
			
			@FindBy(css=".AdItem_price__jUgxi") //div[class*='AdItem_price__']
			List<WebElement> allPrices;
			
			
			
			
			
			//By
			By bannerBy = By.cssSelector(".Banner33_banner33__nUE23");
			By oneBy = By.cssSelector("a:nth-child(2)");
			By twoBy = By.cssSelector("a:nth-child(3)");
			By primeniBy =By.xpath("//span[text()='Primeni filtere']");
			By sortBy = By.cssSelector("div[role='button'] button[class*='ButtonTertiary_tertiary__dEng0']");
			
			
			//Action Methods
			
			public WebElement getBreadcrumb()
			{
				waitForElementToAppear(bannerBy);
				return breadcrumb;
			}
			
			
			public String wantedBreadcrumbCategory(By findby)
			{
				String breadcrumbCategory = getBreadcrumb().findElement(findby).getText();
				return breadcrumbCategory;
			}
			
			public String wantedBreadcrumbProduct(By findby)
			{
				String breadcrumbProduct = getBreadcrumb().findElement(findby).getText();
				return breadcrumbProduct;
			}
			
			public String verifyBreadcrumbCategory()
			{
				String one = wantedBreadcrumbCategory(oneBy);
				System.out.println(one);
				return one;
			}
			
			public String verifyBreadcrumbProduct()
			{
				String two = wantedBreadcrumbProduct(twoBy);
				System.out.println(two);
				return two;
			}
			
			
			public void clickSectionButton()
			{
				sectionButton.click();
			}
			
			public void closeBanner()
			{
				waitForElementToAppear(primeniBy);
				closeBannerButton.click();
			}
			
			public void clickSortButton()
			{
				waitForElementToAppear(sortBy);
				sortButton.click();
			}
			
			public void sortSkuplje()
			{
				sortSkupljeButton.click();
			}
			
			public List<WebElement> getAllPricesList()
			{
				return allPrices;
			}
			
			public ArrayList<Integer> methodJK(int ratio) throws InterruptedException
			{
				Thread.sleep(2000);
				ArrayList<Integer> a = new ArrayList<Integer>();
				//int ratio = 118;
				
				for(int i=0;i<getAllPricesList().size();i++)
				{
					String singlePrice = getAllPricesList().get(i).getText();
					System.out.println(singlePrice);
						if(singlePrice.contains("€"))
						{
							String[] splitted01 = singlePrice.split(",");
							System.out.println(splitted01[0]);
							try{
								//Replace .
								String replace01 = splitted01[0].replace(".", "");
					            int number = Integer.parseInt(replace01);
					            System.out.println(number);
					            a.add(number);
					        }
					        catch (NumberFormatException ex){
					            ex.printStackTrace();
					        }
						}
						else
						{
							String[] splitted02 = singlePrice.split(" ");
							System.out.println(splitted02[0]);
							try{
								//Replace .
								String replace02 = splitted02[0].replace(".", "");
					            int number = Integer.parseInt(replace02);
					            //Convert rsd into eur
					            int euro = number/ratio;
					            System.out.println(euro);
					            a.add(euro);
					        }
					        catch (NumberFormatException ex){
					            ex.printStackTrace();
					        }
						}
					
				}
				return a;
			}
			
			
			public int validateSortingFunctionality(int ratio) throws InterruptedException
			{
				int sum = 0;
				
				for(int m=0;m<methodJK(ratio).size()-1;m++)
				{
					int first = methodJK(ratio).get(m);
					int second = methodJK(ratio).get(m+1);
					
							if(first>=second)
							{
								System.out.println("Sorting works as expected");
								sum=sum+1;
							}
							else
							{
								System.out.println("Sorting does not work as expected");
								break;
							}
					
				}
				return sum;
			}
			
			
			
			
			
			public int somethingJK(int ratio) throws InterruptedException
			{
				Thread.sleep(2000);
				ArrayList<Integer> a = new ArrayList<Integer>();
				//int ratio = 118;
				
				List<WebElement> allPrices = driver.findElements(By.cssSelector(".AdItem_price__jUgxi"));
				for(int i=0;i<allPrices.size();i++)
				{
					String singlePrice = allPrices.get(i).getText();
					System.out.println(singlePrice);
						if(singlePrice.contains("€"))
						{
							String[] splitted01 = singlePrice.split(",");
							System.out.println(splitted01[0]);
							try{
								//Replace .
								String replace01 = splitted01[0].replace(".", "");
					            int number = Integer.parseInt(replace01);
					            System.out.println(number);
					            a.add(number);
					        }
					        catch (NumberFormatException ex){
					            ex.printStackTrace();
					        }
						}
						else
						{
							String[] splitted02 = singlePrice.split(" ");
							System.out.println(splitted02[0]);
							try{
								//Replace .
								String replace02 = splitted02[0].replace(".", "");
					            int number = Integer.parseInt(replace02);
					            //Convert rsd into eur
					            int euro = number/ratio;
					            System.out.println(euro);
					            a.add(euro);
					        }
					        catch (NumberFormatException ex){
					            ex.printStackTrace();
					        }
						}
					
				}
				
			/*	System.out.println("Here it starts");
				for(int j=0;j<a.size();j++)
				{
					System.out.println(a.get(j));
				}
				*/
				
				//Compare every value with the following one
				int sum = 0;
				
				for(int m=0;m<a.size()-1;m++)
				{
					int first = a.get(m);
					int second = a.get(m+1);
					
							if(first>=second)
							{
								System.out.println("Sorting works as expected");
								sum=sum+1;
							}
							else
							{
								System.out.println("Sorting does not work as expected");
								break;
							}
					
				}
				return sum;
			}
			
			
			
			
			
}
