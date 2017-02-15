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
public class UptimeContractPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By UptimeContractAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyUptimeContractPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Uptime Contract page is opened or not ?");
        if (GetElementText(driver,UptimeContractAssert).contentEquals("UPTIME CONTRACT")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Uptime Contract")) {
                Status = true;
                ActualLable("successfully verified Assert for Uptime Contract Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Uptime Contract Page ", "Fail");
            }
        } else {
            ActualLable("Uptime Contract page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
