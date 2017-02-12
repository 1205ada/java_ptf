package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Ada on 2017-01-28.
 */
public class HomePage {

  private WebDriver driver;

  @FindBy (how = How.XPATH, using = ".//*[@id='block_top_menu']/u1/li")
  public List<WebElement> menuItems;

  public HomePage(WebDriver driver){
    this.driver = driver;
    this.initializePageElements();
  }

  public void initializePageElements() {
    PageFactory.initElements(driver, this);
  }

  public void clickOnMenuItem(int index){
    menuItems.get(index).click();
  }
}
