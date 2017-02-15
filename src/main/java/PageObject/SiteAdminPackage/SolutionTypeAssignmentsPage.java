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
public class SolutionTypeAssignmentsPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By SolutionTypeAssert= By.xpath("//tr/td[1][@class='ListHeaderNew']/b");


    public static boolean VerifySolutionTypePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Solution Type Assignments page is opened or not ?");
        if (GetElementText(driver,SolutionTypeAssert).contentEquals("SOLUTION TYPE ASSIGNMENTS")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Solution Type Assignments")) {
                Status = true;
                ActualLable("successfully verified Assert for Solution Type Assignments Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Solution Type Assignments Page ", "Fail");
            }
        } else {
            ActualLable("Solution Type Assignments page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
