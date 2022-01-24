package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCond() {
        // если кнопка есть sihn out
        if (app.getUserHelper().isSignOutPresent()) {
            app.getUserHelper().signOut();//раазлогинься
        }
    }
    @Test
    public void registrationSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000 % 3600);
        System.out.println(index);
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLoginRegistration("maya" + index + "@mail.com",
                "Ma098765$");
        //app.getUserHelper().pause(3000);
        app.getUserHelper().submitFormRegistration();
        //app.getUserHelper().pause(3000);
        Assert.assertTrue(app.getUserHelper().isRegSuccess());
    }

    @Test
    public void registrationSuccessModel() {
        int index = (int) (System.currentTimeMillis() / 1000 % 3600);

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLoginRegistration(new User().withEmail("maya" + index + "@mail.com").withPassword("Ma098765$"));
        app.getUserHelper().submitFormRegistration();

        Assert.assertTrue(app.getUserHelper().isRegSuccess());
    }

}
