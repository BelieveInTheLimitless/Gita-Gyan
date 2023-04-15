package com.example.gitagyan.database.domain.util

sealed class VerseOrder(val orderType: OrderType){
    class ChapterId(orderType: OrderType): VerseOrder(orderType)

    class VerseId(orderType: OrderType): VerseOrder(orderType)

    class Date(orderType: OrderType) : VerseOrder(orderType)

    fun copy(orderType: OrderType): VerseOrder{
        return when(this){
            is ChapterId -> ChapterId(orderType)
            is VerseId -> VerseId(orderType)
            is Date -> Date(orderType)
        }
    }
}

