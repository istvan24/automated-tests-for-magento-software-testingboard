package driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserCapabilities {

    public static Capabilities getBrowserCapabilities(String browser) {
        switch (browser) {
            case ("chrome"): {
                return getChromeCapabilities();
            }
            case ("firefox"): {
                return getFireFoxCapabilities();
            }
            case ("edge"): {
                return getEdgeCapabilities();
            }
        }
        return null;
    }

    //start the Chrome browsers maximized and in incognito
    private static ChromeOptions getChromeCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        return options;
    }

    //runs the test with Firefox browser headless
    private static FirefoxOptions getFireFoxCapabilities() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("headless");
        return options;
    }

    //start the Edge browsers maximized, not incognito
    private static EdgeOptions getEdgeCapabilities() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}