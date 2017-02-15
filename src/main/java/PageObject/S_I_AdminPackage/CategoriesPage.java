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
public class CategoriesPage {


    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By CategoriesAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyCategoriesPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Categories page is opened or not ?");
        if (GetElementText(driver,CategoriesAssert).contentEquals("CATEGORIES")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Categories")) {
                Status = true;
                ActualLable("successfully verified Assert for Categories Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Categories Page ", "Fail");
            }
        } else {
            ActualLable("Categories page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
