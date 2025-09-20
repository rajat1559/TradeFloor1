package AbstractFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {
	public WebDriver driver;
	public JavascriptExecutor js;
	public AbstractClass(WebDriver driver)
	{
		this.driver = driver;
		this.js = (JavascriptExecutor)driver;
	}
	
	
	public void zoom_Out()
	{
		js= (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50%';");
	}
	
	public void scroll_to_Point()
	{
		js.executeScript("window.scrollBy(0, 500);");
	}
	
	public void scroll_to_Bottom()
	{
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	
	}
	
	public void waitForWebElementToAppear(WebElement vis)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(vis));
	}
	
	public void waitForElementforInvisibility(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	

}
