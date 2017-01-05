package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactDeletionTests extends TestBase {
  @Test
  public void ContactDeletionTests() {
    app.getContactHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Aneta", "Katarzyna", "Kowalska", "akowalska", "Krzemowa 3/2\n32-900 Katowice", "akowalska@gmail.com", "test1"), true);
    }
    //app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().secondSubmit();
    app.getContactHelper().goToHomePage();
  }
}
