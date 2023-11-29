package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.utilities.BaseInitializer;

/**
 * Pagefactory of overview screen
 * @author GRANDIS
 *
 */
public class PageFactoryOverviewScreen extends BaseInitializer {
	
	public PageFactoryOverviewScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String overviewTbl1_Link_1stRowHyprlink="(//div[@role='row'])[3]//span[text()='parameter']";
	
	public String getoverviewTbl1_Link_1stRowHyprlink() {
		return overviewTbl1_Link_1stRowHyprlink;
	}
	
		@FindBy(xpath="//div[@role='grid']")
		public WebElement overview_Tbl_TblGrid;
		
		public WebElement getoverview_Tbl_TblGrid() {
			return overview_Tbl_TblGrid;
		}
	
		@FindBy(xpath = "//div[contains(@class,'Widget_content')]//span[text()='No data available!']|(//div[@role='grid'])[1]")
		public WebElement ENOverviewTb1_Txt_contentPresent;
	
		@FindBy(xpath = "//div[contains(@class,'Widget_content')]//span[text()='Daten nicht verf�gbar!']|(//div[@role='grid'])[1]")
		public WebElement DEOverviewTb1_Txt_contentPresent;
	
		public WebElement getOverviewTb1_Txt_contentPresent() {
			if (reqLanguage.contains("EN")) {
				return ENOverviewTb1_Txt_contentPresent;
			} else {
				return DEOverviewTb1_Txt_contentPresent;
			}
		}
		
		

		
		
		public String Tbl1_TBox_InputColumn="((//div[@role='grid'])[1]//input[@type='text'])[parameter]";
		
		public String getTbl1_TBox_InputColumn() {
			return Tbl1_TBox_InputColumn;
		}
			
		public String Tbl2_TBox_InputColumn="((//div[@role='grid'])[2]//input[@type='text'])[parameter]";
		
		public String getTbl2_TBox_InputColumn() {
			return Tbl2_TBox_InputColumn;
		}
		
		public String Tbl1_Txt_SpecificColumnData="(//div[@role='grid'])[1]//div[@role='gridcell'][parameter]"; ////div[@role='rowgroup']
		
		public String getTbl1_Txt_SpecificColumnData() {
			return Tbl1_Txt_SpecificColumnData;
		}
		
		public String Tbl2_Txt_SpecificColumnData="(//div[@role='grid'])[2]//div[@role='gridcell'][parameter]";
		
		public String getTbl2_Txt_SpecificColumnData() {
			return Tbl2_Txt_SpecificColumnData;
		}
		
		public String Tbl1_Chbox_SpecifiCheckbox="//div[text()='parameter']//preceding-sibling::div"; 
		
		public String getTbl1_Chbox_SpecifiCheckbox() {
			return Tbl1_Chbox_SpecifiCheckbox;
		}
		public String Tbl1_Chbox_validation="(//div[text()='parameter']//parent::*)[1]";
		
		public String getTbl1_Chbox_validation() {
			return Tbl1_Chbox_validation;
		}
		
		
		
		@FindBy(xpath="(//div[@role='grid'])[1]//div[@class='rt-resizable-header-content']")
	    public List<WebElement> Overview_Tbl1_ColumnHeaders;
		
		public List<WebElement> getAllScreen_Tbl1_ColumnHeaders(){
			return Overview_Tbl1_ColumnHeaders;
		}
		
	    
		@FindBy(xpath="(//div[@role='grid'])[2]//div[@class='rt-resizable-header-content']")
	    public List<WebElement> AllScreen_Tbl2_ColumnHeaders;
		
		public List<WebElement> getAllScreen_Tbl2_ColumnHeaders(){
			return AllScreen_Tbl2_ColumnHeaders;
		}
		
	    @FindBy(xpath ="(//div[@role='columnheader']//input)[1]")
	    public WebElement Overview_Tbl1_1stTextBox;
	    
	    public WebElement getOverview_Tbl1_1stTextBox(){
			return Overview_Tbl1_1stTextBox;
		}
	    

	    
	
	    public String OverviewTbl1_Icn_ShowHide="(//*[name()='i'][contains(@class,'Widget_settingsIcon')])[parameter]";
	    
	    public String getOverviewTbl1_Icn_ShowHide(){
			return OverviewTbl1_Icn_ShowHide;
		}
	    
	    @FindBy(xpath="(//*[name()='i'][contains(@class,'Widget_settingsIcon')])[1]")
	    public WebElement OverviewTbl1_Icn_ShowHideOld;
	    public WebElement getOverviewTbl1_Icn_ShowHideOld(){
			return OverviewTbl1_Icn_ShowHideOld;
		}
	    
	    
	    @FindBy(xpath="(//*[name()='i'][contains(@class,'Widget_settingsIcon')])")
	    public List<WebElement> OverviewTbl1_Icns_ShowHide;
	    
	    public List<WebElement> getOverviewTbl1_Icns_ShowHide(){
			return OverviewTbl1_Icns_ShowHide;
		}
	    
	    @FindBy(xpath="//li[contains(@class,'ColumnSelection_item')]//div[contains(@class,'Checkbox__text')]")
	    public List<WebElement> Overview_options_CoulumnSelectionItems;
	    
	    public List<WebElement> getOverview_options_CoulumnSelectionItems() {
	    	return Overview_options_CoulumnSelectionItems;
	    }
	    
	    @FindBy(xpath="(//div[@role='grid'])[1]//div[@class='rt-thead -filters']//div[@role='columnheader']//*")
	    public List<WebElement> overView_Tbl1_filters;
	    
	    public List<WebElement> getoverView_Tbl1_filters(){
			return overView_Tbl1_filters;
		}
	    
	    @FindBy(xpath="(//div[@role='grid'])[2]//div[@class='rt-thead -filters']//div[@role='columnheader']//*")
	    public List<WebElement> overView_Tbl2_filters;
	    
	    public List<WebElement> getoverView_Tbl2_filters(){
			return overView_Tbl2_filters;
		}

	  
	    @FindBy(xpath ="(//span[contains(@class,'Widget_totalCountPanel')])[1]")
	    public WebElement OverviewTbl1_Txt_TotalNumofRecords;
	    
	    public WebElement getOverviewTbl1_Txt_TotalNumofRecords(){
			return OverviewTbl1_Txt_TotalNumofRecords;
		}
	   
	    
	    @FindBy(xpath ="(//span[contains(@class,'Widget_totalCountPanel')])[2]")
	    public WebElement OverviewTbl2_Txt_TotalNumofRecords;
	    
	    public WebElement getOverviewTbl2_Txt_TotalNumofRecords(){
			return OverviewTbl2_Txt_TotalNumofRecords;
		}
	    
		
		   
		@FindBy(xpath ="(//div[contains(@class,'ReactTable')])[1]//div[@class='-pageJump']//input")
		public WebElement OverviewTbl1_Txt_CurrentPageNumber;
		
		  public WebElement getOverviewTbl1_Txt_CurrentPageNumber() {
					return OverviewTbl1_Txt_CurrentPageNumber;
		    }
		@FindBy(xpath ="//div[@class='-previous']//button")
		public WebElement ENOverviewTbl1_Btn_PreviousButton;
		
		@FindBy(xpath ="//div[@class='-previous']//button")
		public WebElement DEOverviewTbl1_Btn_PreviousButton;
		
		  public WebElement getOverviewTbl1_Btn_PreviousButton() {
				if(reqLanguage.equalsIgnoreCase("EN")) {
					return ENOverviewTbl1_Btn_PreviousButton;
				}else {
					return DEOverviewTbl1_Btn_PreviousButton;
				}
		    }
		 
	public	 String overview_link_AnySpecificHyperlink="(//span[text()='parameter']|//a[text()='parameter']|//div[text()='parameter'])[1]";
		 
		 public String getoverview_link_AnySpecificHyperlink() {
			 return overview_link_AnySpecificHyperlink;
		 }
		 
	@FindBy(xpath="(//div[@role='row'])[3]")
	public WebElement Tbl1_row_1stRow;
	
	public WebElement getTbl1_row_1stRow() {
			return Tbl1_row_1stRow;
	}
	
	String filterTypeTag_tag_OverviewTbl1="((//div[@role='grid'])[1]//div[@class='rt-thead -filters']//div[@role='columnheader']/*)[parameter]";
	public String getfilterTypeTag_tag_OverviewTbl1() {
		return filterTypeTag_tag_OverviewTbl1;
	}
	
	
}
