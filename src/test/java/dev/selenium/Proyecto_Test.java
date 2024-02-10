package dev.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Proyecto_Test{

 static ChromeDriver driver;//abre ventana de chrome para probar app o pagweb

 @BeforeAll//antes de cualquier test ejecuta este método, así no es necesario llamarlo
 public static void start(){//no queremos repetición así que declaramos nuevo método estatico y la variable ChromeDriver tb static
   ChromeOptions options = new ChromeOptions();
   options.addArguments("start-maximized");
   driver = new ChromeDriver(options);
   driver.get("https://www.maquillalia.com/");
 }

 @AfterAll//se coloca al final del programa por lógica
 public static void end(){
   try {
      Thread.sleep(5000);
   } catch (Exception e) {
      e.printStackTrace();
   }
   driver.quit();
 }

 public static void buscarArticulo(){
   WebElement search = driver.findElement(By.id("buscar"));
      search.sendKeys("Duraline");
      search.sendKeys(Keys.ENTER);

 }

/*pruebas con web maquillalia.com */

   @Test  
   public void CPF1() throws InterruptedException{
      ChromeOptions options = new ChromeOptions();
      driver = new ChromeDriver(options);
      driver.get("https://www.maquillalia.com/");

      /*WebElement checked = driver.findElement(By.id("my-check-1"));
      checked.click();
      Thread.sleep(2000);
      
      assertTrue(checked.isSelected());//introducir en un sout si deseamos respuesta, si es true no devuelve nada*/


      WebElement search = driver.findElement(By.name("buscar"));
      search.sendKeys("Eyeliner");
      search.sendKeys(Keys.ENTER);
      

   }

   @Test  
   public void CPF2() throws InterruptedException{
      ChromeOptions options = new ChromeOptions();
      driver = new ChromeDriver(options);
      driver.get("https://www.maquillalia.com/");

      WebElement search = driver.findElement(By.name("buscar"));
      search.sendKeys("Corazona");
      search.sendKeys(Keys.ENTER);

      WebElement categoria = driver.findElement(By.className("tab-item"));
      categoria.click();
     
   
   }

   @Test
   public void CPF3() throws InterruptedException{
      buscarArticulo();//duraline
      WebElement producto = driver.findElement(By.xpath(".//a[@class=\"mgp-ajax Button Buy\"]"));
      producto.click();

   }

   @Test
   public void CPF4() throws InterruptedException{
      Thread.sleep(3000);

      WebElement usuario = driver.findElement(By.xpath(".//div[@class=\"lgin tt tt-3 mhide\"]"));
      usuario.click();

      WebElement email = driver.findElement(By.xpath(".//div[@name=\"email_address\"]"));
      email.sendKeys("abuela.gmail.com");
      WebElement submit = driver.findElement(By.xpath(".//input[@class=\"mt-auto\"]"));
      submit.click();


   }

   @Test
   public void CPF5() throws InterruptedException{
      WebElement button = driver.findElement(By.id("cbcr-crrt"));
      button.click();
   }

 @Test
   public void CPF6() throws InterruptedException{
      Thread.sleep(3000);

      buscaArticulo();
      WebElement button = driver.findElement(By.xpath(".//div[@class="BuyCn"]"));
      button.click();
      WebElement basket = driver.findElement(By.xpath(".//i[@class="tt tt-7"]"));
      basket.click();
      WebElement buttonBasket = driver.findElement(By.xpath(".//a[@class="bbuy"]"));
      buttonBasket.click();
      WebElement buttonBuy = driver.findElement(By.xpath(".//a[@class="Button Fnsh"]"));
      buttonBuy.click();
      WebElement buttonNotRegister = driver.findElement(By.xpath(".//span[@class="CestaFoot Btns"]"));
      buttonNotRegister.click();
      WebElement input = driver.findElement(By.Name(".//input[@name="firstname"]"));
      input.sendKeys("X");
      WebElement input2 = driver.findElement(By.Name(".//input[@name="lastname"]"));
      input2.sendKeys("X");
      WebElement inputEmail = driver.findElement(By.Name(".//input[@name="email_address"]"));
      inputEmail.sendKeys("abuela@yahoo.es");
      WebElement inputTelf = driver.findElement(By.Name(".//input[@name="telephone"]"));
      inputTelf.sendKeys("666666666");
      WebElement inputAdress = driver.findElement(By.Name(".//input[@name="street_address"]"));
      inputTelf.sendKeys("calle calleja");
      WebElement inputCountry = driver.findElement(By.Name(".//select[@name="country"]"));
      inputCountry.Select("");//.//option[@value="195"]
      WebElement inputCity = driver.findElement(By.Name(".//select[@name="zone_id"]"));
      inputCountry.Select("");//.//option[@value="130"];
      WebElement inputTown = driver.findElement(By.Name(".//input[@name="city"]"));
      inputTown.sendKeys("xxxxxx");
      WebElement checkBox = driver.findElement(By.xpath(".//input[@name="termsAgree"]"));
      checkBox.click();
      WebElement buttonNext = driver.findElement(By.xpath(".//input[@class="button verde tblanco hv9"]"));
      buttonNext.click();
      
      
   }
   

/*xpath--chrome ctrl+F*/

   /*@Test  
   public void basicOptions(){
      
      //System.out.println(driver.getTitle());
      WebElement textInput = driver.findElement(By.id("my-text-id"));//buscar un id por su nombre
      textInput.sendKeys("vanessa");//para probarlo escribimos algo y debemos incluir después el thread
  
  
     WebElement button = driver.findElement(By.className("btn-outline-primary"));//en caso de ser clase, copiar únicamente el nombre central(caso contrario: excepción)
     button.click();
     
  
     WebElement mensaje = driver.findElement(By.id("message"));
     System.out.println(mensaje.getText());
  
     assertEquals("Received!", mensaje.getText());//primer parámetro (lo que esperas) exactamente igual al segundo parámetro (la variable anteriormente creada)
  
   }

   @Test  
   public void elementUploadForms() throws Exception{//carga de archivo
      ChromeOptions options = new ChromeOptions();
      driver = new ChromeDriver(options);
      String archivo = "Loro.jpeg";
      driver.get("https://the-internet.herokuapp.com/upload");

      File uploadFile = new File("src/Files/"+archivo);/*absoluta: /home/sanclemente.local/a23vanessabg/Escritorio/CD_UD3_Selenium_maven/src/Files/Loro.jpeg 
      WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));//pasar solo el tipo que queremos
      fileInput.sendKeys(uploadFile.getAbsolutePath());//ruta absoluta NO porque solo funcionaría en este ordenador
      
      Thread.sleep(1000);

      driver.findElement(By.id("file-submit")).click();//forma abreviada de hacer click en lugar de crear el elemento
      //buttonElement.click();
      Thread.sleep(2000);

      WebElement fileName = driver.findElement(By.id("uploaded-files"));
      assertEquals(archivo, fileName.getText());//comparará el esperado "Loro.jpeg" con el nombre que devuelve la página como nombre de archivo
      /*escribir "Loro.jpeg" se denomina LITERAL no es aconsejable 
      
   }

   @Test
   public void elementSelectForms() throws Exception{//clase Select solo con Selenium

      WebElement select = driver.findElement(By.name("my-select"));//recoger el nombre del elemento
      Select comboSelect = new Select(select);//crear el objeto Select
      comboSelect.selectByIndex(1);//selecciona el indice que lo que queremos probar, empieza siempre en 0

   }

   @Test
   public void dateSelectForms() throws Exception{
      WebElement calendar = driver.findElement(By.name("my-date"));
      calendar.sendKeys("01/30/2024"); //envío para prueba, depende del popup
      calendar.sendKeys(Keys.TAB);//pulsar tecla tabulador para que cierre el popup
   }


   @Test
   public void radioSelectForms() throws Exception{}*/

}
