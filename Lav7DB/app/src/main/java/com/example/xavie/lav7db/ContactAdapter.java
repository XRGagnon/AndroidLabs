package com.example.xavie.lav7db;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import Models.Contact;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        // *** Define your textviews here to hold the names and phone number fields.
        TextView firstNameTV;
        TextView lastNameTV;
        //TextView phoneNumberTV;


        public ViewHolder(View itemView) {

            super(itemView);

            // *** itemview holds the view you made in the layout.
            // *** Move the id's from there, to your textviews
            // *** you made above.  Use itemview.findViewbyId here.
            firstNameTV = itemView.findViewById(R.id.textViewFirstName);
            lastNameTV = itemView.findViewById(R.id.textViewLastName);
            //phoneNumberTV = itemView.findViewById(R.id.textViewPhone);

        }
    }

    private List<Contact> mContacts;

    public ContactAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.activity_contact_adapter, parent, false);
        // *** The contact item above is the single line layout you made before.
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ViewHolder viewHolder, int position)
    {
        Contact contact = mContacts.get(position);

        // *** Here set the viewholder objects you made above to the values
        // *** you get in contact 2 lines above.
        TextView first = viewHolder.firstNameTV;
        TextView last = viewHolder.lastNameTV;
        //TextView phone = viewHolder.phoneNumberTV;

        first.setText(contact.getFirstName());
        last.setText(contact.getLastName());
        //phone.setText(contact.getPhoneNums().get(0).getPhoneNum().toString());


    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount()
    {
        return mContacts.size();
    }
}
