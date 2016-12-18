package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase
{
    @Test
    public void ContactCreationTests() {
        app.getContactHelper().goToNewContact();
        app.getContactHelper().fillContactFrom();
        app.getContactHelper().submitForm();
        app.getContactHelper().goToHomePage();
    }
}
