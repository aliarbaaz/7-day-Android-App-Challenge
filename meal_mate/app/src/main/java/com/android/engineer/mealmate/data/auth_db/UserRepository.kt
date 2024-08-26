package com.android.engineer.mealmate.data.auth_db

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: UserTable): Long {
        return userDao.insertUser(user)
    }
    suspend fun getUser(username: String, password: String): UserTable? {
        return userDao.getUser(username, password)
    }
}
