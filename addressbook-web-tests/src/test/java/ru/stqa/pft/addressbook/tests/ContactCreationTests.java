package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase
{
    @Test
    public void ContactCreationTests() {
        Contacts before = app.contact().all();
        //ContactData contact = new ContactData("Anna", "Kowalska"/*, "Katarzyna", "akowalska", "Krzemowa 3/2\n32-900 Katowice", "akowalska@gmail.com", "test1"*/);
        ContactData contact = new ContactData().withFirstname("Anna").withLastname("Kowalska");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() +1);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
