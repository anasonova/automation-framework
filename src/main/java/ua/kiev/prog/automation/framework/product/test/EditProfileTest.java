package ua.kiev.prog.automation.framework.product.test;

import ua.kiev.prog.automation.framework.core.Test;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.LoginPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPageLoggedIn;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.SettingProfilePage;

public class EditProfileTest extends Test
{

	@Override
	public String name() 
	{
		return "Edit user profile";
	}

	@Override
	public void beforeTest() 
	{
		System.out.println("TEST: " + this.name() + " | PHASE: BEFORE RUN");	
	}

	@Override
	public void test() 
	{
		System.out.println("TEST: " + this.name() + " | PHASE: TEST");
		MainPage mainPage   = Component.getSingleton(Forum.class).mainPage();
	    LoginPage loginPage = mainPage.getLoginPage();
	    MainPageLoggedIn dashboard = loginPage.login("allche", "555a666_");
	    this.assertSuccess(dashboard, "Login");
	    System.out.println("Name: " + dashboard.getUsername());

	    SettingProfilePage settingProfilePage = dashboard.settingProfilePage();
	    this.assertSuccess(settingProfilePage, "Profile");
	    settingProfilePage.editProfile();
	    settingProfilePage.checkEditProfile();
	}

	@Override
	public void afterTest() 
	{
		System.out.println("TEST: " + this.name() + " | PHASE: AFTER RUN");
		
	}

}
