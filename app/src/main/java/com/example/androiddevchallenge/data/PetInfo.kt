package com.example.androiddevchallenge.data

data class PetInfo(
    val id: Long,
    val name: String,
    val age: String,
    val breed: String,
    val gender: String,
    val hostName: String,
    /**
     * 描述
     */
    val desc: String = "",
    /**
     * 星座
     */
    val sign: String,
    val headerUri: Int = 0,
    val imageUrls: List<String> = emptyList()
)