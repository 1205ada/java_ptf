package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactDeletionTests extends TestBase {
  @Test
  public void ContactDeletionTests() {
    app.getContactHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().secondSubmit();
    app.getContactHelper().goToHomePage();
  }
}
