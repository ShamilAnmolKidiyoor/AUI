package aui;

import java.util.concurrent.TimeUnit;

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

public class Mouse_Actions {

public static void main(String[] args) throws InterruptedException   
	
	
	{			
	/** 
	 * Click and Hold action with mouse
	 */
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();      
		driver.manage().window().maximize();
        driver.get("http://www.theautomatedtester.co.uk/demo1.html");	
        WebElement ele1 = driver.findElement(By.id("tutorial"));
        Point value = ele1.getLocation();
        System.out.println(value);
        Actions obj = new Actions(driver).clickAndHold(ele1).moveByOffset(-300, -300).moveByOffset(300, 10).moveByOffset(100, 300)
        .release(ele1);
        obj.perform();
        
        /**
         * Drag and Drop action with mouse
         * @author Hansul Fathima
         */
        
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        //Element which needs to drag.    		
    	WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
     
        //Element on which need to drop.		
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					
     		
        //Using Action class for drag and drop.		
        Actions act=new Actions(driver);					

        //Dragged and dropped.		
        act.dragAndDrop(From, To).build().perform();		
        
        /** Mouse House with mouse **/
        
        driver.get("https://www.amazon.in/");
         WebElement SignIn = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
         WebElement TryPremium = driver.findElement(By.xpath("//*[@id='nav-link-prime']"));
         WebElement YourList = driver.findElement(By.xpath("//*[@id='nav-link-wishlist']"));
         Thread.sleep(3000);
         new Actions(driver).moveToElement(SignIn).build().perform();
         Thread.sleep(3000);
         new Actions(driver).moveToElement(TryPremium).build().perform();
         Thread.sleep(3000);
         new Actions(driver).moveToElement(YourList).build().perform();
         
         /**  To scroll down the web page by pixel. **/
         
         
         JavascriptExecutor js = (JavascriptExecutor) driver;

         // Launch the application		
         driver.get("http://demo.guru99.com/test/guru99home/");

         //To maximize the window. This code may not work with Selenium 3 jars. If script fails you can remove the line below		
         driver.manage().window().maximize();
         Thread.sleep(3000);
         // This  will scroll down the page by  1000 pixel vertical		
         js.executeScript("window.scrollBy(0,1000)");
         Thread.sleep(3000);
         
         /**Horizontal scroll on the web page. **/
         
         driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");

         WebElement Element = driver.findElement(By.linkText("VBScript"));
         Thread.sleep(3000);
         //This will scroll the page Horizontally till the element is found		
         js.executeScript("arguments[0].scrollIntoView();", Element);
         Thread.sleep(3000);
         
         /**Right Click on the web page. **/
         
         driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
         
         Actions action = new Actions(driver);
         By locator = By.cssSelector(".context-menu-one");
                        //Wait for the element. Used Explicit wait
                        WebDriverWait wait = new WebDriverWait(driver, 5);
                        wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
                        WebElement rightClickElement=driver.findElement(locator);
                        //contextClick() method to do right click on the element
                        action.contextClick(rightClickElement).build().perform();
                        WebElement getCopyText =driver.findElement(By.cssSelector(".context-menu-icon-copy"));
                        //getText() method to get the text value
                        String GetText = getCopyText.getText();
                        //To print the value
                        System.out.println(GetText);
        
      /**Double Click on the web page. **/
        driver.get("http://api.jquery.com/dblclick/");
      //As per the above URL we need to switch to frame. The targeted element is in the frame
        driver.switchTo().frame(0);
                       //Create the object 'action' 
        Actions action1 = new Actions(driver);
        //Find the targeted element
        WebElement ele = driver.findElement(By.cssSelector("html>body>div"));
                       //Here I used JavascriptExecutor interface to scroll down to the targeted element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
                       //used doubleClick(element) method to do double click action
        Thread.sleep(3000);
        action1.doubleClick(ele).build().perform();

        /**Keyboard Actions on the web page. **/
        
        driver.get("http://www.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     // Waiting 30 seconds for an element to be present on the page, checking
     // for its presence once every 5 seconds.
     Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
         .withTimeout(30, TimeUnit.SECONDS)
         .pollingEvery(5, TimeUnit.SECONDS)
         .ignoring(NoSuchElementException.class);
     WebElement foo = wait1.until(new Function<WebDriver, WebElement>() 
     {
       public WebElement apply(WebDriver driver) {
       return driver.findElement(By.name("q"));
     }
     });// Waiting 30 seconds for a
        //WebElement text = driver.findElement(By.name("q"));
        Actions make  = new Actions(driver);
        Action kbEvents = make.keyDown(foo, Keys.SHIFT).sendKeys("Java Code Geeks")
       .keyUp(foo, Keys.SHIFT).doubleClick().contextClick().build();
        kbEvents.perform();
        
        
     }
}
