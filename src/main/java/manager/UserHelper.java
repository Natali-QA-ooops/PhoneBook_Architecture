package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends  HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
        click(By.xpath("//a[@href='/login']"));
    }

    public void fillFormLogin(String email, String password){
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);
    }

    public void submitFormLogin() {
        click(By.xpath("//button[text()=' Login']"));
    }

    public void submitFormRegistration() {
        click(By.xpath("//button[text()=' Registration']"));
    }
}
