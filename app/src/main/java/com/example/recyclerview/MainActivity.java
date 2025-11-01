package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.horizontal.FavoriteContactAdapter;
import com.example.recyclerview.horizontal.OnFavoriteContactClickListener;
import com.example.recyclerview.vertical.ContactAdapter;
import com.example.recyclerview.vertical.OnContactClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnContactClickListener, OnFavoriteContactClickListener {
    private ArrayList<Contact> contactList;
    private ArrayList<Contact> favoriteContactList;
    private RecyclerView recyclerViewContacts;
    private RecyclerView recyclerViewFavorites;
    private ContactAdapter contactAdapter;
    private FavoriteContactAdapter favoriteContactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ẩn ActionBar để có giao diện đẹp hơn
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Initialize RecyclerViews
        recyclerViewContacts = findViewById(R.id.recyclerContacts);
        recyclerViewFavorites = findViewById(R.id.recyclerFavorites);

        contactList = new ArrayList<>();
        favoriteContactList = new ArrayList<>();

        createContactList();

        // Setup Vertical RecyclerView for All Contacts
        contactAdapter = new ContactAdapter(this, contactList, this);
        recyclerViewContacts.setAdapter(contactAdapter);
        recyclerViewContacts.setLayoutManager(new LinearLayoutManager(this));

        // Setup Horizontal RecyclerView for Favorite Contacts
        favoriteContactAdapter = new FavoriteContactAdapter(this, favoriteContactList, this);
        recyclerViewFavorites.setAdapter(favoriteContactAdapter);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);
        recyclerViewFavorites.setLayoutManager(horizontalLayoutManager);
    }

    private void createContactList() {
        // Thêm contacts với một số contacts yêu thích
        contactList.add(new Contact("Võ Nguyễn Đại Hiếu", "0123 456 789", "01/11/2025", R.drawable.hieu, true));
        contactList.add(new Contact("Trần Thị B", "0987 654 321", "31/10/2025", R.drawable.logokhoa, true));
        contactList.add(new Contact("Lê Văn C", "0912 345 678", "30/10/2025", R.drawable.logotruong, false));
        contactList.add(new Contact("Phạm Thị D", "0909 876 543", "29/10/2025", R.drawable.flower2, true));
        contactList.add(new Contact("Hoàng Văn E", "0938 123 456", "28/10/2025", R.drawable.flower1, false));
        contactList.add(new Contact("Võ Thị F", "0976 543 210", "27/10/2025", R.drawable.logokhoa, true));
        contactList.add(new Contact("Đặng Văn G", "0945 678 901", "26/10/2025", R.drawable.hieu, false));
        contactList.add(new Contact("Bùi Thị H", "0923 456 789", "25/10/2025", R.drawable.logokhoa, true));
        contactList.add(new Contact("Ngô Văn I", "0934 567 890", "24/10/2025", R.drawable.flower2, false));
        contactList.add(new Contact("Dương Thị K", "0901 234 567", "23/10/2025", R.drawable.flower1, false));

        // Lọc ra danh sách contacts yêu thích
        for (Contact contact : contactList) {
            if (contact.isFavorite()) {
                favoriteContactList.add(contact);
            }
        }
    }

    @Override
    public void onContactClick(Contact contact) {
        Intent intent = new Intent(MainActivity.this, ContactDetailActivity.class);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }

    @Override
    public void onFavoriteContactClick(Contact contact) {
        Intent intent = new Intent(MainActivity.this, ContactDetailActivity.class);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }
}