package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void ContactModificationTests() {
      app.getContactHelper().goToHomePage();
      app.getContactHelper().selectContact();
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(new ContactData("Zenon", "Miłosz", "Kowalski", "zkowalski", "Krzemowa 5/2\n32-900 Katowice", "zkowalsk@gmail.com", null), false);
      app.getContactHelper().submitModificationForm();
      app.getContactHelper().goToHomePage();
  }
}
