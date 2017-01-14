/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

waiting {
    timeout = 15
}


environments {

    chrome {
        driver = { new ChromeDriver() }
    }

    firefox {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox()
            new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities)
        }
    }

}
// To run the tests with all browsers just run “./gradlew test”

baseUrl = "https://getbase.com/"
