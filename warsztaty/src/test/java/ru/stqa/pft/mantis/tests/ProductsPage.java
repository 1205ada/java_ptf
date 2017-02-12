package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Ada on 2017-01-28.
 */
public class ProductsPage {

  private static WebDriver driver;


  public ProductsPage(WebDriver driver) {
    this.driver = driver;
    this.initializePageElements();
  }

  @FindBy(how = How.ID, using = "selectProductSort")
  public WebElement sortSelect;

  @FindBy(how = How.XPATH, using = ".//*[@id='center_column']")
  public WebElement productsContainer;

  public void initializePageElements() {
    PageFactory.initElements(driver, this);
  }

  public void sortByValue(String value) {
    Select selectElement = new Select(sortSelect);
    selectElement.selectByValue(value);
  }

  public List<WebElement> getProductNamesElementsFromProductList() {
    return productsContainer.findElements(By.className("product-name"));
  }

 // public List<String>


}
