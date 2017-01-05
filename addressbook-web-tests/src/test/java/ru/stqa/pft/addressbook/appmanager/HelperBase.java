package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;

/**
 * Created by Ada on 2016-12-17.
 */
public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    WebElement e = wd.findElement(locator);
    if (text != null){
      String existingText = e.getAttribute("value");
      if (! text.equals(existingText)) {
        e.clear();
        e.sendKeys(text);
      }
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By locator) {
      try {
        wd.findElement(locator);
        return true;
      } catch (org.openqa.selenium.NoSuchElementException ex) {
        return false;
      }
  }
}
