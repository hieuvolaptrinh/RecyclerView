package com.example.recyclerview.horizontal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

public class FavoriteContactViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageFavoriteAvatar_2217;
    public TextView textFavoriteName_2217;

    public FavoriteContactViewHolder(@NonNull View itemView) {
        super(itemView);
        imageFavoriteAvatar_2217 = itemView.findViewById(R.id.image_favorite_avatar);
        textFavoriteName_2217 = itemView.findViewById(R.id.text_favorite_name);
    }
}
