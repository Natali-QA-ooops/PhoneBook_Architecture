package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    @Test
    public void registrationSuccess() {
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLogin("mirtel123456@mail.com","Mm098765$");
        app.getUserHelper().submitFormRegistration();


    }
}
