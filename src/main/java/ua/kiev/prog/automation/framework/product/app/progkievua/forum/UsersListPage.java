package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;

public class UsersListPage extends PageObject
{

	@Override
	protected Class componentClass() {
		// TODO Auto-generated method stub
		return Forum.class;
	}

	@Override
	protected By readyLocator() {
		// TODO Auto-generated method stub
		return By.xpath("//*[@id='memberlist']");
	}
	
    private By _list = By.xpath("//*[@class='table_grid']//td[@class='windowbg lefttext']/a");
	
	public void printUsers() 
	{
		List<WebElement> authors = this.component().session().driver().findElements(_list);
		for (WebElement author: authors ) 
		{
			String nnn = author.getText();
			System.out.println(nnn);
		}
		
	}

}
