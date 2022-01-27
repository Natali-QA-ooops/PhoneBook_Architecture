package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCond() {
        // если кнопка есть sihn out
        if (app.getUserHelper().isSignOutPresent()) {
            app.getUserHelper().signOut();//раазлогинься
        }
    }


    @Test
    public void loginSuccess() {
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().pause(3000);
        app.getUserHelper().fillFormLoginRegistration("Tomy123456@mail.com", "Qq123666$45");
        app.getUserHelper().submitFormLogin();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

    @Test
    public void loginSuccessModel() {
        User user = new User().withEmail("Tomy123456@mail.com").withPassword("Qq123666$45");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLoginRegistration(user);
        app.getUserHelper().submitFormLogin();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

}
