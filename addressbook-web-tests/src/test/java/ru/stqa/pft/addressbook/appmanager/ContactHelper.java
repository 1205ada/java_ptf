package ru.stqa.pft.addressbook.appmanager;

import com.sun.jna.platform.win32.WinUser;
import com.thoughtworks.selenium.webdriven.commands.KeyPressNative;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupContact;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillForm(GroupContact groupContact) {
      type(By.name("firstname"), groupContact.getFirstname());
      type(By.name("middlename"),groupContact.getMiddlename());
      type(By.name("lastname"),groupContact.getLastname());
      type(By.name("nickname"),groupContact.getNickname());
      type(By.name("address"),groupContact.getAddress());
      type(By.name("email"),groupContact.getEmail());
  }

  public void goToHomePage() {
      click(By.linkText("strona główna"));
  }

  public void submitForm() {
      click(By.name("submit"));
  }

  public void fillContactFrom() {
      fillForm(new GroupContact("Anna", "Katarzyna", "Kowalska", "akowalska", "Krzemowa 3/2\n32-900 Katowice", "akowalska@gmail.com"));
  }

  public void goToNewContact() {
      click(By.linkText("nowy wpis"));
  }

  public void selectContact() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));
    }
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

  public void refillContactFrom() {
    fillForm(new GroupContact("Zenon", "Miłosz", "Kowalski", "zkowalski", "Krzemowa 5/2\n32-900 Katowice", "zkowalsk@gmail.com"));
  }

  public void submitModificationForm() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }
}
