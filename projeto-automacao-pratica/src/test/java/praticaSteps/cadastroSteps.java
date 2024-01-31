package praticaSteps;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;


import io.cucumber.java.AfterAll;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;



public class cadastroSteps {

	private static WebDriver driver;
	
@Dado("que estou acessando a aplicação")
public void que_estou_acessando_a_aplicação() {
		
	  ChromeOptions options = new ChromeOptions();
      options.addArguments("--start-maximized");
      driver = new ChromeDriver(options);
      driver.get("https://seubarriga.wcaquino.me/login");
  
}


@Quando("informo o usuário {string}")
public void informo_o_usuário(String arg1) {
	 if (driver == null) {
	        throw new RuntimeException("O driver não foi inicializado. Certifique-se de chamar que_estou_acessando_a_aplicação antes de informoOUsuario.");
	    }
	    driver.findElement(By.id("email")).sendKeys(arg1);
	}


@Quando("a senha {string}")
public void a_senha(String  arg1) throws Throwable {
	driver.findElement(By.name("senha")).sendKeys(arg1);
}

@Quando("seleciono entrar")
public void seleciono_entrar() {
	driver.findElement(By.tagName("button")).click();
}

@Então("visualizo a página inicial")
public void visualizo_a_página_inicial() {
	String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	Assert.assertEquals("Bem vindo, Eumesmo!", texto); 
}

@Quando("seleciono Contas")
public void seleciono_contas() {
	 driver.findElement(By.linkText("Contas")).click();
		}

@Quando("seleciono Adicionar")
public void seleciono_adicionar() {
	 driver.findElement(By.linkText("Adicionar")).click();
}

@Quando("informo a conta {string}")
public void informo_a_conta(String arg1) throws Throwable {
	driver.findElement(By.id("nome")).sendKeys("contateste");
}

@Quando("seleciono Salvar")
public void seleciono_salvar() {
	driver.findElement(By.tagName("button")).click();
}

@Então("a conta é inserida com sucesso")
public void a_conta_é_inserida_com_sucesso() {
	String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	Assert.assertEquals("Conta adicionada com sucesso!", texto);
	File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(screenshotAs, new File("img1.png"));
	}catch (IOException e) {
		e.printStackTrace();
	}
	driver.quit();
} 
@Então("sou notificado que o nome da conta é obrigatório")
public void sou_notificado_que_o_nome_da_conta_é_obrigatório() {
	String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	Assert.assertEquals("Informe o nome da conta", texto);
	File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(screenshotAs, new File("img2.png"));
	}catch (IOException e) {
		e.printStackTrace();
	}
}



//@After
//public  void Screenshot(Scenario Cenario) {
//    File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//    try {
//         FileUtils.copyFile(file, new File("target/screenshot/" + Cenario.getId() + ".jpg"));
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}

@AfterAll
public static void fecharBrowser() {
    if (driver != null) {
        driver.quit();
    }
}
}