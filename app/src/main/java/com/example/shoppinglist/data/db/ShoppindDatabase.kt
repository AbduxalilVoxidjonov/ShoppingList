package com.example.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist.data.db.dao.ShoppingDao
import com.example.shoppinglist.data.db.entity.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppindDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao


    companion object {
        @Volatile
        private var instance: ShoppindDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ShoppindDatabase::class.java,
            "shopping_db.db"
        ).build()
    }
}