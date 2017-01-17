package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().goToHomePage();
    if (app.contact().list().size() == 0) {
      //app.contact().create(new ContactData("Agnieszka", "Kowalska"/*, "Katarzyna",  "akowalska", "Krzemowa 3/2\n32-900 Katowice", "akowalska@gmail.com", "test1"*/));
      app.contact().create(new ContactData().withFirstname("Agnieszka").withLastname("Kowalska"));
    }
  }


  @Test
  public void ContactDeletionTests() {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}





