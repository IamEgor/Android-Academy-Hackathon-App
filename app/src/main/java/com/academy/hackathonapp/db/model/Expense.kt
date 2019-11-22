package com.academy.hackathonapp.db.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.data.Category
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Entity
@Parcelize
class Expense(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @Embedded(prefix = "category_")
    var category: Category? = null,
    var description: String = "",
    var expenseSum: BigDecimal = BigDecimal.ZERO,
    @Embedded(prefix = "currency_")
    var currency: Currency? = null,
    var date: Long? = -1
) : Parcelable

