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
public class AttachRateBaseSLAsPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By AttachRateAssert= By.xpath("//tr/td[1][@class='ListHeader']");


    public static boolean VerifyAttachRatePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Attach Rate Base SLAs page is opened or not ?");
        if (GetElementText(driver,AttachRateAssert).contentEquals("ATTACH RATE BASE SLAS")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Attach Rate Base SLAs")) {
                Status = true;
                ActualLable("successfully verified Assert for Attach Rate Base SLAs Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Attach Rate Base SLAs Page ", "Fail");
            }
        } else {
            ActualLable("Attach Rate Base SLAs page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
