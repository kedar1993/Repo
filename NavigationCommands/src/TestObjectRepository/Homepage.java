package TestObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
public static WebElement element = null;
public static WebDriver driver;
 
    

	public static WebElement googleSearchBar(WebDriver driver2) {
		WebElement element = driver2.findElement(By.xpath("//input[@name='q']"));
       // List<WebElement> element1 = (List<WebElement>) element;
		return (WebElement) element;
	}


}