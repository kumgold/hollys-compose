package com.test_application.hollyscompose.data

data class Coupon(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val name: String,
    val startDate: String,
    val expiredDate: String,
    val store: String,
    val isExpired: Boolean
)