package PageObject.HomePagePackage;

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
 * Created by t.mirasipally on 14-Feb-17.
 */
public class HomePage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;

    //PageElements
    static private By WelcomeField = By.id("Welcome");
    static private By MenusOnHomePage = By.xpath("//td[@id='DirectMenus']/ul/li/a");




    public static void VerifyHomePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        ExpectedLable("Verify that Home ia opened or not ?");
        if(SizeOfTheElement(driver,WelcomeField)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Home")){
                ActualLable("successfully verified Assert for Home Page ","Pass");
            }else{ActualLable(" Assert verification failed for Home Page ","Fail");}
        }else{ActualLable("Home page is not Loaded Properly","Fail");}
    }

    public static void SelectOptionsUnderMenus(WebDriver driver) throws InterruptedException, IOException, WriteException {
        StepLable("Verifying links");
        for (int i=0;i<=6;i++) {
            By No = By.xpath("//td[@id='DirectMenus']/ul/li["+i+"]/ul/li");
            int noOfOptions = SizeOfTheElement(driver,No);
            for(int j=0;j<=noOfOptions-1;j++) {
                ExpectedLable("Verify Link For");
                By MenusOnHomePage = By.xpath("(//td[@id='DirectMenus']/ul/li/a)["+i+"]");
                By OPtionsUnderMenu = By.xpath("(//td[@id='DirectMenus']/ul/li)["+i+"]/ul/li["+j+"]");
                MouseHoverActionPerform(driver, MenusOnHomePage, OPtionsUnderMenu);
                waitForTwoSec();
                String txt = GetPageTitle(driver);
                System.out.println(txt);
                ActualLable("successfully verified Assert for Home Page "+ txt,"Pass");

            }
        }

    }

}
