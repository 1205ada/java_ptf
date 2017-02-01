package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;;
  private String firstname;
  private String lastname;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;
  private String allMails;
  private String email1;
  private String email2;
  private String email3;
  private String address;
  private String details;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllMails() { return  allMails;}

  public ContactData withAllMails(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public String getEmail1() { return  email1;}

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public String getEmail2() { return  email2;}

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() { return  email3;}

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getAddress() { return  address;}

  public ContactData withAddress (String address) {
    this.address = address;
    return this;
  }

  public String getDetails() { return  details;}

  public ContactData withDetails (String details) {
    this.details = details;
    return this;
  }


  //private final String middlename;
  //private final String nickname;
  //private final String address;
  //private final String email;
  //private String group;

 // public ContactData(int id, String firstname, String lastname/*, String middlename, String nickname, String address, String email, String group*/) {
 /*   this.firstname = firstname;
    //this.middlename = middlename;
    this.lastname = lastname;
    this.id = id;
    //this.nickname = nickname;
    //this.address = address;
       //this.email = email;
    //this.group = group;
  }

  public ContactData(String firstname, String lastname) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
  }*/

 public String getWorkPhone() {return workPhone;}

 public ContactData withWorkPhone (String workPhone) {
   this.workPhone = workPhone;
   return this;
 }

 public String getMobilePhone() {return mobilePhone; }

 public ContactData withMobilePhone (String mobilePhone) {
   this.mobilePhone = mobilePhone;
   return this;
 }

 public String getHomePhone() {return homePhone; }

 public ContactData withHomePhone(String homePhone) {
   this.homePhone = homePhone;
   return this;
 }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }
  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public int getId() {return id; }
  public String getFirstname() {
    return firstname;
  }
  public String getLastname() {
    return lastname;
  }


  /*public String getMiddlename() { return middlename; }
  public String getNickname() {
    return nickname;
  }
  public String getAddress() {
    return address;
  }
  public String getEmail() {
    return email;
  }
  public String getGroup() { return group; }*/


  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (group != null ? !group.equals(that.group) : that.group != null) return false;
    if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
    if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
    if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
    if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
    if (allMails != null ? !allMails.equals(that.allMails) : that.allMails != null) return false;
    if (email1 != null ? !email1.equals(that.email1) : that.email1 != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    return address != null ? address.equals(that.address) : that.address == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
    result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
    result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    result = 31 * result + (allMails != null ? allMails.hashCode() : 0);
    result = 31 * result + (email1 != null ? email1.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    return result;
  }
}
