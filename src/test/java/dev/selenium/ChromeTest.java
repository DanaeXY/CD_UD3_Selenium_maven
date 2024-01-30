package dev.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeTest{

 static ChromeDriver driver;//abre ventana de chrome para probar app o pagweb

 @BeforeAll//antes de cualquier test ejecuta este método, así no es necesario llamarlo
 public static void start(){//no queremos repetición así que declaramos nuevo método estatico y la variable ChromeDriver tb static
   ChromeOptions options = new ChromeOptions();
   options.addArguments("start-maximized");
   driver = new ChromeDriver(options);
   driver.get("https://www.selenium.dev/selenium/web/web-form.html");
 }

 @AfterAll//se coloca al final del programa por lógica
 public static void end(){
   try {
      Thread.sleep(2000);
   } catch (Exception e) {
      e.printStackTrace();
   }
   driver.quit();
 }

 @Test  
 public void basicOptions(){
    
    //System.out.println(driver.getTitle());
    WebElement textInput = driver.findElement(By.id("my-text-id"));//buscar un id por su nombre
    textInput.sendKeys("vanessa");//para probarlo escribimos algo y debemos incluir después el thread

    /*try {
      Thread.sleep(3000);
   } catch (InterruptedException e) {
      
      e.printStackTrace();
   }*/

   WebElement button = driver.findElement(By.className("btn-outline-primary"));//en caso de ser clase, copiar únicamente el nombre central(caso contrario: excepción)
   button.click();
   /*try {
      Thread.sleep(5000);
   } catch (InterruptedException e) {
      
      e.printStackTrace();
   }*/

   WebElement mensaje = driver.findElement(By.id("message"));
   System.out.println(mensaje.getText());

   assertEquals("Received!", mensaje.getText());//primer parámetro (lo que esperas) exactamente igual al segundo parámetro (la variable anteriormente creada)

 }

   @Test  
   public void elementsForms() throws InterruptedException{
      ChromeOptions options = new ChromeOptions();
      driver = new ChromeDriver(options);
      driver.get("https://www.selenium.dev/selenium/web/web-form.html");

      /*WebElement checked = driver.findElement(By.id("my-check-1"));
      checked.click();
      Thread.sleep(2000);
      
      assertTrue(checked.isSelected());//introducir en un sout si deseamos respuesta, si es true no devuelve nada*/

      WebElement desabledInput = driver.findElement(By.name("my-disabled"));
      String textTest = "Test";
      desabledInput.sendKeys("Lunes por la mañana");
      assertEquals(textTest, desabledInput.getText());
      Thread.sleep(2000);

      
      //driver.quit();
   }

   @Test  
   public void elementDisableForms() throws InterruptedException{
      ChromeOptions options = new ChromeOptions();
      driver = new ChromeDriver(options);
      driver.get("https://www.selenium.dev/selenium/web/web-form.html");

      /*WebElement checked = driver.findElement(By.id("my-check-1"));
      checked.click();
      Thread.sleep(2000);
      
      assertTrue(checked.isSelected());//introducir en un sout si deseamos respuesta, si es true no devuelve nada*/
      try {
         WebElement desabledInput = driver.findElement(By.name("my-disabled"));
         desabledInput.sendKeys("Lunes por la mañana");
      
         Thread.sleep(2000);
      } catch (Exception e) {
         
      }
      //driver.quit();

   }
   @Test  
   public void elementUploadForms() throws InterruptedException{//carga de archivo
      ChromeOptions options = new ChromeOptions();
      driver = new ChromeDriver(options);
      String archivo = "Loro.jpeg";
      driver.get("https://the-internet.herokuapp.com/upload");

      File uploadFile = new File("src/Files/"+archivo);/*absoluta: /home/sanclemente.local/a23vanessabg/Escritorio/CD_UD3_Selenium_maven/src/Files/Loro.jpeg */
      WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));//pasar solo el tipo que queremos
      fileInput.sendKeys(uploadFile.getAbsolutePath());//ruta absoluta NO porque solo funcionaría en este ordenador
      
      Thread.sleep(1000);

      driver.findElement(By.id("file-submit")).click();//forma abreviada de hacer click en lugar de crear el elemento
      //buttonElement.click();
      Thread.sleep(2000);

      WebElement fileName = driver.findElement(By.id("uploaded-files"));
      assertEquals(archivo, fileName.getText());//comparará el esperado "Loro.jpeg" con el nombre que devuelve la página como nombre de archivo
      /*escribir "Loro.jpeg" se denomina LITERAL no es aconsejable */
      
   }

}