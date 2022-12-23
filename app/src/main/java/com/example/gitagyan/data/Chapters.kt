package com.example.gitagyan.data

data class Verse(
    val verse_id : Int,
    val verse_name : String,
    val verse : String,
    val verse_language : String,
    val verse_meaning : String
)

data class Chapter(
    val chapter_id : String,
    val chapter_name : String,
    val description : String,
    val chapter_content : List<Verse>,
    val total_verses : Int,
)

fun getChapters() : List<Chapter>{
    return listOf(
        Chapter(
            chapter_id = "I",
            chapter_name = "Arjun Vishad Yoga",
            description = "The Yoga of Dejection of Arjuna",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 47
        ),
        Chapter(
            chapter_id = "II",
            chapter_name = "Sankhya Yoga",
            description = "The Yoga of Knowledge",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 72
        ),
        Chapter(
            chapter_id = "III",
            chapter_name = "Karma Yoga",
            description = "The Yoga of Action",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 43
        ),
        Chapter(
            chapter_id = "IV",
            chapter_name = "Karma Sanyas Yoga",
            description = "The Yoga of Knowlegde as well as the disciplines of Action and Knowledge",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 42
        ),
        Chapter(
            chapter_id = "V",
            chapter_name = "Jnana Karma Sanyas Yoga",
            description = "The Yoga of Action and Knowledge",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 29
        ),
        Chapter(
            chapter_id = "VI",
            chapter_name = "Atma Sayyam Yoga",
            description = "The Yoga of Self-Control",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 47
        ),
        Chapter(
            chapter_id = "VII",
            chapter_name = "Jnana Vijnana Yoga",
            description = "The Yoga of Jnana (Knowledge of Nirguna Brahma) and Vijnana (Knowledge of Manifest Divinity)",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 30
        ),
        Chapter(
            chapter_id = "VIII",
            chapter_name = "Akshar Brahma Yoga",
            description = "The Yoga of Indestructible Brahma",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 28
        ),
        Chapter(
            chapter_id = "IX",
            chapter_name = "Rajvidya Rajguhya Yoga",
            description = "The Yoga of Sovereign Science and Sovereign Secret",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 34
        ),
        Chapter(
            chapter_id = "X",
            chapter_name = "Vibhuti Yoga",
            description = "The Yoga of Divine Glories",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 42
        ),
        Chapter(
            chapter_id = "XI",
            chapter_name = "Vishwaroopa Darshan Yoga",
            description = "The Yoga of the Vision of the Universal Form",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 55
        ),
        Chapter(
            chapter_id = "XII",
            chapter_name = "Bhakti Yoga",
            description = "The Yoga of Devotion",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 20
        ),
        Chapter(
            chapter_id = "XIII",
            chapter_name = "Kshetra Kshetrajna Vibhaga Yoga",
            description = "The Yoga of Discrimination between the field and the Knower of the field",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 34
        ),
        Chapter(
            chapter_id = "XIV",
            chapter_name = "Gunatraya Vibhaga Yoga",
            description = "The Yoga of Division of three Gunas",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 27
        ),
        Chapter(
            chapter_id = "XV",
            chapter_name = "Purushottam Yoga",
            description = "The Yoga of the Supreme Person",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 20
        ),
        Chapter(
            chapter_id = "XVI",
            chapter_name = "Daivasura Sampad Vibhaga Yoga",
            description = "The Yoga of Division between the Divine and the Demoniacal Properties",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 24
        ),
        Chapter(
            chapter_id = "XVII",
            chapter_name = "Shraddhatraya Vibhaga Yoga",
            description = "The Yoga of the Division of the Threefold Faith",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 28
        ),
        Chapter(
            chapter_id = "XVIII",
            chapter_name = "Moksha Sanyasa Yoga",
            description = "The Yoga of Liberation through the Path of Knowledge and Self-Surrender",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\n\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy\nland of Kurukshetra, eager to fight, what did my\nsons and the sons of Pandu do?"
                )
            ),
            total_verses = 78
        )
    )
}
