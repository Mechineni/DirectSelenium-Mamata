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
public class SalesTeamAdminPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By SalesTeamAdminAssert= By.xpath("//tr/td[@class='ListHeaderNew']/b");


    public static boolean VerifySalesTeamAdminPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Sales Team Admin page is opened or not ?");
        if (GetElementText(driver,SalesTeamAdminAssert).contentEquals("SALES TEAM ADMIN")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Sales Team Admin")) {
                Status = true;
                ActualLable("successfully verified Assert for Sales Team Admin Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Sales Team Admin Page ", "Fail");
            }
        } else {
            ActualLable("Sales Team Admin page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
