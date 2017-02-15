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
public class CatalogsPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By CatalogsAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyCatalogsPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Catalogs page is opened or not ?");
        if (GetElementText(driver,CatalogsAssert).contentEquals("Catalogs")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Catalogs")) {
                Status = true;
                ActualLable("successfully verified Assert for Catalogs Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Catalogs Page ", "Fail");
            }
        } else {
            ActualLable("Catalogs page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
