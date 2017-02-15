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
public class CMI_ParentChildRelationshipPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By CMIAssert= By.xpath("//tr/td[@class='ListHeaderNew']/b");


    public static boolean VerifyCMIPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that CMI Parent Child Relationship page is opened or not ?");
        if (GetElementText(driver,CMIAssert).contentEquals("CMI PARENT CHILD RELATIONSHIP")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("CMI Parent Child Relationship")) {
                Status = true;
                ActualLable("successfully verified Assert for CMI Parent Child Relationship Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for CMI Parent Child Relationship Page ", "Fail");
            }
        } else {
            ActualLable("CMI Parent Child Relationship page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
