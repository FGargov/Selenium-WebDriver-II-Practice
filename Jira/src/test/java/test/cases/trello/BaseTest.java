package test.cases.trello;

import com.telerikacademy.seleniumframework.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.jira.LoginPage;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    public static String timestamp;
    public static DateTimeFormatter dtf;

    UserActions actions = new UserActions();

    @BeforeClass
    public static void setUp() {

        UserActions.loadBrowser("jira.homePage");
    }

    @AfterClass
    public static void tearDown() {
        UserActions.quitDriver();
    }

    public void login() {
        LoginPage loginPage = new LoginPage(actions.getDriver());
        loginPage.loginUser("user");
    }

    @BeforeClass
    public static void timeStamping() {
        dtf = DateTimeFormatter.ISO_INSTANT;
        Instant time = Instant.now();
        timestamp = dtf.format(time);
    }
}
