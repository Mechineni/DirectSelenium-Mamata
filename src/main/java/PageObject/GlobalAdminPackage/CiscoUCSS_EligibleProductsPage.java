package PageObject.GlobalAdminPackage;

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
public class CiscoUCSS_EligibleProductsPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By CiscoUCSSAssert= By.xpath("//tbody/tr[1]/td[1][@class='ListHeader']");


    public static boolean VerifyCiscoUCSSPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Cisco UCSS Eligible Products page is opened or not ?");
        if (GetElementText(driver,CiscoUCSSAssert).contentEquals("SEARCH")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Cisco UCSS Eligible Products")) {
                Status = true;
                ActualLable("successfully verified Assert for Cisco UCSS Eligible Products Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Cisco UCSS Eligible Products Page ", "Fail");
            }
        } else {
            ActualLable("Cisco UCSS Eligible Products page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
