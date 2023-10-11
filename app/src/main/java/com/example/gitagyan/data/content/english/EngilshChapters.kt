package com.example.gitagyan.data.content.english

import com.example.gitagyan.data.content.Chapter
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter1
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter10
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter11
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter12
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter13
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter14
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter15
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter16
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter17
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter18
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter2
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter3
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter4
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter5
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter6
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter7
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter8
import com.example.gitagyan.data.content.english.chapters.getEnglishChapter9

fun getEnglishChapters() : List<Chapter>{
    return listOf(
        Chapter(
            chapterId = "1",
            chapter = "Chapter 1",
            chapterName = "The Yoga of Dejection of Arjuna",
            description = "Verse 1-11: Description of the principal warriors on both sides with their fighting qualities.\n" +
                    "Verse 12-19: Blowing of conches by the warriors on both sides.\n" +
                    "Verse 20-27: Arjuna observes the warriors drawn up for battle.\n" +
                    "Verse 28-47: Overwhelmed by infatuation, Arjuna gives expression to his faint-heartedness, tenderness and grief.",
            chapterContent = getEnglishChapter1(),
            totalVerses = "Total Verses: 47"
        ),
        Chapter(
            chapterId = "2",
            chapter = "Chapter 2",
            chapterName = "The Yoga of Knowledge",
            description = "Verse 1-10 Arjuna and Shri Krishna discussing Arjuna's faint-heartedness.\n" +
                    "Verse 11-30: Sankhyayoga (the Yoga of Knowledge) described.\n" +
                    "Verse 31-38: The Kshatriya's duty to engage himself in fight.\n" +
                    "Verse 39-53: Karmayoga (the Yoga of Selfless Action) described.\n" +
                    "Verse 54-72: Marks of the man of stable mind and his glories described.",
            chapterContent = getEnglishChapter2(),
            totalVerses = "Total Verses: 72"
        ),
        Chapter(
            chapterId = "3",
            chapter = "Chapter 3",
            chapterName = "The Yoga of Action",
            description = "Verse 1-8: Importance of the performance of duty, in a detached way, according to both Jnanayoga and Karmayoga.\n" +
                    "Verse 9-16: The necessity of performing sacrifices, etc.\n" +
                    "Verse 17-24: The necessity for action on the part of the wise, and even on the part of God Himself, for the good of the world.\n" +
                    "Verse 25-35: Marks of the wise and the unwise; instruction about performance of action without attraction and repulsion.\n" +
                    "Verse 36-43: How to overcome desire.",
            chapterContent = getEnglishChapter3(),
            totalVerses = "Total Verses: 43"
        ),
        Chapter(
            chapterId = "4",
            chapter = "Chapter 4",
            chapterName = "The Yoga of Knowlegde as well as the disciplines of Action and Knowledge",
            description = "Verse 1-18: The glory of God with attributes; Karmayoga, or selfless action, described.\n" +
                    "Verse 19-23: The conduct of Yog∂s and sages, its glory described.\n" +
                    "Verse 24-32: Different forms of sacrifices described with their fruits.\n" +
                    "Verse 33-42: The glory of Knowledge described.",
            chapterContent = getEnglishChapter4(),
            totalVerses = "Total Verses: 42"
        ),
        Chapter(
            chapterId = "5",
            chapter = "Chapter 5",
            chapterName = "The Yoga of Action and Knowledge",
            description = "Verse 1-6: Sankhyayoga and the Yoga of disinterested action described.\n" +
                    "Verse 7-12: Marks of the Sankhyayogi and Nishkama Karmayogi-their glories described.\n" +
                    "Verse 13-26: Jnanayoga, or the Yoga of Knowledge.\n" +
                    "Verse 27-29: Dhyanayoga, or meditation, together with Devotion, described.",
            chapterContent = getEnglishChapter5(),
            totalVerses = "Total Verses: 29"
        ),
        Chapter(
            chapterId = "6",
            chapter = "Chapter 6",
            chapterName = "The Yoga of Self-Control",
            description = "Verse 1-4: Karmayoga, or the Yoga of disinterested Action, described; marks of one who has attained Yoga.\n" +
                    "Verse 5-10: Urging one to uplift the self; marks of the God-realized soul.\n" +
                    "Verse 11-32: Detailed description of Dhyånayoga.\n"+
                    "Verse 33-36: The question of Mind-control discussed.\n" +
                    "Verse 37-47: The fate of one who falls from Yoga; the glory of Dhyanayoga described.",
            chapterContent = getEnglishChapter6(),
            totalVerses = "Total Verses: 47"
        ),
        Chapter(
            chapterId = "7",
            chapter = "Chapter 7",
            chapterName = "The Yoga of Jnana (Knowledge of Nirguna Brahma) and Vijnana (Knowledge of Manifest Divinity)",
            description = "Verse 1-7: Wisdom with real Knowledge of Manifest Divinity.\n" +
                    "Verse 8-12: Inherence of God in all objects as their Cause.\n" +
                    "Verse 13-19: Condemnation of men of demoniacal nature and praise of devotees.\n" +
                    "Verse 20-23: The question of worship of other gods.\n" +
                    "Verse 24-30: Condemnation of men, who are ignorant of the glory and true nature of God, and approbation of those who know them.",
            chapterContent = getEnglishChapter7(),
            totalVerses = "Total Verses: 30"
        ),
        Chapter(
            chapterId = "8",
            chapter = "Chapter 8",
            chapterName = "The Yoga of Indestructible Brahma",
            description = "Verse 1-7: Answer to Arjuna's seven questions on Brahma, Adhyatma and Karma (Action), etc.\n" +
                    "Verse 8-22: The subject of Bhaktiyoga discussed.\n" +
                    "Verse 23-28: The bright and dark paths described.",
            chapterContent = getEnglishChapter8(),
            totalVerses = "Total Verses: 28"
        ),
        Chapter(
            chapterId = "9",
            chapter = "Chapter 9",
            chapterName = "The Yoga of Sovereign Science and Sovereign Secret",
            description = "Verse 1-6: The subject of Jnana (Knowledge) with its glory described.\n" +
                    "Verse 7-10: The origin of the world discussed.\n" +
                    "Verse 11-15: Condemnation of men of the demoniacal nature, who despise God, and the method of Bhajana of men possessed of the divine nature.\n" +
                    "Verse 16-19: Description of God, as the soul of everything, and His glory.\n" +
                    "Verse 20-25: The fruits of worship with a motive and without motive.\n" +
                    "Verse 26-34: The glory of Devotion practised disinterestedly.",
            chapterContent = getEnglishChapter9(),
            totalVerses = "Total Verses: 34"
        ),
        Chapter(
            chapterId = "10",
            chapter = "Chapter 10",
            chapterName = "The Yoga of Divine Glories",
            description = "Verse 1-7: Description of God's glories and power of Yoga with the fruit of their knowledge.\n" +
                    "Verse 8-11: Bhaktiyoga-its fruit and glory.\n" +
                    "Verse 12-18: Arjuna offers his praises to God and prays to the Lord for a description of His glories and power of Yoga.\n" +
                    "Verse 19-42: The Lord describes His glories and power of Yoga.",
            chapterContent = getEnglishChapter10(),
            totalVerses = "Total Verses: 42"
        ),
        Chapter(
            chapterId = "11",
            chapter = "Chapter 11",
            chapterName = "The Yoga of the Vision of the Universal Form",
            description = "Verse 1-4: Arjuna prays to the Lord for a vision of His Universal Form.\n" +
                    "Verse 5-8: The Lord describes His Universal Form.\n" +
                    "Verse 9-14: The Universal Form described by Sanjaya to Dhritrashtra.\n" +
                    "Verse 15-31: Arjuna sees the Lord's Universal Form and offers praises to the Lord.\n" +
                    "Verse 32-34: God describes His glory and exhorts Arjuna to fight.\n" +
                    "Verse 35-46: Overtaken by fright, Arjuna offers praises to God, and prays for a sight of the Lord's Four-armed Form.\n" +
                    "Verse 47-50: The Lord describes the glory of the vision of His Universal Form, and reveals to Arjuna His Four-armed, gentle Form.\n" +
                    "Verse 51-55: The impossibility of obtaining a sight of the Four-armed Form without exclusive Devotion, which is described with its fruit.",
            chapterContent = getEnglishChapter11(),
            totalVerses = "Total Verses: 55"
        ),
        Chapter(
            chapterId = "12",
            chapter = "Chapter 12",
            chapterName = "The Yoga of Devotion",
            description = "Verse 1-12: Respective merits of the worshippers of God with Form and without Form, and the means of God-realization.\n" +
                    "Verse 13-20: Marks of the God-realized soul.",
            chapterContent = getEnglishChapter12(),
            totalVerses = "Total Verses: 20"
        ),
        Chapter(
            chapterId = "13",
            chapter = "Chapter 13",
            chapterName = "The Yoga of Discrimination between the field and the Knower of the field",
            description = "Verse 1-18: The subject of \"Field\" and the Knower of the \"Field\", together with Knowledge.\n" +
                    "Verse 19-34: The subject of Prakriti and Purusha (Matter and Spirit) together with knowledge.",
            chapterContent = getEnglishChapter13(),
            totalVerses = "34"
        ),
        Chapter(
            chapterId = "14",
            chapter = "Chapter 14",
            chapterName = "The Yoga of Division of three Gunas",
            description = "Verse 1-4: The glory of Knowledge; evolution of the world from Prakriti and Purusha.\n" +
                    "Verse 5-18: The qualities of Sattva, Rajas and Tamas described.\n" +
                    "Verse 19-27: Means of God-realization, and marks of the soul who has transcended the Gunas.",
            chapterContent = getEnglishChapter14(),
            totalVerses = "27"
        ),
        Chapter(
            chapterId = "15",
            chapter = "Chapter 15",
            chapterName = "The Yoga of the Supreme Person",
            description = "Verse 1-6: Description of the Universe as a tree and the means of God-realization.\n"+
                    "Verse 7-11: The Jivatma, or individual soul.\n" +
                    "Verse 12-15: God and His Glory described.\n" +
                    "Verse 16-20: The perishable (bodies of all beings), the imperishable (Jivatma) and the Supreme Person.",
            chapterContent = getEnglishChapter15(),
            totalVerses = "Total Verses: 20"
        ),
        Chapter(
            chapterId = "16",
            chapter = "Chapter 16",
            chapterName = "The Yoga of Division between the Divine and the Demoniacal Properties",
            description = "Verse 1-5: The Divine and the demoniacal properties described with their fruit.\n" +
                    "Verse 6-20: Marks of man possessed of the demoniacal properties and their damnation described.\n" +
                    "Verse 21-24: Instruction about renouncing conduct opposed to the scriptures and exhortation to follow the scriptures.",
            chapterContent = getEnglishChapter16(),
            totalVerses = "Total Verses: 24"
        ),
        Chapter(
            chapterId = "17",
            chapter = "Chapter 17",
            chapterName = "The Yoga of the Division of the Threefold Faith",
            description = "Verse 1-6: Discussion on Faith and on the fate of men who perform austere penance not enjoined by the scriptures.\n" +
                    "Verse 7-22: Different kinds of food, sacrifice, penance and charity described.\n" +
                    "Verse 23-28: The meaning and intention of uttering \"Om Tat Sat\" explained.",
            chapterContent = getEnglishChapter17(),
            totalVerses = "Total Verses: 28"
        ),
        Chapter(
            chapterId = "18",
            chapter = "Chapter 18",
            chapterName = "The Yoga of Liberation through the Path of Knowledge and Self-Surrender",
            description = "Verse 1-12: The subject of Tyaga or Relinquishment.\n" +
                    "Verse 13-18: Causes of Karma according to the Sankhya system.\n" +
                    "Verse 19-40: Classification of knowledge, action, doer, reason, firmness and joy according to the three Gunas.\n" +
                    "Verse 41-48: Duties attaching to each caste and the fruit of their performance.\n" +
                    "Verse 49-55: The path of Knowledge described.\n" +
                    "Verse 56-66: The path of Karmayoga, or selfless action, together with Devotion.\n" +
                    "Verse 67-78: The glory of the Gita described.",
            chapterContent = getEnglishChapter18(),
            totalVerses = "Total Verses: 78"
        )
    )
}
