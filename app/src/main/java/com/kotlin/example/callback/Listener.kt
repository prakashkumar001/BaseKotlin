package com.kotlin.example.callback

interface Listener {
     fun onSucess(code: Int, response: String)
     fun onFailure(code: Int, error: String)
}