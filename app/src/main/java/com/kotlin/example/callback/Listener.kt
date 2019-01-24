package com.kotlin.example.callback

interface Listener {
    abstract fun onSucess(code: Int, response: String)
    abstract fun onFailure(code: Int, error: String)
}