package PageObject.S_I_AdminPackage;

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
public class StagingFacilitiesPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By StagingFacilitiesAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyStagingFacilitiesPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Staging Facilities page is opened or not ?");
        if (GetElementText(driver,StagingFacilitiesAssert).contentEquals("STAGING FACILITIES")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Staging Facilities")) {
                Status = true;
                ActualLable("successfully verified Assert for Staging Facilities Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Staging Facilities Page ", "Fail");
            }
        } else {
            ActualLable("Staging Facilities page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
