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
public class CountryWorkingTimePage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By CountryWorkingTimeAssert= By.xpath("//tbody/tr[1]/td[@class='ListHeader']");


    public static boolean VerifyCountryWorkingTimePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Country Work Time page is opened or not ?");
        if (GetElementText(driver,CountryWorkingTimeAssert).contentEquals("COUNTRY WORK TIME")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Country Work Time")) {
                Status = true;
                ActualLable("successfully verified Assert for Country Work Time Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Country Work Time Page ", "Fail");
            }
        } else {
            ActualLable("Country Work Time page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
