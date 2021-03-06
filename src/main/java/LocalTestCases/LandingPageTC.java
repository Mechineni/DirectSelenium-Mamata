package LocalTestCases;

import GenericLib.Browser;
import GenericLib.DataDriven;
import GenericLib.ObjectRepository;
import PageObject.HomePagePackage.HomePage;
import PageObject.LandingPage;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static GenericLib.DataDriven.ActualLable;

/**
 * Created by t.mirasipally on 14-Feb-17.
 */
public class LandingPageTC extends Browser {

    ObjectRepository ob = new ObjectRepository();
    static Logger log = Logger.getLogger("Testing Cases");
    private WebDriver driver;
    //test

    @BeforeClass
    public void setUp() throws WriteException, IOException, BiffException {  driver = getDriver();  }


    @Test
    public void SC_001() throws IOException, InterruptedException, WriteException, BiffException {
        try {
            if (DataDriven.CheckingFlag("SC_001")==true) {
                LandingPage.LogInFunctionality(driver);
                HomePage.VerifyHomePageAssert(driver);
                HomePage.SelectOptionsUnderQuotes(driver);
                HomePage.SelectOptionsUnderOrders(driver);
            }
        }catch (AssertionError e){ String error ="Exception : " +  e.getClass().getSimpleName();	ActualLable(error,"Fail");}
        catch (Exception e){ String error ="Exception : " +  e.getClass().getSimpleName();ActualLable(error,"Fail"); }
    }


}
