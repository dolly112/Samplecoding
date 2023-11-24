package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***
 * 
 * @author PRAMKUL
 *
 * This ExcelActions class used to access the excel, it has several methods like : getrow, getcolumn, read,write, SaveExcel etc....
 */


public class ExcelActions {
	public XSSFWorkbook workBook;
	public FileInputStream fis;
	String excelPath = System.getProperty("user.dir") + "/lib/ConfuigurationFile.xlsx";
	public static Logger LOGGER = Logger.getLogger(ExcelActions.class);


	/**
	 * @author  PRAMKUL
	 * This Constructor takes given file path and set the file path to input stream
	 * @param filepath : it is where excel file located
	 * @throws IOException
	 */
	public ExcelActions(String filepath) throws IOException {
		fis = new FileInputStream(filepath);
		workBook = new XSSFWorkbook(fis);
	}

	/***
	 * @author  PRAMKUL
	 * Method used to get last row from the given sheet
	 * @param sheetname
	 * @return : Last row of the given sheet
	 */
	public int getRow(String sheetname) {
		XSSFSheet sheet = workBook.getSheet(sheetname);
		return sheet.getLastRowNum();
	}

	/**
	 * @author  PRAMKUL
	 * This method used to get the last column of given test ScriptName
	 * @param sheetname : sheetname which has tests
	 * @param ScriptName : scprit name is nothing but testname which is currently executing
	 * @return : last cell of given testname
	 */
	public int getColumn(String sheetname,String ScriptName) {
		XSSFSheet sheet = workBook.getSheet(sheetname);
		return sheet.getRow(ColumnIndex_Test_colindex(sheetname, ScriptName)).getLastCellNum();
		//return sheet.getRow(0).getLastCellNum();
	}

	/***
	 * @author  PRAMKUL
	 * Method used to get the column count from the given test
	 * @param sheetname: which has tests
	 * @return : Last cell of the given sheet
	 */
	public  int ColumnIndex_Test_colindex(String sheetname, String Script) {
		int ColumnCount=0;
		int row=getRow(sheetname);
		for(int i=0;i<=row;i++) {
			String Test=readCell(sheetname, i, 0);
			if(Test.equalsIgnoreCase(Script)) {
				ColumnCount=i+1;
				break;
			}
			
		}
		/*
		 * if(ColumnCount==0) { ColumnCount=ColumnCount+1; }
		 */
		
		
		return ColumnCount;	
	}
	
	/**
	 * @author  PRAMKUL
	 * It read the data from given row,col data in specific sheet
	 * @param sheetname : sheet having tests to execute
	 * @param row : read the data
	 * @param col : read the data of col
	 * @return : String value of given row,col data
	 */ 
	public String readCell(String sheetname, int row, int col) {
		XSSFSheet sheet =workBook.getSheet(sheetname); 
		XSSFCell cell = null; 
		try {
	  cell=sheet.getRow(row).getCell(col); 
	  } 
		catch(NullPointerException ne)
		{ 
			LOGGER.error("cell does not have data");
		}
		  DataFormatter format=new DataFormatter(); 
		  String celltext="";
	  
	  if(cell!=null) {
		  celltext=format.formatCellValue(cell);//.getStringCellValue(); }
		} 	  
	  return celltext; 
	}
	/**
	 * @author  PRAMKUL
	 * 
	 * Write the data in given row,col of the specific sheet
	 * @param sheetname
	 * @param row
	 * @param col
	 * @param value : value for writing in given row,col
	 */

	public void writeCell(String sheetname, int row, int col, String value) {
		XSSFSheet sheet = workBook.getSheet(sheetname);
		sheet.getRow(row).getCell(col).setCellValue(value);

	}

	/**
	 * @author  PRAMKUL
	 * It save the excel if user write data to given excel file
	 * @param filepath
	 * @throws IOException
	 */
	public void saveExcel(String filepath) throws IOException {
		LOGGER.debug("Saving the Excel file");
		FileOutputStream fos = new FileOutputStream(filepath);
		workBook.write(fos);
		fis.close();
		fos.close();

	}
	
	/**
	 * @author PRAMKUL
	 * @param sheetname
	 * @param testcaseid
	 * @param columnname
	 * @return
	 */
	public synchronized String getData(String sheetname, String testcaseid, String columnname) {
		String testdata = null;
		try {
			String currentDir = System.getProperty("user.dir");
			// Create a object of File class to open xlsx file
			File file = new File(excelPath);
			// Create an object of FileInputStream class to read excel file
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = null;
			String fileExtensionName = excelPath.substring(excelPath.indexOf("."));
			// Check condition if the file is xlsx file
			if (fileExtensionName.equals(".xlsx")) {
				// If it is xlsx file then create object of XSSFWorkbook class
				workbook = new XSSFWorkbook(inputStream);
			}
			// Check condition if the file is xls file
			else if (fileExtensionName.equals(".xls")) {
				// If it is xls file then create object of XSSFWorkbook class
				workbook = new HSSFWorkbook(inputStream);
			}
			// Read sheet inside the workbook by its name
			Sheet sheet = workbook.getSheet(sheetname);
			// Find number of rows in excel file
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			// Create a loop over all the rows of excel file to read it
			for (int i = 0; i < rowCount + 1; i++) {
				Row row = sheet.getRow(i);
				Row columnheader = sheet.getRow(0);
				// Create a loop to print cell values in a row
				String tcid = row.getCell(0).getStringCellValue();
				/*
				 * if (testcaseid.equalsIgnoreCase(tcid)) { for (int j = 0; j <
				 * row.getLastCellNum(); j++) { if
				 * (columnheader.getCell(j).getStringCellValue().
				 * equalsIgnoreCase(columnname)) { testdata =
				 * row.getCell(j).getStringCellValue(); } } }
				 */
				if (testcaseid.equalsIgnoreCase(tcid)) {
					for (int j = 0; j < row.getLastCellNum(); j++) {
						if (columnheader.getCell(j).getStringCellValue().equalsIgnoreCase(columnname)) {
							CellType celltype = row.getCell(j).getCellType();
							switch (celltype) {
							case NUMERIC:
								testdata = Integer.toString((int) row.getCell(j).getNumericCellValue());
								break;
							case STRING:
								testdata = row.getCell(j).getStringCellValue();
								break;
							case BOOLEAN: //rosmols
								testdata = Boolean.toString(row.getCell(j).getBooleanCellValue());
								break;
							}

						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testdata;
	}
	
	public synchronized List<String> getDataList(String sheetname, String testcaseid, String columnname) {
		String testdata = null;
		List<String> dataList = new ArrayList<String>();
		try {
			String currentDir = System.getProperty("user.dir");
			// Create a object of File class to open xlsx file
			File file = new File(excelPath);
			// Create an object of FileInputStream class to read excel file
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = null;
			String fileExtensionName = excelPath.substring(excelPath.indexOf("."));
			// Check condition if the file is xlsx file
			if (fileExtensionName.equals(".xlsx")) {
				// If it is xlsx file then create object of XSSFWorkbook class
				workbook = new XSSFWorkbook(inputStream);
			}
			// Check condition if the file is xls file
			else if (fileExtensionName.equals(".xls")) {
				// If it is xls file then create object of XSSFWorkbook class
				workbook = new HSSFWorkbook(inputStream);
			}
			// Read sheet inside the workbook by its name
			Sheet sheet = workbook.getSheet(sheetname);
			// Find number of rows in excel file
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			// Create a loop over all the rows of excel file to read it
			for (int i = 0; i < rowCount + 1; i++) {
				Row row = sheet.getRow(i);
				Row columnheader = sheet.getRow(0);
				// Create a loop to print cell values in a row
				String tcid = row.getCell(0).getStringCellValue();
				/*
				 * if (testcaseid.equalsIgnoreCase(tcid)) { for (int j = 0; j <
				 * row.getLastCellNum(); j++) { if
				 * (columnheader.getCell(j).getStringCellValue().
				 * equalsIgnoreCase(columnname)) { testdata =
				 * row.getCell(j).getStringCellValue(); } } }
				 */
				System.out.println(tcid);
				if (testcaseid.equalsIgnoreCase(tcid)) {
					for (int j = 0; j < row.getLastCellNum(); j++) {
						System.out.println(columnheader.getCell(j).getStringCellValue());
						System.out.println(columnname);
						if (columnheader.getCell(j).getStringCellValue().equalsIgnoreCase(columnname)) {
							CellType celltype = row.getCell(j).getCellType();
							switch (celltype) {
							case NUMERIC:
								testdata = Integer.toString((int) row.getCell(j).getNumericCellValue());
								dataList.add(testdata);
								break;
							case STRING:
								testdata = row.getCell(j).getStringCellValue();
								dataList.add(testdata);
								break;
							case BOOLEAN: //rosmols
								testdata = Boolean.toString(row.getCell(j).getBooleanCellValue());
								dataList.add(testdata);
								break;
							}

						}
					}
				}
			}
		
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}
}
