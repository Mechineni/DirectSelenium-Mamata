package PageObject;

import GenericLib.ActionKeywords;
import GenericLib.ObjectRepository;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;
import static GenericLib.DataDriven.StepLable;


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




    public static void LogInFunctionality(WebDriver driver) throws InterruptedException, IOException, WriteException {
        StepLable("Log in to the application");
        obje.repository(driver);
        ExpectedLable("Check Landing page is loaded or not ?");
        if(SizeOfTheElement(driver,EmailIdField)>0) {
            ActualLable("Landing page is loaded properly","Pass");
            ExpectedLable("Provide User name in Email id field");
            sendInputData(driver,EmailIdField).sendKeys(obje.obj.getProperty("email"));
            ActualLable("User name entered successfully, Email id is : "+obje.obj.getProperty("email"),"Pass");
            ExpectedLable("Provide Password in Password field");
            sendInputData(driver,PasswordField).sendKeys(obje.obj.getProperty("password"));
            ActualLable("Password entered successfully, Password is : " +obje.obj.getProperty("password"),"Pass");
            waitForOneSec();
            ExpectedLable("Now Click on Login button");
            clickOnElement(driver,LogInButton);
            ActualLable("Successfully clicked on Log in button","Pass");
        }else{ActualLable("Failed to load Landing page","Fail");}
    }


}
