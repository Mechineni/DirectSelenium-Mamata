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
public class ViewShipmentStatusDetailsPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By ViewShipmentHeading = By.xpath("//td[@class='ListHeader'][contains(text(),'View Shipment Status Details')]");


    public static boolean VerifyViewShipmentPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that View Shipment Status Page is opened or not ?");
        if(SizeOfTheElement(driver,ViewShipmentHeading)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("View Shipment Status Details")){
                Status=true;
                ActualLable("successfully verified Assert for View Shipment Status Page","Pass");
            }else{ActualLable(" Assert verification failed for View Shipment Status Page","Fail");}
        }else{ActualLable("View Shipment Status Page is not Loaded Properly","Fail");}
        return Status;
    }
}
