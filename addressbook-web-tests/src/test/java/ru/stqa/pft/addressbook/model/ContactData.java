package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;;
  private String firstname;
  private String lastname;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
