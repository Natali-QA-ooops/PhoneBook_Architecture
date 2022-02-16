package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (!app.getUserHelper().isSignOutPresent()) {
            app.getUserHelper().login(new User().withEmail("Tomy123456@mail.com").withPassword("Qq123666$45"));
        }
        // providerContact() ===> add 3
        app.getContactHelper().providerOfContacts();
    }

    @Test
    public void removeOneContact() {
        // countStart
        app.getContactHelper().removeOneContact();
        // countEnd
        // Asser  countStart-countEnd===> 1
    }

    @Test
    public void removeOneContactCount() {

        Assert.assertEquals(app.getContactHelper().removeOneContactCount(), -1);
    }

    @Test
    public void removeAllContactTest() {
        app.getContactHelper().removeAllContacts();
        Assert.assertTrue(app.getContactHelper().isContactsListIsEmpty());
    }

}
