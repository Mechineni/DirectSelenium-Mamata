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
public class ClientsAssociationsPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By ClientAssociationAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyClientAssociationPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Client Association page is opened or not ?");
        if (GetElementText(driver,ClientAssociationAssert).contentEquals("CLIENT ASSOCIATIONS")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Client Associations")) {
                Status = true;
                ActualLable("successfully verified Assert for Client Association Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Client Association Page ", "Fail");
            }
        } else {
            ActualLable("Client Association page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
