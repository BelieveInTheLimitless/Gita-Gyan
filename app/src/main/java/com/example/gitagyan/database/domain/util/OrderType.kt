package com.example.gitagyan.database.domain.util

sealed class OrderType{
    object Ascending : OrderType()
    object Descending : OrderType()
}
