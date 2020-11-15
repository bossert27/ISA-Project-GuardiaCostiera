/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.SeleniumTest;

/**
 *
 * @author Marco
*/

import com.ap.GuardiaCostiera.GuardiaCostieraApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GuardiaCostieraApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumTest {

    private WebDriver driver;

    @BeforeClass
    public static void start() {
        final String webDriverPath = "C:\\Users\\Marco.DESKTOP-C4QDLLN\\Documents\\NetBeansProjects\\GuardiaCostiera\\chromedriver.exe";
        
        System.setProperty("webdriver.chrome.driver", webDriverPath);
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        //Collegamento localhost
        driver.get("http://localhost:8080");
        
        
        //Inserimento nuovo comandante
        driver.findElement(By.linkText("COMANDANTI")).click();
        driver.findElement(By.name("cf")).sendKeys("123abd");
        driver.findElement(By.name("cognome")).sendKeys("Travolta");
        driver.findElement(By.name("nome")).sendKeys("John");
        driver.findElement(By.id("salva")).click();
        
        //Inserimento nuova capitaneria
        driver.findElement(By.linkText("CAPITANERIE")).click();
        driver.findElement(By.name("codice_cap")).sendKeys("123456");
        driver.findElement(By.name("nome_cap")).sendKeys("Capitaneria");
        driver.findElement(By.name("comune")).sendKeys("Napoli");
        driver.findElement(By.name("indirizzo")).sendKeys("porto di Napoli");
        driver.findElement(By.name("telefono")).sendKeys("123456789");
        Select dropdownC = new Select(driver.findElement(By.id("cfCom")));
        dropdownC.selectByVisibleText("123abd");
        driver.findElement(By.id("salva")).click();
        
        //Inserimento nuova squadra
        driver.findElement(By.linkText("SQUADRE")).click();
        driver.findElement(By.name("codice_sq")).sendKeys("123456");
        driver.findElement(By.name("tipo")).sendKeys("Recupero");
        driver.findElement(By.name("numComp")).sendKeys("20");
        Select dropdownCap = new Select(driver.findElement(By.id("codCap")));
        dropdownCap.selectByVisibleText("123456");
        driver.findElement(By.id("salva")).click();
        
        //Inserimento nuovo componente
        driver.findElement(By.linkText("COMPONENTI")).click();
        driver.findElement(By.name("codice_com")).sendKeys("123456");
        driver.findElement(By.name("cognome")).sendKeys("Travolta");
        driver.findElement(By.name("nome")).sendKeys("John");
        Select dropdownSqT = new Select(driver.findElement(By.id("resp")));
        dropdownSqT.selectByVisibleText("False");
        Select dropdownSqC = new Select(driver.findElement(By.id("codSq")));
        dropdownSqC.selectByVisibleText("123456");
        driver.findElement(By.id("salva")).click();
        
        //Inserimento nuovo intervento
        driver.findElement(By.linkText("INTERVENTI")).click();
        driver.findElement(By.name("codice_int")).sendKeys("123456");
        driver.findElement(By.name("tipoInt")).sendKeys("Salvataggio");
        driver.findElement(By.name("data")).sendKeys("15/11/2019");
        Select dropdownSqI = new Select(driver.findElement(By.id("codSq")));
        dropdownSqI.selectByVisibleText("123456");
        driver.findElement(By.id("salva")).click();
        
        
        
        //Modifica Comandante
        driver.navigate().to("http://localhost:8080/edit/123456");
        driver.findElement(By.name("cf")).clear();
        driver.findElement(By.name("cf")).sendKeys("123abd");
        driver.findElement(By.name("cognome")).clear();
        driver.findElement(By.name("cognome")).sendKeys("mestesso");
        driver.findElement(By.name("nome")).clear();
        driver.findElement(By.name("nome")).sendKeys("maco");
        driver.findElement(By.id("salva")).click();
        
        
        //modifica Capitaneria
        driver.navigate().to("http://localhost:8080/editCap/123456");
        driver.findElement(By.name("codice_cap")).clear();
        driver.findElement(By.name("codice_cap")).sendKeys("123456");
        driver.findElement(By.name("nome_cap")).clear();
        driver.findElement(By.name("nome_cap")).sendKeys("Capitaneria");
        driver.findElement(By.name("comune")).clear();
        driver.findElement(By.name("comune")).sendKeys("Salerno");
        driver.findElement(By.name("indirizzo")).clear();
        driver.findElement(By.name("indirizzo")).sendKeys("Porto di Salerno");
        driver.findElement(By.name("telefono")).clear();
        driver.findElement(By.name("telefono")).sendKeys("123456789");
        Select dropdownCap2 = new Select(driver.findElement(By.id("cfCom")));
        dropdownCap2.selectByVisibleText("123abd");
        driver.findElement(By.id("salva")).click();
        
        //modifica Squadre
        driver.navigate().to("http://localhost:8080/editSq/123456");
        driver.findElement(By.name("codice_sq")).clear();
        driver.findElement(By.name("codice_sq")).sendKeys("123456");
        driver.findElement(By.name("tipo")).clear();
        driver.findElement(By.name("tipo")).sendKeys("Ispezione");
        driver.findElement(By.name("numComp")).clear();
        driver.findElement(By.name("numComp")).sendKeys("11");
        Select dropdownSq2 = new Select(driver.findElement(By.id("codCap")));
        dropdownSq2.selectByVisibleText("123456");
        driver.findElement(By.id("salva")).click();
        
        //Modifica componente
        driver.navigate().to("http://localhost:8080/editCom/123456");
        driver.findElement(By.name("codice_com")).clear();
        driver.findElement(By.name("codice_com")).sendKeys("123456");
        driver.findElement(By.name("cognome")).clear();
        driver.findElement(By.name("cognome")).sendKeys("Depp");
        driver.findElement(By.name("nome")).clear();
        driver.findElement(By.name("nome")).sendKeys("Johnny");
        Select dropdownSqT2 = new Select(driver.findElement(By.id("resp")));
        dropdownSqT2.selectByVisibleText("True");
        Select dropdownSqC2 = new Select(driver.findElement(By.id("codSq")));
        dropdownSqC2.selectByVisibleText("123456");
        driver.findElement(By.id("salva")).click();
        
        //Modifica componente
        driver.navigate().to("http://localhost:8080/editInt/123456");
        driver.findElement(By.name("codice_int")).clear();
        driver.findElement(By.name("codice_int")).sendKeys("123456");
        driver.findElement(By.name("tipoInt")).clear();
        driver.findElement(By.name("tipoInt")).sendKeys("Recupero");
        driver.findElement(By.name("data")).clear();
        driver.findElement(By.name("data")).sendKeys("01/10/1990");
        Select dropdownSqI2 = new Select(driver.findElement(By.id("codSq")));
        dropdownSqI2.selectByVisibleText("123456");
        driver.findElement(By.id("salva")).click();
        
        
        
        //Cancella Interventi
        driver.navigate().to("http://localhost:8080/deleteInt/123456");
        driver.findElement(By.id("cancella")).click();
        
        //Cancella Componenti
        driver.navigate().to("http://localhost:8080/deleteCom/123456");
        driver.findElement(By.id("cancella")).click();
        
        //Cancella Squadre
        driver.navigate().to("http://localhost:8080/deleteSq/123456");
        driver.findElement(By.id("cancella")).click();
        
        //Cancella Capitaneria
        driver.navigate().to("http://localhost:8080/deleteCap/123456");
        driver.findElement(By.id("cancella")).click();
        
        //Cancella comandante
        driver.navigate().to("http://localhost:8080/delete/123abd");
        driver.findElement(By.id("cancella")).click();
        
    }
    
    @After
    public void tearDown() {
     driver.quit();
    }

}
