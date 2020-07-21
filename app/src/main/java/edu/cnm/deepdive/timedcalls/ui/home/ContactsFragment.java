package edu.cnm.deepdive.timedcalls.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import edu.cnm.deepdive.timedcalls.R;

public class ContactsFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String myArg = ContactsFragmentArgs.fromBundle(getArguments()).getMyArg();
        TextView textView = view.findViewById(R.id.textview_contacts);
        textView.setText(getString(R.string.hello_home_second, myArg));

        view.findViewById(R.id.button_contact1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ContactsFragment.this)
                        .navigate(R.id.action_homeFragment_to_navigation_contacts);
            }
        });
    }
}
