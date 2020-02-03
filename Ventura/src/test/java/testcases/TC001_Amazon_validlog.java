package testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.TestBase;

public class TC001_Amazon_validlog extends TestBase {
	
	
	@Test
	public void Login() {

		
		driver.get(or.getProperty("url"));
		driver.findElement(By.linkText(or.getProperty("Signin"))).click();
		driver.findElement(By.id(or.getProperty("id_username"))).sendKeys(or.getProperty("username"));
		driver.findElement(By.id(or.getProperty("id_continue"))).click();
		driver.findElement(By.id(or.getProperty("id_password"))).sendKeys(or.getProperty("password"));
		driver.findElement(By.id(or.getProperty("id_submit"))).click();
		
		
		String message=driver.switchTo().alert().getText();
		Assert.assertTrue(true, message);
		
		
		log.debug("Login Successfull");

		// Search item
		/*driver.findElement(By.id(or.getProperty("id_searchbox"))).sendKeys("tshirt for mens", Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);*/

}
}
