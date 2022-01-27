package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {

        super(wd);
    }

    public void openLoginRegistrationForm() {

        click(By.xpath("//a[@href='/login']"));
    }

    public void fillFormLoginRegistration(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void fillFormLoginRegistration(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void submitFormLogin() {
        click(By.xpath("//button[text()=' Login']"));
    }

    public void submitFormRegistration() {
        click(By.xpath("//button[text()=' Registration']"));
    }

    public boolean isRegSuccess() {
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".contact-page_message__2qafk"))));


        WebElement mas = wd.findElement(By.cssSelector("h2"));
        String txt = mas.getText();
        return txt.equals("Add new by clicking on Add in NavBar!");

        //        WebElement button = wd.findElement(By.xpath("//button[text()='Sign Out']"));
        //        String txt = button.getText();
        //        return txt.equals("Sign Out");

    }

    public boolean isLoginSuccess() {
//        WebElement button = wd.findElement(By.xpath("//button[text()='Sign Out']"));
//        String txt = button.getText();
//        return txt.equals("Sign Out");

        WebElement el = wd.findElement(By.xpath("//a[@href='/contacts']"));
        String txt = el.getText();
        return txt.equals("CONTACTS");

    }

    public boolean isSignOutPresent() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void signOut() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillFormLoginRegistration(user);
        submitFormLogin();
    }
}
