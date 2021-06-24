package com.projetEQL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class connexion {

	public static void main(String[] args) throws InterruptedException {

		String ChromeDriverPath = "C:\\Users\\formation\\Driver\\91\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);

		WebDriver driver = new ChromeDriver();

		try {
			//charger le page
			driver.get("https://google.com");

			// Attendre 5 minutes sur pas de réponse => Exception
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

			//Vérifier le titre
			if (driver.getTitle().equalsIgnoreCase("Google")) {
				System.out.println("le titre contient Google");
			} else {System.out.println("la page google est introuvable");
			}
			Thread.sleep(2000);

			//Naviguer vers Bing
			driver.navigate().to("https://wwww.bing.com");
			if (driver.getTitle().equalsIgnoreCase("Bing")) {
				System.out.println("le titre contient Bing");
			} else {System.out.println("la page Bing est introuvable");
			}
			Thread.sleep(2000);

			//Revenir dans l'historique de Google
			driver.navigate().back();

			if (driver.getTitle().equalsIgnoreCase("Google")) {
				System.out.println("le titre contient Google");
			} else {System.out.println("la page google est introuvable");
			}
			Thread.sleep(2000);
		}

		finally {
			driver.quit();
		}

	}
}

