package com.caballero.leo.mathplay.data.database

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesRepository(context: Context) {

    companion object {
        private const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
        private const val USER_EMAIL_KEY = "USER_EMAIL_KEY"
        private const val USER_PASSWORD_KEY = "USER_PASSWORD_KEY"
        private const val USER_FULL_NAME_KEY = "USER_FULL_NAME_KEY"
        private const val USER_BIRTH_DATE_KEY = "USER_BIRTH_DATE_KEY"
        private const val USER_AUTHENTICATED_KEY = "USER_AUTHENTICATED_KEY"
        private const val DEFAULT_VALUE_FOR_EMPTY = ""
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
    }

    fun getUserEmail(): String {
        return sharedPreferences.getString(USER_EMAIL_KEY, DEFAULT_VALUE_FOR_EMPTY) ?: DEFAULT_VALUE_FOR_EMPTY
    }

    fun getUserPassword(): String {
        return sharedPreferences.getString(USER_PASSWORD_KEY, DEFAULT_VALUE_FOR_EMPTY) ?: DEFAULT_VALUE_FOR_EMPTY
    }

    fun saveUserEmail(email: String) {
        sharedPreferences.edit().putString(USER_EMAIL_KEY, email).apply()
    }

    fun saveUserPassword(password: String) {
        sharedPreferences.edit().putString(USER_PASSWORD_KEY, password).apply()
    }

    fun saveUserFullName(fullName: String) {
        sharedPreferences.edit().putString(USER_FULL_NAME_KEY, fullName).apply()
    }

    fun getUserFullName(): String {
        return sharedPreferences.getString(USER_FULL_NAME_KEY, DEFAULT_VALUE_FOR_EMPTY) ?: DEFAULT_VALUE_FOR_EMPTY
    }

    fun saveUserBirthDate(birthDate: String) {
        sharedPreferences.edit().putString(USER_BIRTH_DATE_KEY, birthDate).apply()
    }

    fun getUserBirthDate(): String {
        return sharedPreferences.getString(USER_BIRTH_DATE_KEY, DEFAULT_VALUE_FOR_EMPTY) ?: DEFAULT_VALUE_FOR_EMPTY
    }

    fun setUserAuthenticated(isAuthenticated: Boolean) {
        sharedPreferences.edit().putBoolean(USER_AUTHENTICATED_KEY, isAuthenticated).apply()
    }

    fun isUserAuthenticated(): Boolean {
        return sharedPreferences.getBoolean(USER_AUTHENTICATED_KEY, false)
    }
}