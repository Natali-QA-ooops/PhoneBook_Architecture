package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCond() {
        // если кнопка есть sihn out
        if (app.getUserHelper().isSignOutPresent()) {
            app.getUserHelper().signOut();//раазлогинься
        }
    }

    @Test (groups = {"web"})
    public void loginSuccessModel() {
        User user = new User().withEmail("Tomy123456@mail.com").withPassword("Qq123666$45");
        logger.info("Test starts with email [Tomy123456@mail.com], pessword[Qq123666$45]");
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLoginRegistration(user);
        app.getUserHelper().submitFormLogin();

        app.getUserHelper().takeScreenShot("src/test/screenshorts/sce1.png");

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

    @Test (enabled = false)
    public void loginNegativeTestWrongPassword() {
        User user = new User().withEmail("Tomy123456@mail.com").withPassword("Qq");
        logger.info("The user start negative login process with data : --->" + user.toString());

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLoginRegistration(user);
        app.getUserHelper().submitFormLogin();
        app.getUserHelper().pause(5000);
        Assert.assertTrue(app.getUserHelper().IsAlertDisplayed());
        Assert.assertTrue(app.getUserHelper().isErrorWrongEmailOrPasswordFormat());
        Assert.assertFalse(app.getUserHelper().isLogged());
    }


    @Test(dataProvider = "loginValidDataModel", dataProviderClass = MyDataProvider.class)
    public void loginSuccessModelDataProvider(User user) {

        logger.info("Test user starts with data:" + user.toString());
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLoginRegistration(user);
        app.getUserHelper().submitFormLogin();

        app.getUserHelper().takeScreenShot("src/test/screenshorts/sce1.png");

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }


    @Test(dataProvider = "loginValidData", dataProviderClass = MyDataProvider.class)
    public void loginSuccessTestDataProvider(String email, String password) {
        logger.info("Test starts with email " + email + "  && password " + password);

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().pause(3000);
        app.getUserHelper().fillFormLoginRegistration(email, password);
        app.getUserHelper().submitFormLogin();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }


    @Test(dataProvider = "loginValidDataCSV", dataProviderClass = MyDataProvider.class)
    public void loginSuccessTestDataProviderCSV(String email, String password) {
        logger.info("Test starts with email " + email + "  && password " + password);

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().pause(3000);
        app.getUserHelper().fillFormLoginRegistration(email, password);
        app.getUserHelper().submitFormLogin();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

    @Test (groups = {"smoke","reg","login"},enabled = false)
    public void loginSuccessTestDP() {
        logger.info("The user starts login process with email : 'Tomy123456@mail.com' && password 'Qq123666$45' ");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().pause(3000);
        app.getUserHelper().fillFormLoginRegistration("Tomy123456@mail.com", "Qq123666$45");
        app.getUserHelper().submitFormLogin();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }
}
