package com.example.gitagyan.database.domain.use_case

import com.example.gitagyan.database.domain.model.Verse
import com.example.gitagyan.database.domain.repository.VerseRepository
import com.example.gitagyan.database.domain.util.OrderType
import com.example.gitagyan.database.domain.util.VerseOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetVerses (
    private val repository : VerseRepository
){
    operator fun invoke(
        verseOrder: VerseOrder = VerseOrder.Date(OrderType.Descending)
    ) : Flow<List<Verse>> {
        return repository.getVerses().map { verses ->
            when(verseOrder.orderType){
                is OrderType.Ascending -> {
                    when(verseOrder){
                        is VerseOrder.ChapterId -> verses.sortedBy { it.chapterId }
                        is VerseOrder.VerseId -> verses.sortedBy { it.verseId }
                        is VerseOrder.Date -> verses.sortedBy { it.timestamp }
                    }
                }
                is OrderType.Descending -> {
                    when(verseOrder){
                        is VerseOrder.ChapterId -> verses.sortedByDescending { it.chapterId }
                        is VerseOrder.VerseId -> verses.sortedByDescending { it.verseId }
                        is VerseOrder.Date -> verses.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}