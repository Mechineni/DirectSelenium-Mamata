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
public class SellerRolesPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By SellerRolesAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifySellerRolesPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Seller Roles page is opened or not ?");
        if (GetElementText(driver,SellerRolesAssert).contentEquals("SELLER ROLES")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Seller Roles")) {
                Status = true;
                ActualLable("successfully verified Assert for Seller Roles Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Seller Roles Page ", "Fail");
            }
        } else {
            ActualLable("Seller Roles page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
