package edu.cnm.deepdive.timedcalls.controller;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.timedcalls.R;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;


public class CallTimerFragment extends DialogFragment {

  private static final String URI_KEY = "uri";

  public static CallTimerFragment createInstance(Contact contact) {
    CallTimerFragment fragment = new CallTimerFragment();
    Bundle args = new Bundle();
    args.putParcelable(URI_KEY, contact.getUri());
    // TODO Store additional info of contacts
    fragment.setArguments(args);
    return fragment;
  }
  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // TODO Get the nesary info to place the call is phone number contact info
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    super.onCreateDialog(savedInstanceState);
    // TODO Inflate view resorce and use dialog builder to create and return alart dialog
    return null; // FIXME
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // TODO Return layout inflated in oncreat dialog
    return null; //FIXME
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // TODO establish Connect to view model
  }
}
