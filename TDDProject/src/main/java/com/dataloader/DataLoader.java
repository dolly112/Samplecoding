package com.dataloader;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import com.RunConfig.DynamicTestNG;
import com.utilities.ExcelActions;



/**
 * Data loader to get the currently running test case data from the excel and store it data provider
 * To use the test data in test method  should specify the data provider name
 * Note: It contains configuration excel path and respective sheet name
 * @author GRANDIS
 * 
 */
public class DataLoader {
	public static Logger LOGGER = Logger.getLogger(DataLoader.class);
	public static String language=DynamicTestNG.getRunParamProperty("language");
	private static ExcelActions excelRW;
	
	/**
	 * 
	 * This Method  get the All runnable TestCases method names and return  the Iterator object array with help of CommonDPcode method
	 * @author GRANDIS
	 * @param m // calling method should pass parameters are data provider name, dataProviderClass
	 * @return data provider
	 * @throws Exception
	 * 
	 */

	@DataProvider(name="commondp")
	public static Iterator<Object[]> getMethod(Method m) throws Exception{
		String script = m.getName();
		String sheet=null;
		if(language.contains("En")) {
			sheet="ManageCostcenter_EN";
		
		/*else {
			sheet="ManageUsers_EN";
		}*/
		LOGGER.info("TestData read successfully for current test" );
		
		
		}
		return commonDpCode(sheet, script);		
	}
	
	/**
	 * Method for store the test data using list iterator object array
	 * Firstly store excel data in "Hashmap", those will be stored in list iterator of object array
	 * @author GRANDIS
	 * @param Sheetname 
	 * @param ScriptName
	 * @return
	 * @throws IOException
	 */
	public static Iterator<Object[]> commonDpCode(String Sheetname, String ScriptName) throws IOException {
		String currentPath = System.getProperty("user.dir");
		String excelPathEN = currentPath + "/lib/ConfuigurationFile.xlsx";
		LOGGER.debug("Start Reading the Test Data from the Excel for current Test");
		excelRW = new ExcelActions(excelPathEN);
		int row = excelRW.getRow(Sheetname);
		int columncount = excelRW.getColumn(Sheetname, ScriptName);
		List<Object[]> listobjects = new ArrayList<Object[]>();

		for (int i = 0; i <= row; i++) {
			String SName = excelRW.readCell(Sheetname, i, 0);
			if (SName.equalsIgnoreCase(ScriptName)) {
				Object[] arr = new Object[1];
				Map<String, String> datamap = new HashMap<String, String>();
				for (int j = 0; j <= columncount; j++) {
					String Header = excelRW.readCell(Sheetname, i + 1, j);
					String Value = excelRW.readCell(Sheetname, i + 2, j);
					datamap.put(Header, Value);
				} // end of for
				arr[0] = datamap;
				listobjects.add(arr);
				break;
			}
		}
		return listobjects.iterator();
	}
	
	
	@DataProvider
	public Object[][] TestCaseAddCostcenters()
	{
	Object [][] data= new Object[3][2];	
	
	data[0][0]="TestCase27_ValidateUMWithPLAWebIntegrationS2";
	data[0][1]="CCAddData";
	
	data[1][0]="TestCase26_ValidateUMWithPLAWebIntegration";
	data[1][1]="CCAddData";
	
	return data;
		
	}
	
	

}
