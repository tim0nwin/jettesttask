package testtaskpak;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String args[]){
		//WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://lobster.media/");
     
        try{
			HomePage mainPage =  new HomePage(driver);
	        
	        System.out.print("First loaded page. SignUp visibility test: ");
	        if (mainPage.isSignUpVisible()) 
	        	System.out.println("Failed. SignUpForm is displayed.");
	        else 
	        	System.out.println("Passed.");
	        
	        mainPage.signUpClick();
	        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS); //not good, but quick
	        
	        System.out.print("SignUp button click. SignUp visibility test: ");
	        if (!mainPage.isSignUpVisible()) 
	        	System.out.println("Failed. SignUpForm is not displayed.");
	        else 
	        	System.out.println("Passed.");
	       	
	        String[] ivEmails = {"xxx", "xxx@xxx", "xxx@xxx."};
	        for (String s:ivEmails){
	        	System.out.print("Email field. Enter invalid email " + s + ": ");
	        	mainPage.setEmail(s);
	        	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS); //not good, but quick
	        	if (mainPage.isEmailErrorMessageDisplayed())
	        		System.out.println("Passed.");
	        	else 
	        		System.out.println("Failed. Error message is not displayed");
	        }
	        
        }catch(Exception e){e.printStackTrace();}
    }
}
