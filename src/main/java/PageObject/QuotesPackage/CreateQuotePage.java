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
public class CreateQuotePage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By QuotesHeadding = By.xpath("//td[@class='ListHeader']/b[contains(text(),'QUOTING')]");




    public static boolean VerifyCreateQuotePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that Create Quote page is opened or not ?");
        if(SizeOfTheElement(driver,QuotesHeadding)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Quoting")){
                Status=true;
                ActualLable("successfully verified Assert for Create Quote Page ","Pass");
            }else{ActualLable(" Assert verification failed for Create Quote Page ","Fail");}
        }else{ActualLable("Create Quote page is not Loaded Properly","Fail");}
        return Status;
    }
}
