package edu.cnm.deepdive.timedcalls.service;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedList;
import java.util.List;

public class ContactRepository {

  private final Context context;

  public ContactRepository(Context context) {
    this.context = context;
  }

  public Single<List<Contact>> getContacts() {

    return Single.fromCallable(() -> {
      List<Contact> contacts = new LinkedList<>();
      ContentResolver resolver = context.getContentResolver();
      Cursor cursor = resolver.query(Contacts.CONTENT_URI,
          new String[]{Contacts._ID, Contacts.DISPLAY_NAME_PRIMARY}, null, null,
          Contacts.DISPLAY_NAME_PRIMARY);
      while (cursor.moveToNext()) {
        String id = cursor.getString(cursor.getColumnIndex(Contacts._ID));
        Contact contact = new Contact();
        contact.setDisplayName(
            cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME_PRIMARY)));
        contact.setUri(Uri.withAppendedPath(Contacts.CONTENT_URI, id));
        //Asume frist phone number is correct
        Cursor phones = resolver.query(Phone.CONTENT_URI, new String[]{Phone.NUMBER},
            Phone.CONTACT_ID + "=" + id, null, null);
        if (phones.moveToFirst()) {
          contact.setPhoneNumber(phones.getString(phones.getColumnIndex(Phone.NUMBER)));
        }
        contacts.add(contact);
      }
      return contacts;
    })
        .subscribeOn(Schedulers.io());
  }

  // TODO investagate rather we need a single contact.
}
