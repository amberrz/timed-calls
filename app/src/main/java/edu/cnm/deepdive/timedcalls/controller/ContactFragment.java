package edu.cnm.deepdive.timedcalls.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.timedcalls.R;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;
import edu.cnm.deepdive.timedcalls.view.ContactAdapter;
import edu.cnm.deepdive.timedcalls.viewmodel.ContactViewModel;


/**
 * The Contact fragment inflate with on click listener button to popup .
 */
public class ContactFragment extends Fragment implements OnItemClickListener {

  private ContactViewModel contactViewModel;
  private ListView contacts;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_contact, container, false);
    contacts = root.findViewById(R.id.contacts);
    contacts.setOnItemClickListener(this);
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
    getLifecycle().addObserver(contactViewModel);
    contactViewModel.getContacts().observe(getViewLifecycleOwner(), (contacts) -> {
      ContactAdapter adapter = new ContactAdapter(getContext(), contacts);
      this.contacts.setAdapter(adapter);
    });


  }



  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Contact contact = (Contact) parent.getItemAtPosition(position);
    CallStartFragment fragment = CallStartFragment.newInstance(contact.getUri());
    fragment.show(getChildFragmentManager(), fragment.getClass().getName());

  }
}
