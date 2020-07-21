package edu.cnm.deepdive.timedcalls.service;

import android.content.Context;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;
import java.util.List;

public class ContactRepository {

  private final Context context;

  public ContactRepository(Context context) {
    this.context = context;
  }

  public List<Contact> getContacts() {
    //TODO Quire the android contact data base and populate the list.
    return null;
  }

  // TODO investagate rather we need a single contact.
}
