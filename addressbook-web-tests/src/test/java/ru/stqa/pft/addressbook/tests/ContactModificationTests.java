package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void ContactModificationTests() {
      app.getContactHelper().goToHomePage();
      app.getContactHelper().selectContact();
      app.getContactHelper().initContactModification();
      app.getContactHelper().refillContactFrom();
      app.getContactHelper().submitModificationForm();
      app.getContactHelper().goToHomePage();
  }
}
