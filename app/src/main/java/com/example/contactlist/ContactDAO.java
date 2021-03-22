package com.example.contactlist;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDAO {

    @Query("SELECT * FROM contact")
    List<Contact> getAllContacts();

    @Query("SELECT * FROM contact WHERE first_name LIKE :first AND last_name LIKE :last AND phone_number LIKE :phoneNumber LIMIT 1")
    Contact findAContact(String first, String last, String phoneNumber);

    @Insert
    void insert(Contact... contact);
}
