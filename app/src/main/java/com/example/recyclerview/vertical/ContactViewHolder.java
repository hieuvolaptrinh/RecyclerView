package com.example.recyclerview.vertical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    ImageView imageAvatar_2217;
    TextView textName_2217;
    TextView textPhoneNumber_2217;
    TextView textLastCallDate_2217;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        imageAvatar_2217 = itemView.findViewById(R.id.image_avatar);
        textName_2217 = itemView.findViewById(R.id.text_name);
        textPhoneNumber_2217 = itemView.findViewById(R.id.text_phone_number);
        textLastCallDate_2217 = itemView.findViewById(R.id.text_last_call_date);
    }
}