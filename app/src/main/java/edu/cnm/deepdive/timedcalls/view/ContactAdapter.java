package edu.cnm.deepdive.timedcalls.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.timedcalls.R;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

  public ContactAdapter(@NonNull Context context, @NonNull List<Contact> objects) {
    super(context, R.layout.item_contact, objects);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view = (convertView != null) ? convertView
        : LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
    Contact contact = getItem(position);
    TextView displayName = view.findViewById(R.id.display_name);
    TextView phoneNumber = view.findViewById(R.id.phone_number);
    displayName.setText(contact.getDisplayName());
    phoneNumber.setText(contact.getPhoneNumber());
    return view;
  }
}
