package br.com.rocketskills.petlov;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class Cadastro {

	/**
	 * 
	 */
	@Test
	@DisplayName("Deve poder cadastrar um ponto de doação")
	void createPoint() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://petlov.vercel.app/signup");

		WebElement title = driver.findElement(By.cssSelector("h1"));

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> title.isDisplayed());


		assertEquals("Cadastro de ponto de doação", title.getText(), "Verificando o Slogan");



		WebElement donationPointNameInput = driver.findElement(By.cssSelector("input[placeholder='Nome do ponto de doação']"));
		donationPointNameInput.sendKeys("Baeta Neves");
		
		WebElement EmailInput = driver.findElement(By.cssSelector("input[name=email]"));
		EmailInput.sendKeys("leandrodomingos35@hotmail.com");

		WebElement CepInput = driver.findElement(By.cssSelector("input[name=cep]"));
		CepInput.sendKeys("09760380");

		WebElement cepButton = driver.findElement(By.cssSelector("input[value='Buscar CEP']"));
		cepButton.click();

		WebElement numberInput = driver.findElement(By.cssSelector("input[name=addressNumber]"));
		numberInput.sendKeys("500");

		driver.findElement(By.xpath("//span[text()='Cachorros']/..")).click();

		driver.findElement(By.className("button-register")).click();



		driver.close();
		
	}
}
