package PageObject.QuotesPackage;

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
public class CreateQuoteGAP_IAP {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By GAP_IAPQuotesHeadding = By.xpath("//td[@class='ListHeader'][contains(text(),'CREATE QUOTE')]");




    public static boolean VerifyCreateQuoteGAPPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that Create Quote GAP_IAP page is opened or not ?");
        if(SizeOfTheElement(driver,GAP_IAPQuotesHeadding)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Create Quote")){
                Status=true;
                ActualLable("successfully verified Assert for Create Quote GAP_IAP Page ","Pass");
            }else{ActualLable(" Assert verification failed for Create Quote GAP_IAP Page ","Fail");}
        }else{ActualLable("Create Quote GAP_IAP page is not Loaded Properly","Fail");}
        return Status;
    }
}
