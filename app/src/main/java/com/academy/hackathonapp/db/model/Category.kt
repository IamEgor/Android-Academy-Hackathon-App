package com.academy.hackathonapp.db.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.academy.hackathonapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var categoryName: String = "",
    @DrawableRes var img: Int = R.drawable.pacman
) : Parcelable
