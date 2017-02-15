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
public class AllReportsPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements

    static private By breadcrumbField=By.xpath("//td[@id='Breadcrumbs']");
    static private By breadcrumbHomeField = By.xpath("//td[@id='Breadcrumbs']/a");

    static private By AllReportsAssert= By.xpath("//li[@id='tabselected']/a");


    public static boolean VerifyAllReportsPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that All Reports page is opened or not ?");
        if (GetElementText(driver,AllReportsAssert).contentEquals("Quote/PO Activity")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Reports")) {
                Status = true;
                ActualLable("successfully verified Assert for All Reports  Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for All Reports  Page ", "Fail");
            }
        } else {
            ActualLable("All reports page is not loaded Properly", "Fail");
        }
        return Status;
    }
}
