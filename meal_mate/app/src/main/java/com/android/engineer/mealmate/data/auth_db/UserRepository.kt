package com.android.engineer.mealmate.data.auth_db

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User): Long {
        return userDao.insertUser(user)
    }
    suspend fun getUser(username: String, password: String): User? {
        return userDao.getUser(username, password)
    }
}
