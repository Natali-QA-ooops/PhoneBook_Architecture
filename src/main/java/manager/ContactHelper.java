package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {

        type(By.cssSelector("[placeholder='Name']"),contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"),contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"),contact.getPhone());
        type(By.cssSelector("[placeholder='email']"),contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"),contact.getAddress());
        type(By.cssSelector("[placeholder='description']"),contact.getDescription());

    }

    public void submitButton() {
        click(By.xpath("//button[contains(.,'Save')]"));
    }





}
