package week4Assignment.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlert {

	
		public static void main(String[] args)throws IOException, InterruptedException {
			//Declare the driver
			ChromeDriver driver=new ChromeDriver();
			//Load the URL
			driver.get("https://leafground.com/alert.xhtml");
			//maximize the browser
			driver.manage().window().maximize();
			//Provide duration of waiting time for overall process
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//click  to populate the alert
	        driver.findElement(By.xpath("(//span[text()='Show'])[1]")).click();
	        //Handle the  alert
	        Alert alert = driver.switchTo().alert();//ctrl+2
	        //print the message from the dialog box
	        String text = alert.getText();//ctrl+2
	        System.out.println(text);
	        //Action going to perform
	        alert.accept();
	        //verify the alert is clicked
	        String msg = driver.findElement(By.id("simple_result")).getText();
	        System.out.println(msg);
	        driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
	        Alert alert2 = driver.switchTo().alert();
	        String text2 = alert2.getText();
	        System.out.println(text2);
	        alert2.accept();
	        
	        driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
	        driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
	        
	       // String text3 = driver.findElement(By.id("confirm_result")).getText();
	        //System.out.println(text3);
	        
	       
	        //click the prompt alert
	        driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
	        //Handle the Alert
	        Alert alert5 = driver.switchTo().alert();
	        //to get the text from dialog
	        String text5 = alert5.getText();
	        System.out.println(text5);
	        //pass the input
	        alert5.sendKeys("RamyaMageshwaran");
	        alert5.accept();
	        driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).click();
	        driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c' and text()='Yes'])")).click();
	        driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();
	        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
	        driver.findElement(By.xpath("//a[contains(@class,'ui-dialog-titlebar-icon ui-dialog')][2]")).click();
	        driver.findElement(By.xpath("(//a[@aria-label='Close'])[3]")).click();
	        
	        driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
	        System.out.println(driver.findElement(By.xpath("//p[@class='m-0']")).getText());
	        WebElement closeButton = driver.findElement(By.xpath("(//a[@aria-label='Close'])[2]"));
			closeButton.click();
	       
     
	}

}
