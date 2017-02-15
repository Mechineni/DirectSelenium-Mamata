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
public class QuotesDocumentSearchPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By DocumentSearchHeadding = By.xpath("//td[@class='ListHeaderNew'][contains(text(),'DOCUMENT SEARCH')]");




    public static boolean VerifyQuotesDocSearchPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that Document Search Page is opened or not ?");
        if(SizeOfTheElement(driver,DocumentSearchHeadding)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Document Search")){
                Status=true;
                ActualLable("successfully verified Assert for Document Search Page","Pass");
            }else{ActualLable(" Assert verification failed for Document Search Page","Fail");}
        }else{ActualLable("Document Search Page is not Loaded Properly","Fail");}
        return Status;
    }

}
