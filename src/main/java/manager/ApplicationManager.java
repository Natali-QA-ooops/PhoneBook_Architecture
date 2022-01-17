package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;

    public void init() {
        wd=new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().window().maximize();

        userHelper=new UserHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
}
