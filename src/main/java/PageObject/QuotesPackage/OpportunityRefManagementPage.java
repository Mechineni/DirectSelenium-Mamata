package PageObject.QuotesPackage;

import GenericLib.ObjectRepository;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.GetPageTitle;
import static GenericLib.ActionKeywords.SizeOfTheElement;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;

/**
 * Created by t.mirasipally on 15-Feb-17.
 */
public class OpportunityRefManagementPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By OppRefHeadding = By.xpath("//td[@class='ListHeaderNew'][contains(text(),'OPPORTUNITY REFERENCE MANAGEMENT')]");




    public static boolean VerifyOppRefPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that Opportunity Reference Management Page is opened or not ?");
        if(SizeOfTheElement(driver,OppRefHeadding)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Opportunity Reference Management")){
                Status=true;
                ActualLable("successfully verified Assert for Opportunity Reference Management Page","Pass");
            }else{ActualLable(" Assert verification failed for Opportunity Reference Management Page","Fail");}
        }else{ActualLable("Opportunity Reference Management Page is not Loaded Properly","Fail");}
        return Status;
    }


}
