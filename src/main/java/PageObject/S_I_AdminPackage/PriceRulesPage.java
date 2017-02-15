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
public class PriceRulesPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By PriceRulesAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyPriceRulesPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Price Rules page is opened or not ?");
        if (GetElementText(driver,PriceRulesAssert).contentEquals("PRICE RULES")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Price Rules")) {
                Status = true;
                ActualLable("successfully verified Assert for Price Rules Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Price Rules Page ", "Fail");
            }
        } else {
            ActualLable("Price Rules page is not loaded Properly", "Fail");
        }
        return Status;
    }


}
