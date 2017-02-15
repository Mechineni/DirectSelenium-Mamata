package PageObject.ReportsPackage;

import GenericLib.ObjectRepository;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.GetElementText;
import static GenericLib.ActionKeywords.GetPageTitle;
import static GenericLib.ActionKeywords.SizeOfTheElement;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;

/**
 * Created by t.mirasipally on 15-Feb-17.
 */
public class MyDataPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By MyDataAssert= By.xpath("//li[@id='tabselected']/a");


    public static boolean VerifyMyDataPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that My Data page is opened or not ?");
        if (GetElementText(driver,MyDataAssert).contentEquals("Favorites")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Reports")) {
                Status = true;
                ActualLable("successfully verified Assert for My Data Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for My Data Page ", "Fail");
            }
        } else {
            ActualLable("My Data page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
