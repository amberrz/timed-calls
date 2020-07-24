package edu.cnm.deepdive.timedcalls.ui.contacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.timedcalls.R;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;
import java.lang.reflect.Array;


public class ContactFragment extends Fragment {

    private ContactViewModel contactViewModel;
    private ListView contacts;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        contacts = root.findViewById(R.id.contacts);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contactViewModel = new ViewModelProvider(getActivity()).get(ContactViewModel.class);
        contactViewModel.getContacts().observe(getViewLifecycleOwner(), (contacts) -> {
            ArrayAdapter<Contact> adapter
                = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, contacts);
            this.contacts.setAdapter(adapter);
        });


    }
}
