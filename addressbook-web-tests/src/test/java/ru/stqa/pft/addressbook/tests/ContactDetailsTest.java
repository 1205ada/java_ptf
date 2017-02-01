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
public class ContactDetailsTest extends TestBase {

  @Test
  public void testContactDetails() {
    app.contact().goToHomePage();
    ContactData contact = app.contact().all2().iterator().next();
    ContactData contactInfoFromDetailsForm;
    contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);


    assertThat(cleaned(contact.getDetails()), equalTo(mergeDetails(contactInfoFromDetailsForm)));
  }

  private String mergeDetails(ContactData contact) {
    return Arrays.asList(contact.getDetails())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactDetailsTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String details) {
    return details.replaceAll("\\s", "").replaceAll("[-()]", "").replace("H:", "").replace("W:", "").replace("M:", "");
  }
}
