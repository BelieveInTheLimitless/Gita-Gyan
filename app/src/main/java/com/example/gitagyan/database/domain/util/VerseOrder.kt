package com.example.gitagyan.database.domain.util

sealed class VerseOrder(val orderType: OrderType){
    class Chapter(orderType: OrderType): VerseOrder(orderType)

    class Verse(orderType: OrderType): VerseOrder(orderType)

    class Date(orderType: OrderType) : VerseOrder(orderType)

    fun copy(orderType: OrderType): VerseOrder{
        return when(this){
            is Chapter -> Chapter(orderType)
            is Verse -> Verse(orderType)
            is Date -> Date(orderType)
        }
    }
}

