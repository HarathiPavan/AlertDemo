package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Launching the url
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		//The outer html of the frame is
		//	<iframe frameborder="0" id="iframeResult" name="iframeResult" allowfullscreen="true"></iframe>
		driver.switchTo().frame("iframeResult");
		//xpath of try it is : //button[text()='Try it']
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//the prompt window will be opened
		driver.switchTo().alert().sendKeys("Harathi");
		driver.switchTo().alert().accept();
		String actual_msg = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		String expected_msg = "Hello Harathi! How are you today?";
		if(actual_msg.equals(expected_msg))
			System.out.println("The test is passed");
		else
			System.out.println("The test is failed");
				
		driver.close();
	}

}
