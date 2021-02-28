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
    private OnItemSelectedListener onItemSelectedListener;

    public ContactsAdapter(ArrayList<Contact> contactsList, OnItemSelectedListener onItemSelectedListener) {
        this.contactsList = contactsList;
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView nameTextView , numberTextView;
        OnItemSelectedListener onItemSelectedListener;

        public ContactsViewHolder(LinearLayout layout, OnItemSelectedListener onItemSelectedListener) {
            super(layout);

            this.nameTextView = layout.findViewById(R.id.full_name_text_view);
            this.numberTextView = layout.findViewById((R.id.phone_number_text_view));
            this.onItemSelectedListener = onItemSelectedListener;
            layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                onItemSelectedListener.onItemSelected(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_item_view,
                                                                                  viewGroup, false);
        return new ContactsViewHolder(layout, onItemSelectedListener);
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

    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

}
