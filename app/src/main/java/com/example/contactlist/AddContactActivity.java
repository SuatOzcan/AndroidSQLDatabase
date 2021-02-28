package com.example.contactlist;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    EditText firstNameEditText, lastNameEditText, numberEditText;

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

        populateFieldsFromIntent();
    }

    private void populateFieldsFromIntent(){
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String phoneNumber = getIntent().getStringExtra("phoneNumber");
        if (firstName == null) {return;}
        
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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void DeleteContact(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}