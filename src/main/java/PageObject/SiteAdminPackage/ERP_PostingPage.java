package PageObject.SiteAdminPackage;

import GenericLib.ObjectRepository;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.GetElementText;
import static GenericLib.ActionKeywords.GetPageTitle;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;

/**
 * Created by t.mirasipally on 15-Feb-17.
 */
public class ERP_PostingPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By ERPPOstingAssert= By.xpath("//tbody/tr[1]/td[@class='ListHeader']/b");


    public static boolean VerifyERPPOstingPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that ERP POSTING page is opened or not ?");
        if (GetElementText(driver,ERPPOstingAssert).contentEquals("ERP POSTING")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("ERP Posting")) {
                Status = true;
                ActualLable("successfully verified Assert for ERP POSTING Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for ERP POSTING Page ", "Fail");
            }
        } else {
            ActualLable("ERP POSTING page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
