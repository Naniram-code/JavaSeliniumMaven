package DEMO1;

public class XpathCssSelectorCustomization {
	// Xpath:
			// Absolute Xpath:
				//	/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input/html/body			
	
				// Validation of Xpath:
					//	1. Chropath plugin
					//	2. Console of development tool -> $x("customized Xpath")
				
			// Relative Xpath: Customized Xpath
					// 1. Syntax of customized xpath -> //tagName[@attribute='value']	or 	//*[@attribute='value']
						// e.g //input[@name='userName'] or //*[@name='userName']
			
					// 2. text of the element -> //tagName[text()='value of text'] or //*[text()='value of text']
						// e.g	//font[text()="Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city."]
								//*[text()="Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city."]
					
					// 3. if text is too long -> //tagName[contains(text(),'partial txt')] or //*[contains(text(),'partial txt')]
						// e.g	//*[contains(text(),'Search works')]
			
					// 4. if value of an attribute is long -> //tagName[contains(@attribute,'partial value')]
						// id="twotabsearchtextbox"
						// e.g //input[contains(@id,'searchtextbox')] | //input[contains(@class,'nav-input')]
			
					// 5. use more than one attribute
//						<input type="text" name="field-keywords" autocomplete="off" 
//						placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" 
//						aria-label="Search" xpath="1">
						// e.g //span[contains(text(),'5 ways')][@class='a-truncate-cut']
			
					// 6. using parent tag/grandParent -> //grandParentTag/parentTag/childTag[@attribute='value']
						// e.g //div/div/h2[contains(text(),'styles')]
						// e.g //div[@class='a-cardui-header']/h2[contains(text(),'styles')] -> parentXpath/childXpath
						// e.g //div[@id='zIIb9sPxX23_Boznt9td3A']/div[@class='a-cardui-header']/h2[contains(text(),'styles')]
			
					// 7. creating xpath for child element from parent element (if child element has nothing unique)
						//	parentXpath/childTagName[index] or parentXpath/childXpath
						// e.g //div[@id='zIIb9sPxX23_Boznt9td3A']/div/h2
			
					// 8. identify parent element with reference to child xpath -> traversing to parent element from child element
						// childXpath/parent::parentTag
						// e.g //div[contains(@class,'search-submit')]/parent::div
						// e.g //div[contains(@class,'search-submit')]/parent::div/parent::form
			
					// 9. identifying sibling -> 1, 2, 3, 4
						// preceding sibling => xpathOf2/preceding-sibling::TagNameOf1
							// e.g //a[contains(@id,'accountList')]/preceding-sibling::a // for 1
						// following sibling => xpathOf2/following-sibling::TagNameOf3
							// e.g //a[contains(@id,'accountList')]/following-sibling::a[1] // for 3
							// e.g //a[contains(@id,'accountList')]/following-sibling::a[2] // for 4
			
							//preceding-sibling -
								//input[@name='userName']/parent::td/parent::tr/preceding-sibling::tr
							//following-sibling -
								//input[@name='userName']/parent::td/parent::tr/following-sibling::tr[1]
								//input[@name='userName']/parent::td/parent::tr/following-sibling::tr[2]
		
							//div[contains(@id,'dropdown')]/parent::div/following-sibling::div[1]
							//div[contains(@id,'dropdown')]/parent::div/following-sibling::div[2]
							//div[contains(@class,'search-submit')]/parent::div/preceding-sibling::div[1]
							//div[contains(@class,'search-submit')]/parent::div/preceding-sibling::div[2]
		
		
		// Css Selector: faster than xpath
		
				// Validation of Css selector:
					// 1. Chropath
					// 2. Console -> $("css selector")
				
				// Absolute Css:
					// body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(3) > form > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=password]
				
				// Relative Css:
					// 1. Syntax: tagName[attribute='value'] or [attribute='value'] -> not needed // & '@'
							//e.g a[href='/gp/cart/view.html?ref_=nav_cart'] or [href='/gp/cart/view.html?ref_=nav_cart']
			
					// 2. if there is ID: -> #valueOfIdAttribute
							// e.g #nav-cart
			
					// 3. if there is className: -> .valueOfClassName
							// e.g .a-button-input
	
						// e.g: .nav-left>#nav-search-dropdown-card
			
					// 4. if attribute value is long: -> tagName[attribute*='partialValue'] or [attribute*='partialValue']
							// e.g input[value*='checkout'] or [value*='checkout']
			
					// 5. more than one attribute: -> tagname[attribute1='value'][attribute2='value']
							// e.g input[class='a-button-input'][type='submit'][aria-labelledby='sc-buy-box-ptc-button-announce']
			
					// 6. if parent tag to identify child element: -> parentTagName>tagName[attribute='value']
							// e.g div>input[type='text']
			
					// 7. to identify child element, using parent css and child tagName (single child or multiple):
						// single child tagName: tagName[attribute='value']>input
							// e.g form[id='nav-search-bar-form']>div
						// multiple child tagName: tagName[attribute='value']>input:nth-child(position of child TagName)
							// e.g form[id='nav-search-bar-form']>div:nth-child(3)
						//table[class='gh-tbl2']>tbody>tr>td:nth-child(4)
				
					// 8. Not Css: identifying parent element from child Css selector -> traversing back to parent
					// 9. using text as a value not allowed

	public static void main(String[] args) {
		

		// Assignment: Application -> any element -> 10 elements -> Xpath/Css selector
	}

}
