package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;

/**
 * ////////////////////////////////////////////////////////// *
 * Automation Framework                                       *
 * Automation Course for https://prog.kiev.ua/                *
 * ---------------------------------------------------------- *
 * Created by Yurii Voronenko                                 *
 * Email: yurii.voronenko@gmail.com                           *
 * ////////////////////////////////////////////////////////// *
 */
public class MainPageLoggedIn  extends PageObject
{
    /**
     * Этот метод должен возвращать класс компонета для объекта страницы
     * Определяет к какому компоненту привязан этот объект страницы
     *
     * @return Class
     */
    @Override
    protected Class<? extends Component> componentClass()
    {
        return Forum.class;
    }

    /**
     * Єтот метод должен возвращать локатор готовности страницы
     *
     * @return By - locator
     */
    @Override
    protected By readyLocator()
    {
        return By.xpath("//div[@id='boardindex_table']");
    }

    private By _usernameText = By.xpath("//div[@class='user_block']//a[contains(@href,'?action=profile')]/span");

    final public String getUsername ()
    {
        return this.component().session().driver().findElement(_usernameText).getText();
    }
    
    private By _sectionAutoQa = By.xpath("//tr[@id='board_25']//a[@name='b25']");
    
    final public BoardPage openSection()
    {
    	this.component().session().driver().findElement(_sectionAutoQa).click();
		return new BoardPage();
    	
    }
    
    private By _users = By.xpath("//li[@id='button_mlist']//span[@class='firstlevel']");
    
    final public UsersListPage openUsers()
    {
    	this.component().session().driver().findElement(_users).click();
		return new UsersListPage();
    	
    }
    
    public void clickOnInvisibleElement(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor)this.component().session().driver();
        String script = "var object = arguments[0];"
                + "var theEvent = document.createEvent(\"MouseEvent\");"
                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "object.dispatchEvent(theEvent);"
                ;
             
        js.executeScript(script, element);
    }
 private By _settingProfile = By.xpath("//*[@id='button_profile']/ul/li[3]/a/span");
    
    final public SettingProfilePage settingProfilePage()
    {
    	WebElement settingProfile = this.component().session().driver().findElement(_settingProfile);
    	this.clickOnInvisibleElement(settingProfile);
    	//this.component().session().driver().findElement(_settingProfile).click();
		return new SettingProfilePage();
    	
    }
    
    
}
