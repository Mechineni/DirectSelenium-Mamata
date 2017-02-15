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
public class NewsPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By NewsAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyNewsPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that News page is opened or not ?");
        if (GetElementText(driver,NewsAssert).contentEquals("NEWS LIST")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("News List")) {
                Status = true;
                ActualLable("successfully verified Assert for News Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for News Page ", "Fail");
            }
        } else {
            ActualLable("News page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
