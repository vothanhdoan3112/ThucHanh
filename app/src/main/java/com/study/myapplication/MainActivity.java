package com.study.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyContactRecyclerViewAdapter ContactAdapter;
    private ArrayList<Contacts> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactFragment contactFragment = new ContactFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,contactFragment).commit();


        contacts = null;
        String[] pj = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
        };
        Cursor cursor;
        ContentResolver contentResolver = getContentResolver();
        cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,pj,null,null,null);
        int nameIndex = cursor.getColumnIndex(pj[0]);
        int numberIndex = cursor.getColumnIndex(pj[1]);

        cursor.moveToFirst();
        while (cursor.moveToNext()){
            Contacts ct = new Contacts(cursor.getString(nameIndex),
                    cursor.getString(numberIndex));
            contacts.add(ct);
        }

        for (Contacts contact : contacts) {
            System.out.println(contact.toString());
        }

    }
}