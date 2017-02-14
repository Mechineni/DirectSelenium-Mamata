package PageObject;

import GenericLib.ActionKeywords;
import GenericLib.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.VerifyElementExistence;
import static GenericLib.ActionKeywords.clickOnElement;
import static GenericLib.ActionKeywords.sendInputData;


/**
 * Created by t.mirasipally on 13-Feb-17.
 */
public class LandingPage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By EmailIdField = By.id("UserName");
    static private By PasswordField = By.id("Password");
    static private By LogInButton = By.xpath("//input[@value='Login'][@type='SUBMIT']");




    public static void LogInFunctionality(WebDriver driver) throws InterruptedException, IOException {
        obje.repository(driver);
        if(VerifyElementExistence(driver,EmailIdField).size()>0) {
            sendInputData(driver,EmailIdField).sendKeys(obje.obj.getProperty("email"));
            sendInputData(driver,PasswordField).sendKeys(obje.obj.getProperty("password"));
            Thread.sleep(1000);
            clickOnElement(driver,LogInButton);
        }else{}
    }
}
