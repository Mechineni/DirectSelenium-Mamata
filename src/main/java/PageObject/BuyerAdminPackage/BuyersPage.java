package PageObject.BuyerAdminPackage;

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
public class BuyersPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By BuyersAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyBuyersPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Buyers page is opened or not ?");
        if (GetElementText(driver,BuyersAssert).contentEquals("BUYERS")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Buyers")) {
                Status = true;
                ActualLable("successfully verified Assert for Buyers Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Buyers Page ", "Fail");
            }
        } else {
            ActualLable("Buyers page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
