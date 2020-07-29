package edu.cnm.deepdive.timedcalls.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;
import edu.cnm.deepdive.timedcalls.service.ContactRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MutableLiveData<List<Contact>> contacts;
  private final ContactRepository contactRepository;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final Map<String, Contact> contactMap;
  private final MutableLiveData<Contact> contact;

  public ContactViewModel(@NonNull Application application) {
    super(application);
    contactRepository = new ContactRepository(application);
    contacts = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
    contactMap = new HashMap<>();
    contact = new MutableLiveData<>();
    loadContacts();
  }

  public LiveData<List<Contact>> getContacts() {
    return contacts;
  }

  private void loadContacts() {
    pending.add(
        contactRepository.getContacts()
            .map((contacts) -> {
              contactMap.clear();
              contacts.forEach((contact) -> {
                contactMap.put(contact.getUri().toString(), contact);
              });
              return contacts;
            })
            .subscribe(
                (contacts) -> this.contacts.postValue(contacts),
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  public void setContactUri(String uri) {
    contact.setValue(contactMap.get(uri));
  }

  public LiveData<Contact> getContact() {
    return contact;
  }

  @OnLifecycleEvent(Event.ON_STOP)
    private void clearPending() {
      pending.clear();
  }

}