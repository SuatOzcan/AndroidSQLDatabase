package com.example.contactlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private ArrayList<Contact> contactsList;

    public ContactsAdapter(ArrayList<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView , numberTextView;

        public ContactsViewHolder(LinearLayout layout) {
            super(layout);

            this.nameTextView = layout.findViewById(R.id.full_name_text_view);
            this.numberTextView = layout.findViewById((R.id.phone_number_text_view));
        }
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_item_view,
                                                                                  viewGroup, false);
        return new ContactsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder contactsViewHolder, int i) {
               final Contact contact = contactsList.get(i);
               contactsViewHolder.nameTextView.setText(contact.GetFullName());
               contactsViewHolder.numberTextView.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

}
