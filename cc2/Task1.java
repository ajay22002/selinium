package cc1.cc2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
	WebDriver driver;
  @Test
  public void Ecommerce() {
	  WebDriverManager.edgedriver().setup();
	  WebDriver driver=new EdgeDriver();
	  
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	  
	  driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"contents_wrapper\"]")).isDisplayed();
	  
	  System.out.println("Cart Page Displayed");
	  driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form")).isDisplayed();
	  
	  driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("yogesh");
	  driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("369");
	  driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("630561");
	  driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]")).isDisplayed();
	  
	  System.out.println("Summary Page Displayed");
	   
	  System.out.println("Product Name : "+driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText());
	  System.out.println("Price Amount : "+driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText());
	  
	  String title=driver.getTitle();
	  
	  if(title.equals("Swag Labs"))
	  {
		  System.out.println("Title Verified");
	  }
	  else {
		  System.out.println(driver.getTitle());
	  }
	
	  String url=driver.getCurrentUrl();
	  if(url.equals("https://www.saucedemo.com/checkout-step-two.html"))
	  {
		  System.out.println("URL Verified");
	  }
	  else
	  {
		  System.out.println("Wrong Url");
	  }
	  
	  driver.quit();
  }
}
