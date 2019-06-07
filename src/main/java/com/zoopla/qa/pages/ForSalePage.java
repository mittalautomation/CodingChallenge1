package com.zoopla.qa.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class ForSalePage extends TestBase {

	@FindBy(xpath="//h1[contains(text(),'Property for sale in London')]")
	WebElement lblHeading;
	
	@FindBy(xpath="//li[contains(@id,'listing_')]//a[contains(@class,'price')]")
	List<WebElement> listPropPrice;
	
	@FindBy(xpath="//i[contains(@class,'cancel')]")
	WebElement cancelFilter;
	
	List<Integer> pricelist = new ArrayList<Integer>();
	
	public ForSalePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyLocation(String location)
	{
		return lblHeading.getText().contains(location);
	}
	
	public void getAllPropPriceReverse()
	{
		for(WebElement propertytprice: listPropPrice)
		{
			if(propertytprice.getText().replaceAll("[^0-9]","").isEmpty())
			{
				System.out.println("Property price is = " + propertytprice.getText() + " Price is not actual");
			}
			else
			{
				pricelist.add(Integer.parseInt(propertytprice.getText().replaceAll("[^0-9]", "")));
			}
		}
		System.out.println("Listy of Property Price in Reverse Order :");
		Collections.sort(pricelist,Collections.reverseOrder());
		System.out.println(pricelist);
	}
	
	public PropertyDtlPage getPropertyByPosition(int position)
	{
		cancelFilter.click();
		System.out.println(listPropPrice.get(position).getText());
		listPropPrice.get(position).click();		
		return new PropertyDtlPage();
		
	}
	
}
