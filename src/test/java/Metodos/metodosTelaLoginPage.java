package Metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class metodosTelaLoginPage {

	WebDriver web;

	// abrir computador
	public void abrirNavegadoESite(String url) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		web = new ChromeDriver();
		web.manage().window().maximize();
		web.get(url);
	}

	// de clicar
	public void clicar(By elemento) {
		web.findElement(elemento).click();
	}

	// metodo de preencher
	public void preencherTexto(By elemento, String texto) {
		web.findElement(elemento).sendKeys(texto);
	}

	// Metodo de pausar
	public void pausar(int tempo) throws InterruptedException {
		Thread.sleep(tempo);
	}

	// metodo de fechar navegador

	public void fecharNavegador() {
		web.quit();
	}

	public void validarTexto(By elemento , String texto) {
	     String mensagem = web.findElement(elemento).getText();
	     assertEquals(texto, mensagem);	    		 
	}
	
	public void tirarPrint(String nome) throws IOException {
		TakesScreenshot print = ((TakesScreenshot) web);
		File SrcFile = print.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("./src/evidencias" + nome + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}

}
