package PageObject.OrdersPackage;

import GenericLib.ObjectRepository;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.GetPageTitle;
import static GenericLib.ActionKeywords.SizeOfTheElement;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;

/**
 * Created by t.mirasipally on 15-Feb-17.
 */
public class BT_ServiceRequestsPage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By BTServiceHeading = By.xpath("//td[@class='ListHeader'][contains(text(),'SERVICE REQUEST SEARCH')]");


    public static boolean VerifyBTSearviceRequestPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that Service Request Search Page is opened or not ?");
        if(SizeOfTheElement(driver,BTServiceHeading)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Service Request Search")){
                Status=true;
                ActualLable("successfully verified Assert for Service Request Search Page","Pass");
            }else{ActualLable(" Assert verification failed for Service Request Search Page","Fail");}
        }else{ActualLable("Service Request Search Page is not Loaded Properly","Fail");}
        return Status;
    }

}
