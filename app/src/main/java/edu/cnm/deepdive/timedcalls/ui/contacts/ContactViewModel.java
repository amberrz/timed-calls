package edu.cnm.deepdive.timedcalls.ui.contacts;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;
import edu.cnm.deepdive.timedcalls.service.ContactRepository;
import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    private final MutableLiveData<List<Contact>> contacts;
    private final ContactRepository contactRepository;


    public ContactViewModel(@NonNull Application application) {
        super(application);
        contactRepository = new ContactRepository(application);
        contacts = new MutableLiveData<>();
        loadContacts();
    }

    public LiveData<List<Contact>> getContacts() {
        return contacts;
    }

    private void loadContacts() {
        contactRepository.getContacts()
            .subscribe(
                (contacts) -> this.contacts.postValue(contacts)
            );
    }
}