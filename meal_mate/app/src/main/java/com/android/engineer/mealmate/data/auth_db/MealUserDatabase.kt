package com.android.engineer.mealmate.data.auth_db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [User::class], version = 1)
abstract class MealUserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: MealUserDatabase? = null
        fun getAppDatabase(context: Context): MealUserDatabase {
            if(INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MealUserDatabase::class.java,
                        "authenticationDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}
