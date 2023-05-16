package week4Assignment.day1;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class BuyTheValueAssign {

	public static void main(String[] args) throws InterruptedException {
		//Declare the driver
		ChromeDriver driver=new ChromeDriver();	 
	    //Load the URL
	    driver.get(" https://buythevalue.in/");
	    //maximize the browser
	    driver.manage().window().maximize();
	    //Provide duration of waiting time for overall process
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //Click on first product
	    driver.findElement(By.xpath("//div[@class='product-image']//a")).click();
	    //Provide control from driver to frame	  
	    driver.switchTo().frame(1);
	    //Declare xpath for SVG(Scalable Vector Graphics)element to open
	    driver.findElement(By.xpath("//*[local-name()='svg']/*[local-name()='path' and @fill='#fff']")).click();
	    //Switch one frame into another frame
	    driver.switchTo().frame("ShopifyChat");
	    //Declare xpath for SVG(Scalable Vector Graphics)element to close
	    driver.findElement(By.xpath("//*[local-name()='svg' and @fill='none']/*[local-name()='path' and @fill='currentColor']")).click();
	    driver.switchTo().parentFrame();
	    //Declare xpath to close popup window it take some time to close
	    driver.findElement(By.xpath("//div[@id='com-hextom-smartpushmarketing-popup-close-popup-push']")).click();
	    driver.switchTo().defaultContent();
	    //Declare Pincode
	    driver.findElement(By.xpath("//input[@name='wk_zipcode']")).sendKeys("600086",Keys.ENTER);
	    //Enter Click Button
	    driver.findElement(By.xpath("//input[@class='btn']")).click();
	    Thread.sleep(1000);
	    //Click Add to Cart Button
	    driver.findElement(By.xpath("//button[@id='product-add-to-cart']")).click();
	    //Click on View Button 
	    WebElement viewButton = driver.findElement(By.xpath("//a[text()='View Cart']"));
	    driver.executeScript("arguments[0].click()",viewButton);
	    //Click on Checkout Button
	    WebElement checkoutBtn = driver.findElement(By.xpath("//button[text()='Checkout']"));
		checkoutBtn.click();
		//Provide control to Alert
        Alert alert = driver.switchTo().alert();//ctrl+2
        //print the message from the dialog box
        String text = alert.getText();//ctrl+2
        System.out.println(text);
        //Action going to perform
        alert.accept();
    }
}