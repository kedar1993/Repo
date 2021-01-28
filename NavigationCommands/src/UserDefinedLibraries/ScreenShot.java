package UserDefinedLibraries;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//TAKING THE SCREEENSHOT

public class ScreenShot {
	public static void getScreenShot(WebDriver driver) {
		// TODO Auto-generated method stub
		String filename;
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		filename = new SimpleDateFormat("yyyyMMddhhmmss'.jpeg'").format(new Date());
			File destination = new File(
					"C:\\Users\\rajeswari\\eclipse-workspace\\NavigationCommands\\bin\\UserDefinedLibraries\\" + filename );
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}


	

}
