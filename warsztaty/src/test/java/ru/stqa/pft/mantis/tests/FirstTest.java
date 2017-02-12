package ru.stqa.pft.mantis.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * Created by Ada on 2017-01-28.
 */
public class FirstTest {

  private static String testString = "";
  private static WebDriver driver;
  private static String buggy = "Buggy";
  private static String title = "";
  private static WebElement element;

  @BeforeClass
  public static void beforeClass() {
    System.out.println("Before test.....");
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ada\\Downloads\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    //testString = RandomStringUtils.randomAlphanumeric(20);
    //System.out.println(testString);
  }

  @Before
  public static void before() {
    System.out.println("Before.....");
  }

  @Test
  public void firstTest() {
    driver.get("http://asta.pgs-soft.com");
    //sleep(1000);
    //String something = "some string";
    //assertTrue(testString.contains("a"));
    //assertTrue(something.contains("some"));
    title = driver.getTitle();
    //System.out.println(sources);
    assertThat(title, containsString("Automated Software Testing"));
  }

  @Test
  public void firstTest1() {
    String sources = driver.getPageSource();
    //String something1 = "some string";
    //assertThat(something1, containsString("some"));
    Assert.assertEquals(sources.contains("Buggy"), true);
  }

  @Test
  public void firstTest2() {
    driver.get("https://testingcup.pgs-soft.com/task_1");
    WebDriverWait waitDriver = new WebDriverWait(driver,1000);
    driver.findElement(By.className("form-control")).clear();
    driver.findElement(By.className("form-control")).sendKeys("10");
    WebElement element = driver.findElements(By.cssSelector("button[id*='add-product']")).get(0);
    waitDriver.until(ExpectedConditions.elementToBeClickable(element));


    element.click();
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.className("col-md-9")));

    String itemInBasket = driver.findElement(By.className("col-md-9")).getText();
    assertThat(itemInBasket, containsString("Okulary"));
  }

  @Test
  public void firstTest3() {
    driver.findElements(By.className("form-control")).get(1).clear();
    driver.findElements(By.className("form-control")).get(1).sendKeys("3");
    WebElement element2 = driver.findElements(By.cssSelector("button[id*='add-product']")).get(1);
    element2.click();

    String itemInBasket2 = driver.findElements(By.className("col-md-9")).get(1).getText();
    assertThat(itemInBasket2, containsString("Piłka"));
  }

  @Test
  public void firstTest4() {
    driver.get("https://testingcup.pgs-soft.com/task_9");
    WebElement element2 = driver.findElement(By.id("j1_1_anchor"));
    Actions actions = new Actions(driver);
    actions.contextClick(element2).build().perform();

    WebDriverWait driverWait = new WebDriverWait(driver, 1000);

    driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("vakata-context-hover"))));

    driver.findElement(By.className("vakata-context-hover")).click();
    driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("jstree-rename-input"))));
    driver.findElement(By.className("jstree-rename-input")).clear();
    driver.findElement(By.className("jstree-rename-input")).sendKeys("lalala");
    driver.findElement(By.className("jstree-rename-input")).sendKeys(Keys.ENTER);

    WebElement a = driver.findElement(By.className("col-md-9"));
    WebElement b = a.findElement(By.tagName("h1"));
    assertThat(b.getText(), equalTo("lalala"));
    //assertThat(driver.findElement(By.className("col-md-9")).getText(), containsString("lalala"));
  }

  /*@Test
  public void firstTest5() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://demoqa.com/droppable/");

    driver.findElement(By.id("draggableview"));
  }*/

  @Test
  public void firstTest6() {
    driver.get("http://automationpractice.com/");

    /*public List<WebElement> getMenuItem() {
      return driver.findElements(By.className("af-with-ui"));
    }

    @FindBy(how = How.CLASS_NAME, using = "af-with-ui")
            public List<WebElement> menuItems;


    public void clickOnMenuItem(int index){
      menuItems.get(index)*/
    driver.findElement(By.className("sf-with-ul")).click();
    //driver.findElement(By.cssSelector(".//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
  }

  @AfterClass
  public static void afterClass() {
    System.out.println("After.....");
    driver.close();
    driver.quit();
  }

}
