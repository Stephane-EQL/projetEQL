package com.projetEQL;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConnexionWebdriver extends OutilsGeneraux implements IConstantes {

	ENavigateur nav = ENavigateur.chrome;
	WebDriver driver;
	WebDriverWait wait;

	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ConnexionWebdriver.class);

	@Test
	public void miseEnConditionsInitiales() throws InterruptedException {
		driver = OutilsGeneraux.choisirNavigateur(nav);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		logger.info("Accès à la page d'authentification");
		driver.get(URLSite);
		assertEquals("Google", driver.getTitle());
	}

	@After
	public void cloture() {
		logger.info("Test terminé ou interrompu - Fermeture du WebDriver");
		driver.quit();
	}
}