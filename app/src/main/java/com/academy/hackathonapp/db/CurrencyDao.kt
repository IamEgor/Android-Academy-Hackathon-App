package com.academy.hackathonapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.academy.hackathonapp.db.model.Currency

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM Currency ORDER BY name DESC")
    fun getAll(): List<Currency>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(currencyList: List<Currency>)

}
