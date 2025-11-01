package com.example.recyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ContactDetailActivity extends AppCompatActivity {

    private ImageView imageAvatar_2217;
    private ImageView btnBack_2217;
    private TextView textName_2217, textPhoneNumber_2217, textLastCallDate_2217;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        // Initialize views
        imageAvatar_2217 = findViewById(R.id.detail_image_avatar);
        btnBack_2217 = findViewById(R.id.btn_back);
        textName_2217 = findViewById(R.id.detail_text_name);
        textPhoneNumber_2217 = findViewById(R.id.detail_text_phone_number);
        textLastCallDate_2217 = findViewById(R.id.detail_text_last_call_date);

        // Back button click listener
        btnBack_2217.setOnClickListener(v -> finish());

        // Get contact data from intent
        Contact contact = (Contact) getIntent().getSerializableExtra("contact");

        if (contact != null) {
            displayContactInfo(contact);
        }
    }

    private void displayContactInfo(Contact contact) {
        textName_2217.setText(contact.getName());
        textPhoneNumber_2217.setText(contact.getPhoneNumber());
        textLastCallDate_2217.setText("Cuộc gọi gần nhất: " + contact.getLastCallDate());

        Glide.with(this)
                .load(contact.getAvatarResId())
                .circleCrop()
                .placeholder(R.drawable.logokhoa)
                .into(imageAvatar_2217);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
