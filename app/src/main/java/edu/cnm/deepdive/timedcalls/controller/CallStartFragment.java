package edu.cnm.deepdive.timedcalls.controller;


import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.timedcalls.R;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;
import edu.cnm.deepdive.timedcalls.viewmodel.ContactViewModel;
import java.net.URI;


/**
 * The Call start fragment class extends with the dialog fragment.
 */
public class CallStartFragment extends DialogFragment {

  private static final String URI_KEY = "uri";
  private String uri;
  private Contact contact;
  private View root;
  private AlertDialog dialog;
  private EditText callLength;
  private Spinner phoneNumbers;
  private ContactViewModel viewModel;
  private TextView displayName;

  /**
   * New instance call start fragment get the uri key and returns a fragment.
   *
   * @param
   * @return the fragment which is call start.
   */
  public static CallStartFragment newInstance(Uri uri) {
    CallStartFragment fragment = new CallStartFragment();
    Bundle args = new Bundle();
    args.putString(URI_KEY, uri.toString());
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    uri = getArguments().getString(URI_KEY);
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    super.onCreateDialog(savedInstanceState);
    root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_call_start, null, false);
    displayName = root.findViewById(R.id.display_name);
    callLength = root.findViewById(R.id.call_time);
    phoneNumbers = root.findViewById(R.id.phone_numbers);
    dialog = new AlertDialog.Builder(getContext())
        .setIcon(android.R.drawable.ic_menu_call)
        .setTitle("Place Time Call")
        .setView(root)
        .setPositiveButton(android.R.string.ok, (dlg, wh) -> {
          // TODO Place call
        })
        .setNegativeButton(android.R.string.cancel, (dlg, wh) -> {
        })
        .create();
    return dialog;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getParentFragment()).get(ContactViewModel.class);
    viewModel.getContact().observe(getViewLifecycleOwner(), (contact) -> {
      this.contact = contact;
      displayName.setText(contact.getDisplayName());
      ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
          android.R.layout.simple_spinner_item, contact.getPhoneNumbers());
      phoneNumbers.setAdapter(adapter);
    });

    viewModel.setContactUri(uri);
  }

}
