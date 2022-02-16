package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper userHelper;
    ContactHelper contactHelper;
    String browser;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        //wd = new ChromeDriver();

        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("All tests starts in 'Chrom' browser");
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests starts in 'FIREFOX' browser");
        }else if(browser.equals(BrowserType.EDGE)){
            wd = new EventFiringWebDriver(new EdgeDriver());
            logger.info("All tests starts in 'EDGE' browser");
        }

        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wd.register(new MyListener());

        userHelper = new UserHelper(wd);
        contactHelper = new ContactHelper(wd);
    }
    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
    public void stop() {
        wd.quit();
    }


}
