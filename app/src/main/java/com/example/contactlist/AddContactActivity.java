package com.example.contactlist;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    EditText firstNameEditText, lastNameEditText, numberEditText;

    String originalFirstName, originalLastName, originalPhoneNumber;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("New Contact");

        firstNameEditText = findViewById(R.id.first_name_edit_text);
        lastNameEditText = findViewById(R.id.last_name_edit_text);
        numberEditText = findViewById(R.id.phone_number_edit_text);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").allowMainThreadQueries().build();

        populateFieldsFromIntent();
    }

    private void populateFieldsFromIntent(){
        originalFirstName = getIntent().getStringExtra("firstName");
        originalLastName = getIntent().getStringExtra("lastName");
        originalPhoneNumber = getIntent().getStringExtra("phoneNumber");
        if (originalFirstName == null) {return;}
        firstNameEditText.setText(originalFirstName);
        lastNameEditText.setText(originalLastName);
        numberEditText.setText(originalPhoneNumber);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id==R.id.action_delete_contact){
            DeleteContact();
            return true;
        }else if (id==R.id.action_save_contact){
            SaveContact();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
    public void SaveContact(){
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String phoneNumber = numberEditText.getText().toString();

        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()){
            return;
        }

        if (originalFirstName == null){
            Contact newContact = new Contact(firstName, lastName, phoneNumber);
            db.contactDAO().insert(newContact);
        }else   {

        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void DeleteContact(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}