package PageObject.HomePagePackage;

import GenericLib.ObjectRepository;
import PageObject.OrdersPackage.BT_ServiceRequestsPage;
import PageObject.OrdersPackage.OrdersDocumentSearchPage;
import PageObject.OrdersPackage.UploadPurchaseOrderPage;
import PageObject.OrdersPackage.ViewShipmentStatusDetailsPage;
import PageObject.QuotesPackage.*;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;
import static GenericLib.DataDriven.StepLable;

/**
 * Created by t.mirasipally on 14-Feb-17.
 */
public class HomePage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;

    //PageElements
    static private By WelcomeField = By.id("Welcome");
    //static private By MenusOnHomePage = By.xpath("//td[@id='DirectMenus']/ul/li/a");




    public static void VerifyHomePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        ExpectedLable("Verify that Home ia opened or not ?");
        if(SizeOfTheElement(driver,WelcomeField)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Home")){
                ActualLable("successfully verified Assert for Home Page ","Pass");
            }else{ActualLable(" Assert verification failed for Home Page ","Fail");}
        }else{ActualLable("Home page is not Loaded Properly","Fail");}
    }

    public static void SelectOptionsUnderQuotes(WebDriver driver) throws InterruptedException, IOException, WriteException {
        StepLable("Verifying links");
        Thread.sleep(15000);
        for(int j=1;j<=5;j++) {
            By QuotesMenu =  By.xpath("//td[@id='DirectMenus']/ul/li[1]/a");
            By OptionsQuotesMenu = By.xpath("//td[@id='DirectMenus']/ul/li[1]/ul/li["+j+"]");
            Thread.sleep(1000);
            clickOnElement(driver,QuotesMenu);
            waitForOneSec();
            clickOnElement(driver,OptionsQuotesMenu);
            //MouseHoverActionPerform(driver,QuotesMenu,OptionsQuotesMenu);
            if(j==1){   CreateQuotePage.VerifyCreateQuotePageAssert(driver);             }
            if(j==2){   CreateQuoteGAP_IAP.VerifyCreateQuoteGAPPageAssert(driver);       }
            if(j==3){   RevisionRequestedPage.VerifyRevisionrequestedPageAssert(driver); }
            if(j==4){   QuotesDocumentSearchPage.VerifyQuotesDocSearchPageAssert(driver);}
            if(j==5){   OpportunityRefManagementPage.VerifyOppRefPageAssert(driver);     }
        }
    }
    public static void SelectOptionsUnderOrders(WebDriver driver) throws InterruptedException, IOException, WriteException {
        StepLable("Verifying links");
        Thread.sleep(10000);
        for(int j=1;j<=4;j++) {
            By OrdersMenu =  By.xpath("//td[@id='DirectMenus']/ul/li[2]/a");
            By OptionsOrdersMenu = By.xpath("//td[@id='DirectMenus']/ul/li[2]/ul/li["+j+"]");
            clickOnElement(driver,OrdersMenu);
            waitForOneSec();
            clickOnElement(driver,OptionsOrdersMenu);
            //MouseHoverActionPerform(driver,OrdersMenu,OptionsOrdersMenu);
            if(j==1){   OrdersDocumentSearchPage.VerifyOrdersDocumentSearchPageAssert(driver); }
            if(j==2){   ViewShipmentStatusDetailsPage.VerifyViewShipmentPageAssert(driver);    }
            if(j==3){   UploadPurchaseOrderPage.VerifyUploadPurchaseOrderPageAssert(driver);   }
            if(j==4){   BT_ServiceRequestsPage.VerifyBTSearviceRequestPageAssert(driver);      }
        }
    }

}
