package praticaRunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
    features = "src/test/resources/BDD.feature",
    glue = "praticaSteps",
    plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
    monochrome = true,
    dryRun = false
    

    
)
public class Runner {

	
	
    @BeforeClass
    public static void reset() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Trabalho\\Desktop\\novoChromeDriver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
        driver.get("https://seubarriga.wcaquino.me/login");
        driver.findElement(By.id("email")).sendKeys("Eumesmo@Eumesmo");
        driver.findElement(By.name("senha")).sendKeys("Eusenha");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }

  
  
}
