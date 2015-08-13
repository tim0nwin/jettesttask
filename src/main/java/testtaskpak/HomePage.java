package testtaskpak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class HomePage {
  
    private WebDriver driver;
 
    
    @FindBy(className = "signup-link-header")
    private WebElement bSignUp;
    
    @FindBy(css = "body > div.il-dialog.signup-dialog.center.scrollable")
    private WebElement divSignUp;
    
    @FindBy(id = "email")
    private WebElement iEmail;
    
    @FindBy(css = "#new_user > div.formerror-instagram-email.formerror")
    private WebElement divEmailError;
    
    @FindBy(id = "password")
    private WebElement iPassword;
    
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
 
    public void signUpClick(){
    	bSignUp.click();
    }
    
    public boolean isSignUpVisible(){
    	return (divSignUp.isDisplayed());
    }
    
    public boolean isEmailErrorMessageDisplayed(){
    	return (divEmailError.isDisplayed());
    }
    
    public void setEmail(String s) throws InterruptedException{
    	iEmail.clear();
    	Thread.sleep(300);
    	iEmail.click();
    	iEmail.sendKeys(s);
    	iPassword.click();
    	Thread.sleep(300);
    }
    
}