package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class AgentsPage extends TestBase {

	@FindBy(xpath="//div[@id='content']//b")
	WebElement lblAgentName;
		
	public AgentsPage(){
		PageFactory.initElements(driver,this);
	}
	
	public String getAgentName(){
		
		return lblAgentName.getText();
	}
	
	
	
	
	
	
	
	
	
	
}
