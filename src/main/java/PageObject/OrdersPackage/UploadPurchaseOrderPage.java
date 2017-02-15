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
public class UploadPurchaseOrderPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By POHeading = By.xpath("//td[@class='ListHeader'][contains(text(),'UPLOAD PURCHASE ORDER')]");


    public static boolean VerifyUploadPurchaseOrderPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that Upload Purchase Order Page is opened or not ?");
        if(SizeOfTheElement(driver,POHeading)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Upload Purchase Order")){
                Status=true;
                ActualLable("successfully verified Assert for Upload Purchase Order Page","Pass");
            }else{ActualLable(" Assert verification failed for Upload Purchase Order Page","Fail");}
        }else{ActualLable("Upload Purchase Order Page is not Loaded Properly","Fail");}
        return Status;
    }
}
