package com.example.recyclerview.horizontal;

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

public class FavoriteContactAdapter extends RecyclerView.Adapter<FavoriteContactViewHolder> {

    private Context context;
    private ArrayList<Contact> favoriteContactList;
    private OnFavoriteContactClickListener listener;

    public FavoriteContactAdapter(Context context, ArrayList<Contact> favoriteContactList,
            OnFavoriteContactClickListener listener) {
        this.context = context;
        this.favoriteContactList = favoriteContactList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FavoriteContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorite_contact, parent, false);
        return new FavoriteContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteContactViewHolder holder, int position) {
        Contact contact = favoriteContactList.get(position);

        holder.textFavoriteName_2217.setText(contact.getName());

        Glide.with(context)
                .load(contact.getAvatarResId())
                .circleCrop()
                .placeholder(R.drawable.logokhoa)
                .into(holder.imageFavoriteAvatar_2217);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onFavoriteContactClick(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteContactList.size();
    }
}
