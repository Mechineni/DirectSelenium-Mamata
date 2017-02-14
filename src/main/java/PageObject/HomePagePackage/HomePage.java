package PageObject.HomePagePackage;

import GenericLib.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;

/**
 * Created by t.mirasipally on 14-Feb-17.
 */
public class HomePage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;

    //PageElements
    static private By WelcomeField = By.id("Welcome");




    public static void VerifyHomePageAssert(WebDriver driver) throws InterruptedException, IOException {
        if(VerifyElementExistence(driver,WelcomeField).size()>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Home")){
                System.out.println("Successful");
            }else{System.out.println("Failed");}
        }else{}
    }

}
