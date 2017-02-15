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
public class ExchangeRateCalculatorPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By ExchangeRateCalculatorAssert= By.xpath("//tbody/tr[1]/td[@class='ListHeader']");


    public static boolean VerifyExchangeRatePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Exchange Rate Calculator page is opened or not ?");
        if (GetElementText(driver,ExchangeRateCalculatorAssert).contentEquals("EXCHANGE RATE CALCULATOR")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Exchange Rate Calculator")) {
                Status = true;
                ActualLable("successfully verified Assert for Exchange Rate Calculator Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Exchange Rate Calculator Page ", "Fail");
            }
        } else {
            ActualLable("Exchange Rate Calculator page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
