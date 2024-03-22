package com.example.randomuser.utils

interface LocalCache {

    fun saveString(key: String, value: String)

    fun getString(key: String): String

    fun saveLong(key: String, value: Long)

    fun getLong(key: String): Long

    fun saveBoolean(key: String, value: Boolean)

    fun getBoolean(key: String): Boolean

    fun saveInt(key: String, value: Int)

    fun getInt(key: String): Int

    fun <T : Any> saveList(key: String, list: List<T>)

    fun <T : Any> getList(key: String, c: Class<T>): List<T>

    fun saveObject(key: String, value: Any)

    fun<T> getObject(key: String, c: Class<T>): T?

    fun removeKey(key: String)

    fun clear()
}