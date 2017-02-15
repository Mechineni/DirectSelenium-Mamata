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
public class CoBrand_SIS98RulesPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By CoBrandRulesAssert= By.xpath("//td[@class='ListHeaderS1a']/b");


    public static boolean VerifyCoBrandPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Co-Brand/SIS98 Install Country Rules page is opened or not ?");
        if (GetElementText(driver,CoBrandRulesAssert).contentEquals("CO-BRAND/SIS98 INSTALL COUNTRY RULES")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Co-Brand/SIS98 Install Country Rules")) {
                Status = true;
                ActualLable("successfully verified Assert for Co-Brand/SIS98 Install Country Rules Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Co-Brand/SIS98 Install Country Rules Page ", "Fail");
            }
        } else {
            ActualLable("Co-Brand/SIS98 Install Country Rules page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
