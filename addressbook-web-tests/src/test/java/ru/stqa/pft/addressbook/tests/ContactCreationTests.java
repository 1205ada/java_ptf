package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactCreationTests extends TestBase {
  int id;

 @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType()); //List<GContactData>.class
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromXml")
  public void ContactCreationTests() {
    if (app.db().groups().size() == 0) {
      GroupData group = new GroupData().withName("test 1").withHeader("header 1").withFooter("footer 1");
      app.group().create(group);
    }
    Groups groups = app.db().groups();
    GroupData group = groups.iterator().next();
    String nameGroup = group.getName();
    Contacts contacts = app.db().contacts();
    ContactData newContact = new ContactData().withFirstname("Anna").withLastname("Kowalska").inGroup(groups.iterator().next());
    //File photo = new File("src/test/resources/stru.jpg");

    Contacts before = app.contact().all();
    //ContactData contact = new ContactData("Anna", "Kowalska"/*, "Katarzyna", "akowalska", "Krzemowa 3/2\n32-900 Katowice", "akowalska@gmail.com", "test1"*/);

    for (ContactData contact : contacts) {
      id = contact.getId();
    }
    System.out.println("ID = " + id);
    app.contact().create(newContact);
    app.contact().selectContactById(id);
    app.contact().selectGroup(nameGroup);
    app.contact().addToGroup();
    //assertThat(app.contact().count(), equalTo(before.size() + 1));
    //Contacts after = app.contact().all();
    //assertEquals(after.size(), before.size() +1);
    //assertThat(after, equalTo(
    // before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    verifyContactListInUI();
  }
}
