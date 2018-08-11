package aui;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickandHoldTheAutomatedTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/**
 * @author hansul fathima
 */
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();      
		driver.manage().window().maximize();
        driver.get("http://www.theautomatedtester.co.uk/demo1.html ");	
        WebElement ele1 = driver.findElement(By.id("tutorial"));
        Point value = ele1.getLocation();
        System.out.println(value);
        Actions obj = new Actions(driver).clickAndHold(ele1).moveByOffset(-300, 300).moveByOffset(300, 10).moveByOffset(100, 300).moveByOffset(300, 900)
        .release(ele1);
        obj.perform();
		
		
	}

}
