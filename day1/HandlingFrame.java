package week4Assignment.day1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame {

	public static void main(String[] args) {
		//Declare the driver
		ChromeDriver driver=new ChromeDriver();
		//Load the URL
	    driver.get("https://www.leafground.com/frame.xhtml");
	    //maximize the browser
	    driver.manage().window().maximize();
	    //Provide duration of waiting time for overall process
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //Switch control from driver to Frame
		driver.switchTo().frame(0);
		//Click the button
	    driver.findElement(By.xpath("(//button[@id='Click'])[1]")).click();
	    //Print the return Message
	    String returnMsg = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
	    System.out.println(returnMsg);
	    //Switch one frame into another frame
	    driver.switchTo().parentFrame();
	    driver.switchTo().frame(2);
	    driver.switchTo().frame("frame2");
	    driver.findElement(By.xpath("//button[text()='Click Me']")).click();
	    //Print the return Message
	    String DisplayMsg = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
	    System.out.println(DisplayMsg);
	    //Close the Frames
	    driver.switchTo().defaultContent();
	    //Find Numeber of Frames
        List<WebElement> findFrames=driver.findElements(By.tagName("iframe"));
        System.out.println("Number of Frames  "+findFrames.size());
       }

}
