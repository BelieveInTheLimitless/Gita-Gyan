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
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy land of Kurukshetra, eager to fight, what did my sons and the sons of Pandu do?"
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
                    verse = "सञ्जय उवाच\n\nतं तथा कृपयाऽविष्टमश्रुपूर्णाकुलेक्षणम्।\n\nविषीदन्तमिदं वाक्यमुवाच मधुसूदनः।।2.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Sanjaya said : Shri Krishna then addressed the following words to Arjuna, who was, as mentioned before, overwhelmed with pity, whose eyes were filled with tears and agitated, and who was full of sorrow."
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
                    verse = "अर्जुन उवाच\n\nज्यायसी चेत्कर्मणस्ते मता बुद्धिर्जनार्दन।\n\nतत्किं कर्मणि घोरे मां नियोजयसि केशव।।3.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : Krishna if You consider Knowledge as superior to Action, why then do You urge me to this dreadful action, Keshava!"
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
                    verse = "श्री भगवानुवाच\n\nइमं विवस्वते योगं प्रोक्तवानहमव्ययम्।\n\nविवस्वान् मनवे प्राह मनुरिक्ष्वाकवेऽब्रवीत्।।4.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said: I revealed this immortal Yoga to Vivasvan (Sun-god); Vivasvan conveyed it to Manu (his son); and Manu imparted it to (his son) Ikshwaku."
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
                    verse = "अर्जुन उवाच\n\nसंन्यासं कर्मणां कृष्ण पुनर्योगं च शंससि।\n\nयच्छ्रेय एतयोरेकं तन्मे ब्रूहि सुनिश्िचतम्।।5.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : Krishna, you extol Sankhyayoga (the Yoga of Knowledge) and then the Yoga of Action. Pray, tell me which of the two is decidedly conducive to my good."
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
                    verse = "श्री भगवानुवाच\n\nअनाश्रितः कर्मफलं कार्यं कर्म करोति यः।\n\nस संन्यासी च योगी च न निरग्निर्न चाक्रियः।।6.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : He who does his duty without expecting the fruit of actions is a Sannyasi (Sankhyayogi) and a Yogi (Karmayogi) both. He is no Sannyasi (renouncer) who has merely renounced the sacred fire; even so, he is no Yogi who has merely given up all activity."
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
                    verse = "श्री भगवानुवाच\n\nमय्यासक्तमनाः पार्थ योगं युञ्जन्मदाश्रयः।\n\nअसंशयं समग्रं मां यथा ज्ञास्यसि तच्छृणु।।7.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : Arjuna, now listen how with the mind attached to Me (through exclusive love) and practising Yoga with absolute dependence on Me, you will know Me, the repository of all power, strength and glory and other attributes, the Universal soul, in entirety and without any shadow of doubt."
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
                    verse = "अर्जुन उवाच\n\nकिं तद्ब्रह्म किमध्यात्मं किं कर्म पुरुषोत्तम।\n\nअधिभूतं च किं प्रोक्तमधिदैवं किमुच्यते।।8.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : Krishna, what is that Brahma (Absolute), what is Adhyatma (Spirit), and what is Karma (Action)? What is called Adhibhuta (Matter) and what is termed as Adhidaiva (Divine Intelligence)?"
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
                    verse = "श्री भगवानुवाच\n\nइदं तु ते गुह्यतमं प्रवक्ष्याम्यनसूयवे।\n\nज्ञानं विज्ञानसहितं यज्ज्ञात्वा मोक्ष्यसेऽशुभात्।।9.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : To you, who are devoid of the carping spirit, I shall now unfold the most secret knowledge of Nirguna Brahma along with the knowledge of manifest Divinity, knowing which you shall be free from the evil of worldly existence."
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
                    verse = "श्री भगवानुवाच\n\nभूय एव महाबाहो श्रृणु मे परमं वचः।\n\nयत्तेऽहं प्रीयमाणाय वक्ष्यामि हितकाम्यया।।10.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : Arjuna, hear once again My supreme word, which I shall speak to you, who are so loving, out of solicitude for your welfare."
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
                    verse = "अर्जुन उवाच\n\nमदनुग्रहाय परमं गुह्यमध्यात्मसंज्ञितम्।\n\nयत्त्वयोक्तं वचस्तेन मोहोऽयं विगतो मम।।11.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : Thanks to the most profound words of spiritual wisdom that You have spoken out of kindness to me, this delusion of mine has entirely disappeared."
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
                    verse = "अर्जुन उवाचएवं सततयुक्ता ये भक्तास्त्वां पर्युपासते।येचाप्यक्षरमव्यक्तं तेषां के योगवित्तमाः।।12.1।।",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : The devotees exclusively and constantly devoted to You in the manner stated just earlier, adore You as possessed of form and attributes, and those who adore as the supreme Reality only the indestructible unmanifest Brahma (who is Truth, Knowledge and Bliss solidified) of these two types of worshippers who are the best knowers of Yoga?"
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
                    verse = "अर्जुन उवाच\n\nप्रकृतिं पुरुषं चैव क्षेत्रं क्षेत्रज्ञमेव च।\n\nएतद्वेदितुमिच्छामि ज्ञानं ज्ञेयं च केशव।।13.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : This body, Arjuna is termed as the Field (Kshetra) and he who knows it, is called the knower of the Field (Kshetrajna) by the sages discerning the truth about both."
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
                    verse = "श्री भगवानुवाचपरं भूयः प्रवक्ष्यामि ज्ञानानां ज्ञानमुत्तमम्।यज्ज्ञात्वा मुनयः सर्वे परां सिद्धिमितो गताः।।14.1।।",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : I shall expound once more the supreme knowledge, the best of all knowledge, acquiring which all sages have attained highest perfection, being liberated from this mundane existence."
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
                    verse = "श्री भगवानुवाचऊर्ध्वमूलमधःशाखमश्वत्थं प्राहुरव्ययम्।छन्दांसि यस्य पर्णानि यस्तं वेद स वेदवित्।।15.1।।",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : He who knows the Pipala tree (in the form of creation); which is said to be imperishable with its roots in the Primeval Being (God), whose stem is represented by Brahma (the Creator), and whose leaves are the Vedas, is a knower of the purport of the Vedas."
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
                    verse = "श्री भगवानुवाच\n\nअभयं सत्त्वसंशुद्धिः ज्ञानयोगव्यवस्थितिः।\n\nदानं दमश्च यज्ञश्च स्वाध्यायस्तप आर्जवम्।।16.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Absolute fearlessness, perfect purity of mind, constant fixity in the Yoga of meditation for the sake of Self-realization, and even so, charity in its Sattvika form, control of the senses, worship of God and other deities as well as of one's elders including the performance of Agnihotra (pouring oblations into the sacred fire) and other sacred duties, study and teaching of the Vedas and other sacred books as well as the chanting of God's names and glories, suffering hardships for the discharge of one's sacred obligations and uprightness of mind as well as of the body and senses."
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
                    verse = "अर्जुन उवाचये शास्त्रविधिमुत्सृज्य यजन्ते श्रद्धयाऽन्विताः।तेषां निष्ठा तु का कृष्ण सत्त्वमाहो रजस्तमः।।17.1।।",
                    verse_language = "English",
                    verse_meaning = "Arjuna said: Those, endowed with faith, who worship gods and others, disregarding the injunctions of the scriptures, where do they stand, Krishna - in Sattva, Rajas or Tamas ?"
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
                    verse = "अर्जुन उवाच\n\nसंन्यासस्य महाबाहो तत्त्वमिच्छामि वेदितुम्।\n\nत्यागस्य च हृषीकेश पृथक्केशिनिषूदन।।18.1।।\n ",
                    verse_language = "English",
                    verse_meaning = "Arjuna said: O mighty-armed Shri Krishna, O inner controller of all, O Slayer of Kesi, I wish to know severally the truth of Sannyasa as also of Tyaga."
                )
            ),
            total_verses = 78
        )
    )
}
