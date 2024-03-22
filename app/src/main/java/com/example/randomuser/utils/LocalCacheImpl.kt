package com.example.randomuser.utils

import javax.inject.Inject

class LocalCacheImpl @Inject constructor(private val data: MutableMap<String, Any>) : LocalCache {

    override fun saveString(key: String, value: String) {
        data[key] = value
    }

    override fun getString(key: String): String {
        return (data[key] as? String).orEmpty()
    }

    override fun saveLong(key: String, value: Long) {
        data[key] = value
    }

    override fun getLong(key: String): Long {
        return (data[key] as? Long) ?: 0L
    }

    override fun saveBoolean(key: String, value: Boolean) {
        data[key] = value
    }

    override fun getBoolean(key: String): Boolean {
        return (data[key] as? Boolean) ?: false
    }

    override fun saveInt(key: String, value: Int) {
        data[key] = value
    }

    override fun getInt(key: String): Int {
        return (data[key] as? Int) ?: 0
    }

    override fun <T:Any> saveList(key: String, list: List<T>) {
        data[key] = list
    }

    override fun <T:Any> getList(key: String, c: Class<T>): List<T> {
        return (data[key] as? List<*>)?.filterIsInstance(c) ?: emptyList()
    }

    override fun saveObject(key: String, value: Any) {
        data[key] = value
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getObject(key: String, c: Class<T>): T? {
        return data[key] as? T
    }

    override fun removeKey(key: String) {
        data.remove(key)
    }

    override fun clear() {
        data.clear()
    }
}