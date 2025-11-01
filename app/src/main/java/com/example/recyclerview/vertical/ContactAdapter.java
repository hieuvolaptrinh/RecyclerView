package com.example.recyclerview.vertical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.Contact;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private Context context;
    private ArrayList<Contact> contactList;
    private OnContactClickListener listener;

    public ContactAdapter(Context context, ArrayList<Contact> contactList, OnContactClickListener listener) {
        this.context = context;
        this.contactList = contactList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.textName_2217.setText(contact.getName());
        holder.textPhoneNumber_2217.setText(contact.getPhoneNumber());
        holder.textLastCallDate_2217.setText("Gọi gần nhất: " + contact.getLastCallDate());

        Glide.with(context)
                .load(contact.getAvatarResId())
                .circleCrop()
                .placeholder(R.drawable.logokhoa)
                .into(holder.imageAvatar_2217);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onContactClick(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

}
