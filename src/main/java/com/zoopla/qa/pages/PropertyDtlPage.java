package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class PropertyDtlPage extends TestBase {
	
	@FindBy(xpath="//h4[contains(@class,'name')]")
	WebElement lblAgentName;
	
	@FindBy(xpath="//address[contains(@class,'address')]")
	WebElement lblAgentAddress;
	
	@FindBy(xpath="//span[text()='Call ']//ancestor::a")
	WebElement lblAgentPhno;
	
	@FindBy(xpath="//div[contains(@class,'logo')]/img")
	WebElement lblAgentLogo;
	

public	String AgentName;
public PropertyDtlPage(){
	PageFactory.initElements(driver,this);
}

public void getAgentDetails()
{
	System.out.println("AgentName = " + lblAgentName.getText());
	System.out.println("AgentAddress = " + lblAgentAddress.getAttribute("innerHTML"));
	System.out.println("AgentPhNo = " + lblAgentPhno.getAttribute("href").replaceAll("tel:","") );
	System.out.println("AgentLogoText = " + lblAgentLogo.getAttribute("alt") );
}

public AgentsPage clickOnAgentName()
{
	 AgentName=lblAgentName.getText();
	 System.out.println("AgentName = " + AgentName );
	lblAgentName.click();
	
	return new AgentsPage();
}
}
