package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getUserHelper().isLogged()){
            app.getUserHelper().login(new User().withEmail("Tomy123456@mail.com").withPassword("Qq123666$45"));
        }
        if (app.getContactHelper().countOfContacts()>20){
            app.getContactHelper().removeAllContacts();
        }
    }


    @Test(groups = {"web"})
    public void addNewContactSuccess(){

        int countStart = app.getContactHelper().countOfContacts();

        logger.info("The test 'Add new contact' start with count of contact in start --->"+countStart);

        int index = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Maya"+index)
                .lastName("Foot")
                .phone("1234567"+index)
                .email("maya"+index+"@gmail.com")
                .address("Tel-Aviv")
                .description("friend")
                .build();
        logger.info("The test 'Add new contact' start with data ---->" +contact.toString());
        app.getContactHelper().openContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitButton();

        int countEnd = app.getContactHelper().countOfContacts();

        logger.info("The test 'Add new contact' end with count of contact in the end --->"+countEnd);

        // if countStart - countEnd = -1
        Assert.assertEquals(countEnd-countStart,1);
        // if list contact with name + phone

        Assert.assertTrue(app.getContactHelper().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactCreateByPhone(contact.getPhone()));
    }


    @Test (dataProvider = "addContactValidDataIsFile",dataProviderClass = MyDataProvider.class,enabled = false)
    public void addNewContactSuccessNew(Contact contact){

        int countStart = app.getContactHelper().countOfContacts();
        logger.info("The test 'Add new contact' start with count of contact in start --->"+countStart);
        logger.info("The test 'Add new contact' start with data ---->" +contact.toString());

        app.getContactHelper().openContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitButton();


        int countEnd = app.getContactHelper().countOfContacts();
        logger.info("The test 'Add new contact' end with count of contact in the end --->"+countEnd);

        Assert.assertEquals(countEnd-countStart,1);
        Assert.assertTrue(app.getContactHelper().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactCreateByPhone(contact.getPhone()));
    }


    @Test (dataProvider = "addContactValidDataModel",dataProviderClass = MyDataProvider.class,enabled = false)
    public void addNewContactSuccessDT(Contact contact){

        int countStart = app.getContactHelper().countOfContacts();

        logger.info("The test 'Add new contact' start with count of contact in start --->"+countStart);

        logger.info("The test 'Add new contact' start with data ---->" +contact.toString());
        app.getContactHelper().openContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitButton();


        int countEnd = app.getContactHelper().countOfContacts();

        logger.info("The test 'Add new contact' end with count of contact in the end --->"+countEnd);

        // if countStart - countEnd = -1
        Assert.assertEquals(countEnd-countStart,1);
        // if list contact with name + phone

        Assert.assertTrue(app.getContactHelper().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactCreateByPhone(contact.getPhone()));
    }
}
