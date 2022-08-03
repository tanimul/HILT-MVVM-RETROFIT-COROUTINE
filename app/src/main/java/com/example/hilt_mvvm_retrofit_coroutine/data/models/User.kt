package com.example.hilt_mvvm_retrofit_coroutine.data.models

data class DataList(val items: List<User>)
data class User(val name: String, val description: String?, val owner: Owner?)
data class Owner(val avatar_url: String?, val type: String)
