package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void openContactForm() {
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {

        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void submitButton() {

        click(By.xpath("//button[contains(.,'Save')]"));
    }

    //метод возвращ count all contacts
    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }


    public boolean isContactCreateByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name))
                return true;
        }
        return false;
    }

    public boolean isContactCreateByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone))
                return true;
        }
        return false;
    }

    public void removeOneContact() {

        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));

    }


    public void providerOfContacts() {
        if (countOfContacts() < 3) {
            int index = (int) (System.currentTimeMillis() / 1000) % 3600;
            for (int i = 0; i < 3; i++) {

                Contact contact = Contact.builder()
                        .name("Zoa")
                        .lastName("Snow")
                        .phone("1212" + i + index)
                        .email("zoa" + i + index + "@gmail.com")
                        .address("Haifa")
                        .description("Friend").build();
                openContactForm();
                fillContactForm(contact);
                submitButton();
                pause(1000);
            }

        }
    }

    public int removeOneContactCount() {
        int countBefore = countOfContacts();
        logger.info("Before remove 'One contact tests' count was --->" + countBefore);

        if (!isContactsListIsEmpty()) {
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            logger.info("The phone number of removed contact was -->" + phone);

            wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            wd.findElement(By.xpath("//button[text()='Remove']")).click();
            pause(1000);
        }

        int countAfter = countOfContacts();
        logger.info("After remove one contact the count is --->" + countAfter);

        return countBefore - countAfter;
    }

    public boolean isContactsListIsEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

//    public void removeAllContactsNotWork() {
//        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
//
//        for (WebElement el : list) {
//            el.click();
//            wd.findElement(By.xpath("//button[text()='Remove']")).click();
//            pause(500);
//
//        }
//    }

    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
            removeOneContactCount();
        }

    }
}

