package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase
{
    @Test
    public void ContactCreationTests() {
        app.getContactHelper().createContact(new ContactData("Anna", "Katarzyna", "Kowalska", "akowalska", "Krzemowa 3/2\n32-900 Katowice", "akowalska@gmail.com", "test1"));
    }
}
