package aui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class POP_UP {

public static void main(String[] args) throws InterruptedException   
	
	
	{			
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();      
		driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo/");	
        Thread.sleep(4000);
        WebElement ele1 = driver.findElement(By.xpath("//*[text()='No Thanks']"));
        ele1.click();		
}
}