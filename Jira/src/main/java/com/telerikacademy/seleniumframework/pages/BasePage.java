package com.telerikacademy.seleniumframework.pages;

import com.telerikacademy.seleniumframework.UserActions;
import com.telerikacademy.seleniumframework.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected String url;
    protected WebDriver driver;
    public UserActions actions;

    public BasePage(WebDriver driver, String urlKey) {
        String pageUrl = Utils.getConfigPropertyByKey(urlKey);
        this.driver = driver;
        this.url = pageUrl;
        actions = new UserActions();
    }

    public String getUrl() {
        return url;
    }

    public void navigateToPage() {
        this.driver.get(url);
    }

    public void assertPageNavigated() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Landed URL is not as expected. Actual URL: " + currentUrl + ". Expected URL: " + url,
            currentUrl.contains(url));
    }
}
