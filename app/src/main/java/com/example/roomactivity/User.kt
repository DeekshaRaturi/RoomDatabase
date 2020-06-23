package com.example.roomactivity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User( @PrimaryKey(autoGenerate = true) var uId: Int = 0, @ColumnInfo(name = "Name") var name: String = "",@ColumnInfo(name = "Age") var age: String = "")