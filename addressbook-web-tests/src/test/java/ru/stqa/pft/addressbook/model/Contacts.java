package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ada on 2017-01-22.
 */
public class Contacts extends ForwardingSet<ContactData> {

  public Set<ContactData> delegate;

  public Contacts(Contacts contacs) {
    this.delegate = new HashSet<ContactData>(contacs.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<ContactData>();
  }

  public Contacts (Collection<ContactData> contacts) {
    this.delegate = new HashSet<ContactData>(contacts);
  }


  @Override
  public Set<ContactData> delegate() {
    return delegate;
  }

  public Contacts withAdded (ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts without (ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}
