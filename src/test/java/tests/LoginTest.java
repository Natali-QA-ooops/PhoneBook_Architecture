package tests;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void loginSuccess() {
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLogin("Tomy123456@mail.com","Qq123666$45");
        app.getUserHelper().submitFormLogin();
    }
}
