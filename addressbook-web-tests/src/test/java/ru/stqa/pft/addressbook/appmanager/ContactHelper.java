package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupContact;

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
}
