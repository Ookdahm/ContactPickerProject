package com.paad.contactpicker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ContactPicker extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Cursor c = getContentResolver().query(
                Contacts.CONTENT_URI, null, null, null, null);

        String[] from = new String[] {Contacts.DISPLAY_NAME_PRIMARY};
        int [] to = new int[] {R.id.itemTextView};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.listitemlayout, c, from, to);

        ListView lv = (ListView)findViewById(R.id.contactListView);
        lv.setAdapter(adapter);
    }


    
}
