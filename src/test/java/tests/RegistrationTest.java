package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    @Test
    public void registrationSuccess() {

        //obj model

        int index = (int) (System.currentTimeMillis() / 1000 % 3600);
        System.out.println(index);
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLoginRegistration("maya"+index+"@mail.com",
                "Ma098765$");

        //app.getUserHelper().pause(3000);

        app.getUserHelper().submitFormRegistration();
        //app.getUserHelper().pause(3000);
        Assert.assertTrue(app.getUserHelper().isRegSuccess());
    }

    @Test
    public void registrationSuccessModel() {
        //obj model
        int index = (int) (System.currentTimeMillis() / 1000 % 3600);
        System.out.println(index);

        User user = new User().withEmail("maya"+index+"@mail.com").withPassword("Ma098765$");


        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLoginRegistration(user);
        //app.getUserHelper().pause(3000);
        app.getUserHelper().submitFormRegistration();
        //app.getUserHelper().pause(3000);
        Assert.assertTrue(app.getUserHelper().isRegSuccess());
    }

}
