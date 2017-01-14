package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Ada on 2016-12-18.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void ContactModificationTests() {
      app.getContactHelper().goToHomePage();
      if (!app.getContactHelper().isThereAContact()) {
        app.getContactHelper().createContact(new ContactData("Agnieszka", "Kowalska"/*, "Katarzyna",  "akowalska", "Krzemowa 3/2\n32-900 Katowice", "akowalska@gmail.com", "test1"*/));
      }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size() - 1);
      app.getContactHelper().initContactModification();
      ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Zenon", "Kowalski");
      app.getContactHelper().fillContactForm(new ContactData("Zenon", "Kowalski"/*,"Miłosz", "zkowalski", "Krzemowa 5/2\n32-900 Katowice", "zkowalsk@gmail.com", null), false*/));
      app.getContactHelper().submitModificationForm();
      app.getContactHelper().goToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(before.size() - 1);
      before.add(contact);
      Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }
  }




