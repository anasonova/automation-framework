package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;

import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;

public class BoardPage extends PageObject
{

	@Override
	protected Class componentClass() {
		// TODO Auto-generated method stub
		return Forum.class;
	}

	@Override
	protected By readyLocator() {
		// TODO Auto-generated method stub
		return By.xpath("//table[@class='table_grid']");
	}
	
	private By _themeAutoQa = By.xpath("//span[@id='msg_30305']/a");
	
    final public TopicPage openTheme()
    {
    	this.component().session().driver().findElement(_themeAutoQa).click();
		return new TopicPage();
    	
    }

}
