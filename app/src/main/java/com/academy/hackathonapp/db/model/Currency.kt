package com.academy.hackathonapp.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Currency(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var name: String = ""
) : Parcelable