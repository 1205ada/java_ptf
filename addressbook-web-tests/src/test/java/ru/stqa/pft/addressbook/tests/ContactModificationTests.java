package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().goToHomePage();
    if (app.contact().list().size() == 0) {
      //app.contact().create(new ContactData("Agnieszka", "Kowalska"/*, "Katarzyna",  "akowalska", "Krzemowa 3/2\n32-900 Katowice", "akowalska@gmail.com", "test1"*/));
      app.contact().create(new ContactData().withFirstname("Agnieszka").withLastname("Kowalska"));
    }
  }

  @Test
  public void ContactModificationTests() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    //ContactData contact = new ContactData(before.get(index).getId(), "Zenon", "Kowalski");
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Zenon").withLastname("Kowalski");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}




