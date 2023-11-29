package com.pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.utilities.BaseInitializer;
import com.utilities.BusinessUtilities;
import com.utilities.PageActions;

public class PracticeLoginPage extends BaseInitializer {

	public PracticeLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	PageActions pageActions = new PageActions();
	BusinessUtilities businessUtilities = new BusinessUtilities();
	
	PracticeLoginPage loginPage;

	@FindBy(xpath = "//p[@data-testid='addEdit']")
	public WebElement AddEditScreen;

}
