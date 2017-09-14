package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;

public class TopicPage extends PageObject
{

	@Override
	protected Class componentClass() {
		// TODO Auto-generated method stub
		return Forum.class;
	}

	@Override
	protected By readyLocator() {
		// TODO Auto-generated method stub
		return By.xpath("//form[@id='quickModForm']");
	}
	
	private By _authors = By.xpath("//*[@class='poster']/h4");
	
	public void listUsersName() 
	{
		List<WebElement> authors = this.component().session().driver().findElements(_authors);
		for (WebElement author: authors ) 
		{
			String nnn = author.getText();
			System.out.println(nnn);
		}
		
	}
	
	 private By _users = By.xpath("//li[@id='button_mlist']//span[@class='firstlevel']");
	    
	    final public UsersListPage openUsers()
	    {
	    	this.component().session().driver().findElement(_users).click();
			return new UsersListPage();
	    	
	    }
	
}
