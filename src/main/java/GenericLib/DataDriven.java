package GenericLib;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.*;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static GenericLib.ObjectRepository.TimeConstatnt;
import static GenericLib.ObjectRepository.TimeSt;


public class DataDriven {

	private static Workbook book;
	private static Workbook TestCaseBook;
	private static Workbook book1;
	private static WritableWorkbook wbook;
	private static Sheet sheet;
	private static Sheet sheet1;
	private static Sheet TestCasesheet;
	private static WritableSheet wsheet;
	static int SCcount=1;

	static ObjectRepository obr = new ObjectRepository();
	//Properties obj;
	FileInputStream objFile;
	static private WebDriver driver;
	public static WritableCellFormat CellFormat2() throws WriteException {
		//int counted = 14;
		WritableCellFormat cellFormat = null;
		WritableFont cellFont = null;
		cellFont = new WritableFont(WritableFont.ARIAL, 9);
		cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setWrap(true);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		cellFormat.setAlignment(Alignment.CENTRE);
		return cellFormat;
	}
	public static WritableCellFormat CellFormat3() throws WriteException {
		//int counted = 14;
		WritableCellFormat cellFormat = null;
		WritableFont cellFont = null;
		cellFont = new WritableFont(WritableFont.ARIAL,22,WritableFont.BOLD);
		cellFont.setColour(Colour.WHITE);
		cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setWrap(true);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THICK);
		cellFormat.setAlignment(Alignment.CENTRE);
		cellFormat.setBackground(Colour.GREEN);//BRIGHT_GREEN
		return cellFormat;
	}

	public Sheet ReadSheet(Sheet sheet) throws BiffException, IOException, WriteException {
		obr.repository(driver);
		book = Workbook.getWorkbook(new File(obr.obj.getProperty("testData")));
		sheet = book.getSheet("ResultSheet");
		String folderName = ObjectRepository.DateSt();
		//wbook = Workbook.createWorkbook(new File("./ResultReports/" + folderName + "/"+"Detailed Test Report_" +ObjectRepository.dateString()+".xls"), book);
		//To save in commonShare
		wbook = Workbook.createWorkbook(new File(obr.obj.getProperty("CreateWorkBookPath") +"//"+ folderName + "//"+"Detailed Test Report_" +ObjectRepository.dateString()+".xls"), book);
		wsheet = wbook.getSheet("TestCaseDiscription");
		wsheet.addCell(new Label(0 , 0 ,"DD WebShop Test Report",CellFormat3()));
		wsheet.addCell(new Label(1 , 4 ,ObjectRepository.DateSt(),CellFormat2()));
		return sheet;
	}
	public static Sheet ReadTestCases(Sheet TestCasesheet) throws BiffException, IOException, WriteException {
		obr.repository(driver);
		TestCaseBook = Workbook.getWorkbook(new File(obr.obj.getProperty("testData2")));
		TestCasesheet = TestCaseBook.getSheet("Scenarios");
		return TestCasesheet;
	}

	public static WritableSheet writeSheet(WebDriver driver) throws IOException{

		wsheet = wbook.getSheet("ResultSheet");

		return wsheet;
	}
	private static final AtomicInteger count = new AtomicInteger(3);
	private static final AtomicInteger count5 = new AtomicInteger(6);

	public static int DataDriven(){
		int expcounted = count.incrementAndGet();
		return expcounted;
	}
	public static int DataDriven5(){
		int Actucounted = count5.incrementAndGet();
		return Actucounted;
	}

	public static WritableCellFormat CellFormat() throws WriteException {
		//int counted = 14;
		WritableCellFormat cellFormat = null;
		WritableFont cellFont = null;
		cellFont = new WritableFont(WritableFont.ARIAL, 9);
		cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setWrap(true);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		return cellFormat;
	}
	public static WritableCellFormat CellFormat1() throws WriteException {
		//int counted = 14;
		WritableCellFormat cellFormat = null;
		WritableFont cellFont = null;
		cellFont = new WritableFont(WritableFont.ARIAL, 9);
		cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setWrap(true);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		cellFormat.setAlignment(Alignment.CENTRE);
		return cellFormat;
	}
	public static WritableCellFormat CellFormat4() throws WriteException {
		//int counted = 14;
		WritableCellFormat cellFormat = null;
		WritableFont cellFont = null;
		cellFont = new WritableFont(WritableFont.ARIAL, 9,WritableFont.BOLD);
		cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setWrap(true);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		return cellFormat;
	}

	static int counting=1;
	public static void StepLable(String resu) throws IOException, WriteException {
		//int i = DataDriven();DataDriven1();DataDriven2();DataDriven3();DataDriven4();
		int i = DataDriven();
		wsheet = wbook.getSheet("ResultSheet");
		WritableCellFormat cellFormat = null;
		WritableFont cellFont = null;
		cellFont = new WritableFont(WritableFont.ARIAL,9,WritableFont.BOLD);
		cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setWrap(true);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
		cellFormat.setBackground(Colour.GREY_40_PERCENT);
		wsheet.mergeCells(0, i, 4, i);
		wsheet.addCell(new Label(0 , i , resu, cellFormat));
		counting=1;
	}
	public static int numberForColumn;
	public static void ExpectedLable(String resu) throws IOException, WriteException {
		numberForColumn= DataDriven();
		wsheet = wbook.getSheet("ResultSheet");
		//wsheet.addCell(new Label(1 , DataDriven() , resu, CellFormat()));
		wsheet.addCell(new Label(1 , numberForColumn , resu, CellFormat()));
		String numberAsString = Integer.toString(counting);
		//wsheet.addCell(new Label(0 , DataDriven4() , numberAsString,CellFormat1()));
		wsheet.addCell(new Label(0 , numberForColumn , numberAsString,CellFormat1()));
		counting++;
	}


	public static void ActualLable(String ACText,String result) throws IOException, WriteException {

		wsheet = wbook.getSheet("ResultSheet");
		//wsheet.addCell(new Label(2 , DataDriven1() , ACText,CellFormat()));
		wsheet.addCell(new Label(2 , numberForColumn , ACText,CellFormat()));
		if(result=="Fail"){
			WritableCellFormat cellFormat = null;
			WritableFont cellFont = null;
			cellFont = new WritableFont(WritableFont.ARIAL, 9);
			cellFormat = new WritableCellFormat(cellFont);
			cellFormat.setWrap(true);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			cellFormat.setAlignment(Alignment.CENTRE);
			cellFormat.setBackground(Colour.RED);
			//int num = DataDriven2();
			int num = numberForColumn;
			String folderName = ObjectRepository.DateSt();
			Browser.screenshots();
			//WritableHyperlink hlk =new WritableHyperlink(3 , num ,new File("D:\\Projects_Idea\\WebShopNewProject\\ResultReports\\"+folderName+"\\"+ScID+"-"+TimeConstatnt()+"-screen-"+SCcount+".jpeg"));
			WritableHyperlink hlk =new WritableHyperlink(3 , num ,new File(obr.obj.getProperty("CreateWorkBookPath")+"//"+folderName+"//"+ScID+"-"+TimeConstatnt()+"-screen-"+SCcount+".jpeg"));
			wsheet.addHyperlink(hlk);
			//wsheet.addCell(new Label(3 , DataDriven2() , result,cellFormat));
			wsheet.addCell(new Label(3 , num , result,cellFormat));
			sResult = true;
			SCcount++;
		}
		else if(result=="Pass"){
			WritableCellFormat cellFormat = null;
			WritableFont cellFont = null;
			cellFont = new WritableFont(WritableFont.ARIAL, 9);
			cellFormat = new WritableCellFormat(cellFont);
			cellFormat.setWrap(true);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			cellFormat.setAlignment(Alignment.CENTRE);
			cellFormat.setBackground(Colour.GREEN);
			//wsheet.addCell(new Label(3 , DataDriven2() , result,cellFormat));
			wsheet.addCell(new Label(3 , numberForColumn , result,cellFormat));
		}
		else{
			//wsheet.addCell(new Label(3 , DataDriven2() , result,CellFormat1()));
			wsheet.addCell(new Label(3 , numberForColumn , result,CellFormat1()));
		}
		//wsheet.addCell(new Label(4 , DataDriven3() , ObjectRepository.TimeSt(),CellFormat1()));
		wsheet.addCell(new Label(4 , numberForColumn , ObjectRepository.TimeSt(),CellFormat1()));
		/*String numberAsString = Integer.toString(counting);
		wsheet.addCell(new Label(0 , DataDriven4() , numberAsString,CellFormat1()));
		counting++;*/
	}
	static String ScID;
	static int ReportStartNumber;
	public static void ReportStartup(int j) throws IOException, WriteException, BiffException {
		//int k = DataDriven();DataDriven1();DataDriven2();DataDriven3();DataDriven4();
		int k = DataDriven();
		ScID= ReadTestCases(TestCasesheet).getCell(0,j).getContents();
		String ScName= ReadTestCases(TestCasesheet).getCell(1,j).getContents();
		String ScDis= ReadTestCases(TestCasesheet).getCell(2,j).getContents();
		String text = ScID+" : "+ScName;
		WritableCellFormat cellFormat = null;
		WritableFont cellFont = null;
		cellFont = new WritableFont(WritableFont.ARIAL, 9);//WritableFont.BOLD
		cellFont.setColour(Colour.WHITE);
		cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setWrap(true);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
		cellFormat.setBackground(Colour.AQUA);
		wsheet = wbook.getSheet("ResultSheet");
		wsheet.mergeCells(0, k, 4, k);
		wsheet.addCell(new Label(0 , k , text, cellFormat));
		//wsheet = wbook.getSheet("TestCaseDiscription");
		ReportStartNumber = DataDriven5();
		WritableHyperlink hlk =new WritableHyperlink(0,ReportStartNumber,ScID,wsheet = wbook.getSheet("ResultSheet"),0,k);
		wsheet = wbook.getSheet("TestCaseDiscription");
		wsheet.addCell(new Label(4 , 3, "QA2 / "+Browser.BrowserNameForSuite,CellFormat1()));
		wsheet.addHyperlink(hlk);
		wsheet.addCell(new Label(0 , ReportStartNumber, ScID,CellFormat1()));
		wsheet.addCell(new Label(1 , ReportStartNumber, ScName, CellFormat4()));
		wsheet.addCell(new Label(2 , ReportStartNumber, ScDis, CellFormat()));
		counting=1;
	}
	public static String FolderName() throws WriteException, IOException {
		String FolderNameS = ScID;
		return FolderNameS;
	}

	static boolean sResult;
	public static void ReportResult() throws WriteException {
		//int ResultColumn= DataDriven6();
		wsheet = wbook.getSheet("TestCaseDiscription");//sResult
		if(sResult==true){
			//if(Scresult=="Fail"){
			WritableCellFormat cellFormat = null;
			WritableFont cellFont = null;
			cellFont = new WritableFont(WritableFont.ARIAL, 9);
			cellFormat = new WritableCellFormat(cellFont);
			cellFormat.setWrap(true);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			cellFormat.setAlignment(Alignment.CENTRE);
			cellFormat.setBackground(Colour.RED);
			wsheet.addCell(new Label(3 , ReportStartNumber , "Fail",cellFormat));
			sResult=false;
		}
		else {
			//else if(Scresult=="Pass"){
			WritableCellFormat cellFormat = null;
			WritableFont cellFont = null;
			cellFont = new WritableFont(WritableFont.ARIAL, 9);
			cellFormat = new WritableCellFormat(cellFont);
			cellFormat.setWrap(true);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			cellFormat.setAlignment(Alignment.CENTRE);
			cellFormat.setBackground(Colour.GREEN);
			wsheet.addCell(new Label(3 , ReportStartNumber , "Pass",cellFormat));
		}
		/*else{
			wsheet.addCell(new Label(3 , ResultColumn, Scresult,CellFormat1()));
		}*/
		wsheet.addCell(new Label(4 , ReportStartNumber , ObjectRepository.dateString(),CellFormat1()));


	}

	public void closedoc() throws IOException, WriteException{
		//wbook.write();
		wsheet = wbook.getSheet("TestCaseDiscription");
		int cols=0;
		int NoOfPassedTestCases=0;
		int NoOfFailedTestCases=0;
		cols=wsheet.getRows();
		for(int i=0;i<=cols;i++){
			String Resultstatus =wsheet.getCell(3,i).getContents();
			if(Resultstatus.contentEquals("Pass")){
				NoOfPassedTestCases=NoOfPassedTestCases+1;
			}else if(Resultstatus.contentEquals("Fail")){
				NoOfFailedTestCases=NoOfFailedTestCases+1;
			}
		}
		WritableCellFormat cellFormat = null;
		WritableFont cellFont = null;
		cellFont = new WritableFont(WritableFont.ARIAL, 9,WritableFont.BOLD);
		cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setWrap(true);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		cellFormat.setAlignment(Alignment.CENTRE);

		wsheet.addCell(new Label(2 , 3 , "No.Of Test Scenarios Executed : "+(cols-7)+" ",cellFormat));
		wsheet.addCell(new Label(2 , 4 , "No.Of Test Scenarios Passed / Failed : "+NoOfPassedTestCases+" / "+NoOfFailedTestCases+" ",cellFormat));

		count.getAndSet(3);
		count5.getAndSet(6);

		wsheet = wbook.getSheet("ResultSheet");
		wsheet.getSettings().setProtected(true);
		wbook.setProtected(true);
		wsheet = wbook.getSheet("TestCaseDiscription");
		wsheet.getSettings().setProtected(true);
		wbook.setProtected(true);
		wbook.write();
		wbook.close();
		book.close();
	}
	public static Sheet TCSheet(Sheet sheet1) throws BiffException, IOException, WriteException {
		obr.repository(driver);
		book1 = Workbook.getWorkbook(new File("D:\\TC.xls"));
		sheet1 = book1.getSheet("Sheet1");
		return sheet1;
	}
	public static int GetColumnNumber(String TcNO) throws IOException, WriteException, BiffException {
		int NoOfRows = ReadTestCases(TestCasesheet).getRows();
		int RN = 0;
		System.out.println(TimeSt());
		for(int i=0;i<=NoOfRows;i++) {
			String ScI = ReadTestCases(TestCasesheet).getCell(0, i).getContents();
			if(ScI.contentEquals(TcNO)){
				RN =i;
				String ScName = ReadTestCases(TestCasesheet).getCell(3, i).getContents();
				System.out.println(TimeSt());
				break;
			}
		}
		return RN;
	}
	private static String TestDataSheet;
	public static boolean CheckingFlag(String TcN) throws IOException, WriteException, BiffException {
		boolean status = false;
		int TestCaseNum = GetColumnNumber(TcN);
		ScID= ReadTestCases(TestCasesheet).getCell(0,TestCaseNum).getContents();
		String ScName= ReadTestCases(TestCasesheet).getCell(3,TestCaseNum).getContents();
		if(ScName.contentEquals("Yes")){
			status= true; DataDriven.ReportStartup(TestCaseNum);
		}
		TestDataSheet=TcN;
		return status;
	}
	public static Sheet TestDataSheet() throws BiffException, IOException, WriteException {
		obr.repository(driver);
		TestCaseBook = Workbook.getWorkbook(new File(obr.obj.getProperty("testData3")));
		Sheet TestCasesheet = TestCaseBook.getSheet(TestDataSheet);
		return TestCasesheet;
	}
}
