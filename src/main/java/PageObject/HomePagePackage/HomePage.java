package PageObject.HomePagePackage;

import GenericLib.ObjectRepository;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;

/**
 * Created by t.mirasipally on 14-Feb-17.
 */
public class HomePage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;

    //PageElements
    static private By WelcomeField = By.id("Welcome");




    public static void VerifyHomePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        ExpectedLable("Verify that Home ia opened or not ?");
        if(SizeOfTheElement(driver,WelcomeField)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Home")){
                ActualLable("successfully verified Assert for Home Page ","Pass");
            }else{ActualLable(" Assert verification failed for Home Page ","Fail");}
        }else{ActualLable("Home page is not Loaded Properly","Fail");}
    }

}
