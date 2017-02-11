package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().goToHomePage();
    if (app.db().contacts().size() == 0) {
      //app.contact().create(new ContactData("Agnieszka", "Kowalska"/*, "Katarzyna",  "akowalska", "Krzemowa 3/2\n32-900 Katowice", "akowalska@gmail.com", "test1"*/));
      app.contact().create(new ContactData().withFirstname("Agnieszka").withLastname("Kowalska"));
    }
  }

  @Test
  public void ContactModificationTests() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    //ContactData contact = new ContactData(before.get(index).getId(), "Zenon", "Kowalski");
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Zenon").withLastname("Kowalski");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    //assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}




