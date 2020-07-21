package edu.cnm.deepdive.timedcalls.ui.contacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.timedcalls.R;


public class ContactFragment extends Fragment {

    private ContactViewModel contactViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        contactViewModel =
                ViewModelProviders.of(this).get(ContactViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        final TextView textView = root.findViewById(R.id.textview_contacts);
        contactViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//       // view.findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                HomeFragmentDirections.ActionHomeFragmentToNavigationContacts action =
//                        HomeFragmentDirections.actionHomeFragmentToNavigationContacts
//                                ("From HomeFragment");
//                NavHostFragment.findNavController(HomeFragment.this)
//                        .navigate(action);
//            }
//        });
    }
}
