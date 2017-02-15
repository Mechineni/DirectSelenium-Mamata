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
public class DD_ActivePage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By DDActiveAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyDDActivePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that DD Active page is opened or not ?");
        if (GetElementText(driver,DDActiveAssert).contentEquals("DD ACTIVE")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("DD Active")) {
                Status = true;
                ActualLable("successfully verified Assert for DD Active Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for DD Active Page ", "Fail");
            }
        } else {
            ActualLable("DD Active page is not loaded Properly", "Fail");
        }
        return Status;
    }
}
