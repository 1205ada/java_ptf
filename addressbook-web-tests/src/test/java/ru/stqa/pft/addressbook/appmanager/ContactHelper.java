package ru.stqa.pft.addressbook.appmanager;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitForm() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData/*, boolean creation*/) {
    type(By.name("firstname"), contactData.getFirstname());
    //type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    //type(By.name("nickname"), contactData.getNickname());
   // type(By.name("address"), contactData.getAddress());


   /* if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }*/
  }

  public void goToNewContact() {
    click(By.linkText("nowy wpis"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void secondSubmit() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitModificationForm() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void goToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("strona główna"));
  }

  public void createContact(ContactData contact) {
    goToNewContact();
    fillContactForm(contact/*, true*/);
    submitForm();
    goToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String name = wd.findElement(By.xpath("//tr[@name='entry']/td[3]")).getText();
      String name2 = wd.findElement(By.xpath("//tr[@name='entry']/td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      ContactData contact = new ContactData(id, name, name2);
      contacts.add(contact);
    }
    return contacts;
  }
}
