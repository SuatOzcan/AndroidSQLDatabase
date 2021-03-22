package com.example.contactlist;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface ContactDAO {
    @Insert
    void insert(Contact... contact);
}
