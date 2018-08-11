/*package aui;

public class PhpTravels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}}*/

package aui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;

public class PhpTravelsMouseHover {

private static Alert alert;

public static void main(String[] args) throws InterruptedException   
	
	
	{			
	/** 
	 * Click and Hold action with mouse
	 */
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();      
		driver.manage().window().maximize();
        driver.get("http://phptravels.com/demo/");	
 Thread.sleep(8000);
        Alert clicked = driver.switchTo().alert();
	     Thread.sleep(3000);
		 clicked.accept();
		 
        WebElement ele1 = driver.findElement(By.className("lvl-1"));
        
      
        Point value = ele1.getLocation();
        System.out.println(value);
        new Actions(driver).moveToElement(ele1).build().perform();
        
        WebElement ele2 = driver.findElement(By.xpath("//*[text()='Tours Module']"));
        ele2.click();
	}
}