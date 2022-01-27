package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        //if ne zalogigena ----> login()
        if (!app.getUserHelper().isSignOutPresent()){
            app.getUserHelper().login(new User()
                    .withEmail("Tomy123456@mail.com").withPassword("Qq123666$45"));
        }
    }

    @Test
    public void addNewContactSuccess() {
        //sozd model Contact
        //open addContactForm
        //fill contactForm - sozd obj contact
        //submit "Save"
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index);

        Contact contact = Contact.builder()
                .name("Jack")
                .lastName("Sparrow")
                .phone("9723456" + index)
                .email("jacky"+index+"@gmail.com")
                .address("Tortuga")
                .description("Friend")
                .build();

        app.getContactHelper().openContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitButton();

    }

}
