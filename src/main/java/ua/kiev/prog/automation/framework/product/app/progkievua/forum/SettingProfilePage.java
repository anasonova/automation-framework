package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import netscape.javascript.*;

public class SettingProfilePage extends PageObject
{

	@Override
	protected Class componentClass() 
	{
		return Forum.class;
	}

	@Override
	protected By readyLocator() 
	{
		 return By.xpath("//form[@id='creator']");
	}
	
	private By _radioAvatar = By.xpath("//form[@id='creator']//dt/input[@checked='checked' and @class='input_radio']");
    private By _inputAvatarUrl = By.xpath("//div[@id='avatar_external']/input[@class='input_text']");
    private By _inputAvatarSignature = By.xpath("//input[@id='personal_text']");
    private By _inputYearBirthday = By.xpath("//*[@id='creator']//div[@class='content']/dl[3]/dd[1]/input[1]");
    private By _inputMonthBirthday = By.xpath("//*[@id='creator']//div[@class='content']/dl[3]/dd[1]/input[2]");
    private By _inputDayBirthday = By.xpath("//*[@id='creator']//div[@class='content']/dl[3]/dd[1]/input[3]");
    private By _inputLocation = By.xpath("//input[@id='location']");
    private By _selectGender = By.xpath("//select[@id='gender']");
    private By _selectGenderGirl = By.xpath("//select[@id='gender']/option[3][@value='2']");
    private By _textareaProfileSignature = By.xpath("//textarea[@name='signature']");
    private By _buttonSaveProfile = By.xpath("//input[@class='button_submit']");
   
   
    
    public void editProfile()
    {
    	WebElement radioAvatar = this.component().session().driver().findElement(_radioAvatar);
    	String idRadioAvatar = radioAvatar.getAttribute("id");
    	boolean checkRadioAvatar = idRadioAvatar.equals("avatar_choice_external");
    	if (checkRadioAvatar != true)
    	{
    		this.component().session().driver().findElement(_radioAvatar).click();
    	}
    	this.component().session().driver().findElement(_inputAvatarUrl).clear();
    	this.component().session().driver().findElement(_inputAvatarUrl).sendKeys
    	("http://img0.liveinternet.ru/images/attach/c/4/81/889/81889822_gifki5813.gif");
    	this.component().session().driver().findElement(_inputAvatarSignature).clear();
    	this.component().session().driver().findElement(_inputAvatarSignature).sendKeys("Test");
    	this.component().session().driver().findElement(_inputYearBirthday).clear();
    	this.component().session().driver().findElement(_inputYearBirthday).sendKeys("1991");
    	this.component().session().driver().findElement(_inputMonthBirthday).clear();
    	this.component().session().driver().findElement(_inputMonthBirthday).sendKeys("01");
    	this.component().session().driver().findElement(_inputDayBirthday).clear();
    	this.component().session().driver().findElement(_inputDayBirthday).sendKeys("15");
    	this.component().session().driver().findElement(_inputLocation).clear();
    	this.component().session().driver().findElement(_inputLocation).sendKeys("Test");
    	this.component().session().driver().findElement(_selectGender).click();
    	this.component().session().driver().findElement(_selectGenderGirl).click();
    	this.component().session().driver().findElement(_textareaProfileSignature).clear();
    	this.component().session().driver().findElement(_textareaProfileSignature).sendKeys("Test");
    	this.component().session().driver().findElement(_buttonSaveProfile).click();
    
  	
    }
    
    public void checkString(String getString, String inputString)
    {
    boolean checkerString = getString.equals(inputString);
    if (checkerString == true)
    {
    	System.out.println(getString + " equals " + inputString);
    }
    else
        
    	System.out.println(getString + " NOT equals " + inputString);
    
    }
    
    
    public void checkEditProfile()
    {
    	SettingProfilePage settingProfilePage = new SettingProfilePage();
    	String getAvatarUrl = 
    	this.component().session().driver().findElement(_inputAvatarUrl).getText();
    	settingProfilePage.checkString(getAvatarUrl, 
    			"http://img0.liveinternet.ru/images/attach/c/4/81/889/81889822_gifki5813.gif");
    	
    	String getAvatarSignature = 
    	this.component().session().driver().findElement(_inputAvatarSignature).getText();
    	settingProfilePage.checkString(getAvatarSignature, "Test");
    	
    	String getYearBirthday = 
    	this.component().session().driver().findElement(_inputYearBirthday).getText();
    	settingProfilePage.checkString(getYearBirthday, "1991");
    	
    	String getMonthBirthday = 
    	this.component().session().driver().findElement(_inputMonthBirthday).getText();
    	settingProfilePage.checkString(getMonthBirthday, "01");
    	
    	String getDayBirthday = 
    	this.component().session().driver().findElement(_inputDayBirthday).getText();
    	settingProfilePage.checkString(getDayBirthday, "15");

    	String getLocation = 
    	this.component().session().driver().findElement(_inputLocation).getText();
    	settingProfilePage.checkString(getLocation, "Test");
    	
    	WebElement getGenderGirl = this.component().session().driver().findElement(_selectGenderGirl);
    	String getGenderSelected = getGenderGirl.getAttribute("selected");
    	settingProfilePage.checkString(getGenderSelected, "selected");
    	
    	String getProfileSignature = 
    	this.component().session().driver().findElement(_textareaProfileSignature).getText();
    	settingProfilePage.checkString(getProfileSignature, "Test");
  	
    }


}
