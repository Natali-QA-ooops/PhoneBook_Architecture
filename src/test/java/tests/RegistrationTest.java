package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    @Test
    public void registrationSuccess() {
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillFormLoginRegistration("maya123456@mail.com","Ma098765$");
        app.getUserHelper().submitFormRegistration();


    }
}
