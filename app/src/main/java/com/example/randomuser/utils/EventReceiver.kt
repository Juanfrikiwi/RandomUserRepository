package com.example.randomuser.utils

@Suppress("unused")
inline fun <reified T, reified R> T.receive(callback: (R) -> Unit) {
    if (this is R) callback(this)
}