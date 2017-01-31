package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Ada on 2017-01-31.
 */
public class ContactMailTest extends TestBase {

  @Test
  public void testContactMail() {
    app.contact().goToHomePage();
    ContactData contact = app.contact().all2().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllMails(), equalTo(mergeMails(contactInfoFromEditForm)));
  }
  private String mergeMails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactMailTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String mail) {
    return mail.replaceAll("\\n", "").replaceAll("[-()]", "");
  }
}
