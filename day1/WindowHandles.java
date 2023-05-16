package week4Assignment.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		//Declare the driver
		ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
		//Load the URL
	    driver.get("https://leafground.com/window.xhtml");
	    //Provide duration of waiting time for overall process
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[text()='Open']")).click();
	    //Declare WindowHandles in Set to avoid duplicates
	    Set<String> windowHandle = driver.getWindowHandles();
	    //Declare WindowHandles from Set to List 
	    List<String> newWindow=new ArrayList<String>(windowHandle);
	    //Switch the control from first window to second window
	    driver.switchTo().window(newWindow.get(1));
	    //Print the Title	    
	    System.out.println("Open the Window Name is "+driver.getTitle());
	    //Close the current window
	    driver.close();
	    //Switch the control from second window to first window
	    driver.switchTo().window(newWindow.get(0));
	    //Open Multiple Windows
	    driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
	    Set<String> multipleWindow = driver.getWindowHandles();
	    List<String> multiWindows=new ArrayList<String>(multipleWindow);
	    //Find the Number of Opened Tabs/windows
	    System.out.print("Number of Opened Tabs ");
	    System.out.println(multiWindows.size()-1);
	    driver.switchTo().window(newWindow.get(0));
	    //Close all the opened windows except main window     
        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c' and text()='Close Windows']")).click();
        Set<String> closeWindow = driver.getWindowHandles();
	    List<String> closeWindows=new ArrayList<String>(closeWindow);
	    for(int i=closeWindows.size()-1;i>1;i--)
	    {
	    	driver.switchTo().window(closeWindows.get(i));
	    	Thread.sleep(1000);
	    	driver.close();
	    }
	    driver.switchTo().window(newWindow.get(0));
	    //Open the window with delay 
	    driver.findElement(By.xpath("//span[@class='ui-button-text ui-c' and text()='Open with delay']")).click();
	    Set<String> delayWindow = driver.getWindowHandles();
	    List<String> waitforWindows=new ArrayList<String>(delayWindow);
	    driver.switchTo().window(waitforWindows.get(0));
	    Thread.sleep(1000);
	    //Close all the windows
	    driver.quit();
   }
}



