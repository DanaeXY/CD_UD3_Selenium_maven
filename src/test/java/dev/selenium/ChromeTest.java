package dev.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeTest{

 ChromeDriver driver;//abre ventana de chrome para probar app o pagweb

 @Test  
 public void test(){
    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");//url que deseas probar, si está en local se llamará desde local

    /*try {
      Thread.sleep(5000);//debe lanzarse la excepción. Abrirá la ventana y la cerrará a los 5 seg
   } catch (InterruptedException e) {
      
      e.printStackTrace();
   }*/
    //System.out.println(driver.getTitle());
    WebElement textInput = driver.findElement(By.id("my-text-id"));//buscar un id por su nombre
    textInput.sendKeys("vanessa");//para probarlo escribimos algo y debemos incluir después el thread

    try {
      Thread.sleep(3000);
   } catch (InterruptedException e) {
      
      e.printStackTrace();
   }

   WebElement button = driver.findElement(By.className("btn-outline-primary"));//en caso de ser clase, copiar únicamente el nombre central(caso contrario: excepción)
   button.click();
   try {
      Thread.sleep(5000);
   } catch (InterruptedException e) {
      
      e.printStackTrace();
   }

   WebElement mensaje = driver.findElement(By.id("message"));
   System.out.println(mensaje.getText());

   assertEquals("Received!", mensaje.getText());//primer parámetro (lo que esperas) exactamente igual al segundo parámetro (la variable anteriormente creada)
   try {
      Thread.sleep(2000);
   } catch (InterruptedException e) {
      
      e.printStackTrace();
   }


    driver.quit();//cierra la ventana
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

      
      driver.quit();
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

      WebElement desabledInput = driver.findElement(By.name("my-disabled"));
      desabledInput.sendKeys("Lunes por la mañana");
      
      Thread.sleep(2000);

      
      driver.quit();
   }


}