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
            chapter_name = "Arjun Vishada Yoga",
            description = "The Yoga of Dejection of Arjuna.\n\nThe first chapter of the Bhagavad Gita introduces the setup, the setting, the characters and the circumstances that led to the epic battle of Mahabharata, fought between the Pandavas and the Kauravas. It outlines the reasons that led to the revelation of the of Bhagavad Gita.\nAs both armies stand ready for the battle, the mighty warrior Arjuna, on observing the warriors on both sides becomes increasingly sad and depressed due to the fear of losing his relatives and friends and the consequent sins attributed to killing his own relatives. So, he surrenders to Lord Krishna, seeking a solution. Thus, follows the wisdom of the Bhagavad Gita.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "धृतराष्ट्र उवाच\n\nधर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः।\nमामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।1.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Dhritarastra said: Sanjaya, gathered on the holy land of Kurukshetra, eager to fight, what did my sons and the sons of Pandu do?"
                )
            ),
            total_verses = 47
        ),
        Chapter(
            chapter_id = "II",
            chapter_name = "Sankhya Yoga",
            description = "The Yoga of Knowledge.\n\nThe second chapter is one the most important chapter of the Bhagavad Gita as Lord Krishna condenses the teachings of the entire Gita in this chapter. This chapter is the essence of the entire Gita. \nSankhya Yoga can be categorized into 4 main topics - \n1. Arjuna completely surrenders himself to Lord Krishna and accepts his position as a disciple and Krishna as his Guru. He requests Krishna to guide him on how to dismiss his sorrow.\n2. Explanation of the main cause of all grief, which is ignorance of the true nature of Self.\n3. Karma Yoga - the discipline of selfless action without being attached to its fruits.\n4. Description of a Perfect Man - One whose mind is steady and one-pointed.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "सञ्जय उवाच\n\nतं तथा कृपयाऽविष्टमश्रुपूर्णाकुलेक्षणम्।\nविषीदन्तमिदं वाक्यमुवाच मधुसूदनः।।2.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Sanjaya said : Shri Krishna then addressed the following words to Arjuna, who was, as mentioned before, overwhelmed with pity, whose eyes were filled with tears and agitated, and who was full of sorrow."
                )
            ),
            total_verses = 72
        ),
        Chapter(
            chapter_id = "III",
            chapter_name = "Karma Yoga",
            description = "The Yoga of Action.\n\nThe third chapter of the Bhagavad Gita emphasizes the importance of karma in life. Shri Krishna reveals that it is important for every human being to engage in some sort of activity in this material world. Further, he describes the kinds of actions that lead to bondage and the kinds that lead to liberation. Those persons who continue to perform their respective duties externally for the pleasure of the Supreme, without attachment to its rewards get liberation at the end.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "अर्जुन उवाच\n\nज्यायसी चेत्कर्मणस्ते मता बुद्धिर्जनार्दन।\nतत्किं कर्मणि घोरे मां नियोजयसि केशव।।3.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : Krishna if You consider Knowledge as superior to Action, why then do You urge me to this dreadful action, Keshava!"
                )
            ),
            total_verses = 43
        ),
        Chapter(
            chapter_id = "IV",
            chapter_name = "Jnana Karmasanyas Yoga",
            description = "The Yoga of Knowlegde as well as the disciplines of Action and Knowledge.\n\nThe fourth chapter of the Bhagavad Gita, Shri Krishna glorifies the Karma Yoga and imparts the Transcendental Knowledge (the knowledge of the soul and the Ultimate Truth) to Arjuna. He reveals the reason behind his appearance in this material world. He reveals that even though he is eternal, he reincarnates time after time to re-establish dharma and peace on this Earth. His births and activities are eternal and are never contaminated by material flaws. Those persons who know and understand this Truth engage in his devotion with full faith and eventually attain Him. They do not have to take birth in this world again.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "श्री भगवानुवाच\n\nइमं विवस्वते योगं प्रोक्तवानहमव्ययम्।\nविवस्वान् मनवे प्राह मनुरिक्ष्वाकवेऽब्रवीत्।।4.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said: I revealed this immortal Yoga to Vivasvan (Sun-god); Vivasvan conveyed it to Manu (his son); and Manu imparted it to (his son) Ikshwaku."
                )
            ),
            total_verses = 42
        ),
        Chapter(
            chapter_id = "V",
            chapter_name = "Karmasanyas Yoga",
            description = "The Yoga of Action and Knowledge.\n\nIn the fifth chapter, Shri Krishna compares the paths of renunciation in actions (Karma Sanyas) and actions with detachment (Karma Yoga) and explains that both are means to reach the same goal and we can choose either. A wise person should perform his/her worldly duties without attachment to the fruits of his/her actions and dedicate them to God. This way they remain unaffected by sin and eventually attain liberation.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "अर्जुन उवाच\n\nसंन्यासं कर्मणां कृष्ण पुनर्योगं च शंससि।\nयच्छ्रेय एतयोरेकं तन्मे ब्रूहि सुनिश्िचतम्।।5.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : Krishna, you extol Sankhyayoga (the Yoga of Knowledge) and then the Yoga of Action. Pray, tell me which of the two is decidedly conducive to my good."
            )
            ),
            total_verses = 29
        ),
        Chapter(
            chapter_id = "VI",
            chapter_name = "Atmasanyama Yoga",
            description = "The Yoga of Self-Control.\n\nIn the sixth chapter of the Bhagavad Gita, Shri Krishna reveals the \"Yoga of Meditation\" and how to practise this Yoga. He discusses the role of action in preparing for Meditation, how performing duties in devotion purifies one's mind and heightens one's spiritual consciousness. He explains in detail the obstacles that one faces when trying to control their mind and the exact methods by which one can conquer their mind. He reveals how one can focus their mind on Paramatma and unite with the God.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "श्री भगवानुवाच\n\nअनाश्रितः कर्मफलं कार्यं कर्म करोति यः।\nस संन्यासी च योगी च न निरग्निर्न चाक्रियः।।6.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : He who does his duty without expecting the fruit of actions is a Sannyasi (Sankhyayogi) and a Yogi (Karmayogi) both. He is no Sannyasi (renouncer) who has merely renounced the sacred fire; even so, he is no Yogi who has merely given up all activity."
                )
            ),
            total_verses = 47
        ),
        Chapter(
            chapter_id = "VII",
            chapter_name = "Jnanavijnana Yoga",
            description = "The Yoga of Jnana (Knowledge of Nirguna Brahma) and Vijnana (Knowledge of Manifest Divinity).\n\nIn the seventh chapter of the Bhagavad Gita, Shri Krishna reveals that he is the Supreme Truth, the principal cause and the sustaining force of everything. He reveals his illusionary energy in this material world called Maya, which is very difficult to overcome but those who surrender their minds unto Him attain Him easily. He also describes the four types of people who surrender to Him in devotion and the four kinds that don't. Krishna confirms that He is the Ultimate Reality and those who realize this Truth reach the pinnacle of spiritual realization and unite with the Lord.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "श्री भगवानुवाच\n\nमय्यासक्तमनाः पार्थ योगं युञ्जन्मदाश्रयः।\nअसंशयं समग्रं मां यथा ज्ञास्यसि तच्छृणु।।7.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : Arjuna, now listen how with the mind attached to Me (through exclusive love) and practising Yoga with absolute dependence on Me, you will know Me, the repository of all power, strength and glory and other attributes, the Universal soul, in entirety and without any shadow of doubt."
                )
            ),
            total_verses = 30
        ),
        Chapter(
            chapter_id = "VIII",
            chapter_name = "Akshar Brahma Yoga",
            description = "The Yoga of Indestructible Brahma.\n\nIn the eighth chapter of the Bhagavad Gita, Shri Krishna reveals the importance of the last thought before death. If we can remember Krishna at the time of death, we will certainly attain him. Thus, it is very important to be in constant awareness of the Lord at all times, thinking of Him and chanting His names at all times. By perfectly absorbing their mind in Him through constant devotion, one can go beyond this material existence to Lord's Supreme abode.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "अर्जुन उवाच\n\nकिं तद्ब्रह्म किमध्यात्मं किं कर्म पुरुषोत्तम।\nअधिभूतं च किं प्रोक्तमधिदैवं किमुच्यते।।8.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : Krishna, what is that Brahma (Absolute), what is Adhyatma (Spirit), and what is Karma (Action)? What is called Adhibhuta (Matter) and what is termed as Adhidaiva (Divine Intelligence)?"
                )
            ),
            total_verses = 28
        ),
        Chapter(
            chapter_id = "IX",
            chapter_name = "Rajvidya Rajguhya Yoga",
            description = "The Yoga of Sovereign Science and Sovereign Secret.\n\nIn the ninth chapter of the Bhagavad Gita, Shri Krishna explains that He is Supreme and how this material existence is created, maintained and destroyed by His Yogmaya and all beings come and go under his supervision. He reveals the Role and the Importance of Bhakti (transcendental devotional service) towards our Spiritual Awakening. In such devotion, one must live for the God, offer everything that he possesses to Him and do everything for Him only. One who follows such devotion becomes free from the bonds of this material world and unites with the Lord.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "श्री भगवानुवाच\n\nइदं तु ते गुह्यतमं प्रवक्ष्याम्यनसूयवे।\nज्ञानं विज्ञानसहितं यज्ज्ञात्वा मोक्ष्यसेऽशुभात्।।9.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : To you, who are devoid of the carping spirit, I shall now unfold the most secret knowledge of Nirguna Brahma along with the knowledge of manifest Divinity, knowing which you shall be free from the evil of worldly existence."
                )
            ),
            total_verses = 34
        ),
        Chapter(
            chapter_id = "X",
            chapter_name = "Vibhuti Yoga",
            description = "The Yoga of Divine Glories.\n\nIn the tenth chapter of the Bhagavad Gita, Shri Krishna reveals Himself as the cause of all causes. He describes His various manifestations and opulences in order to increase Arjuna's Bhakti. Arjuna is fully convinced of Lord's paramount position and proclaims him to be the Supreme Personality. He prays to Krishna to describe more of His divine glories which are like nectar to hear.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "श्री भगवानुवाच\n\nभूय एव महाबाहो श्रृणु मे परमं वचः।\nयत्तेऽहं प्रीयमाणाय वक्ष्यामि हितकाम्यया।।10.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : Arjuna, hear once again My supreme word, which I shall speak to you, who are so loving, out of solicitude for your welfare."
                )
            ),
            total_verses = 42
        ),
        Chapter(
            chapter_id = "XI",
            chapter_name = "Vishwaroopa Darshan Yoga",
            description = "The Yoga of the Vision of the Universal Form.\n\nIn he eleventh chapter of the Bhagavad Gita, Arjuna requests Krishna to reveal His Universal Cosmic Form that encompasses all the universes, the entire existence. Arjuna is granted divine vision to be able to see the entirety of creation in the body of the Supreme Lord Krishna.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "अर्जुन उवाच\n\nमदनुग्रहाय परमं गुह्यमध्यात्मसंज्ञितम्।\nयत्त्वयोक्तं वचस्तेन मोहोऽयं विगतो मम।।11.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : Thanks to the most profound words of spiritual wisdom that You have spoken out of kindness to me, this delusion of mine has entirely disappeared."
                )
            ),
            total_verses = 55
        ),
        Chapter(
            chapter_id = "XII",
            chapter_name = "Bhakti Yoga",
            description = "The Yoga of Devotion.\n\nIn the twelfth chapter of the Bhagavad Gita, Shri Krishna emphasizes the superiority of Bhakti Yoga (the path of devotion) over all other types of spiritual disciplines and reveals various aspects of devotion. He further explains that the devotees who perform pure devotional service to Him, with their consciousness, merged in Him and all their actions dedicated to Him, are quickly liberated from the cycle of life and death. He also describes the various qualities of the devotees who are very dear to Him.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "अर्जुन उवाच\n\nएवं सततयुक्ता ये भक्तास्त्वां पर्युपासते।\nयेचाप्यक्षरमव्यक्तं तेषां के योगवित्तमाः।।12.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Arjuna said : The devotees exclusively and constantly devoted to You in the manner stated just earlier, adore You as possessed of form and attributes, and those who adore as the supreme Reality only the indestructible unmanifest Brahma (who is Truth, Knowledge and Bliss solidified) of these two types of worshippers who are the best knowers of Yoga?"
                )
            ),
            total_verses = 20
        ),
        Chapter(
            chapter_id = "XIII",
            chapter_name = "Kshetra Kshetrajna Vibhaga Yoga",
            description = "The Yoga of Discrimination between the field and the Knower of the field.\n\nIN the thirteenth chapter of the Bhagavad Gita, the word \"kshetra\" means \"the field\", and the \"kshetrajna\" means \"the knower of the field\". We can think of our material body as the field and our immortal soul as the knower of the field. In this chapter, Krishna discriminates between the physical body and the immortal soul. He explains that the physical body is temporary and perishable whereas the soul is permanent and eternal. The physical body can be destroyed but the soul can never be destroyed. The chapter then describes God, who is the Supreme Soul. All the individual souls have originated from the Supreme Soul. One who clearly understands the difference between the body, the Soul and the Supreme Soul attains the realization of Brahman.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "अर्जुन उवाच\n\nप्रकृतिं पुरुषं चैव क्षेत्रं क्षेत्रज्ञमेव च।\nएतद्वेदितुमिच्छामि ज्ञानं ज्ञेयं च केशव।।13.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : This body, Arjuna is termed as the Field (Kshetra) and he who knows it, is called the knower of the Field (Kshetrajna) by the sages discerning the truth about both."
                )
            ),
            total_verses = 34
        ),
        Chapter(
            chapter_id = "XIV",
            chapter_name = "Gunatraya Vibhaga Yoga",
            description = "The Yoga of Division of three Gunas.\n\nIn the fourteenth chapter of the Bhagavad Gita, Shri Krishna reveals the three gunas (modes) of the material nature - goodness, passion and ignorance which everything in the material existence is influenced by. He further explains the essential characteristics of each of these modes, their cause and how they influence a living entity affected by them. He then reveals the various characteristics of the persons who have gone beyond these gunas. The chapter ends with Krishna reminding us of the power of pure devotion to God and how attachment to God can help us transcend these gunas.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "श्री भगवानुवाच\n\nपरं भूयः प्रवक्ष्यामि ज्ञानानां ज्ञानमुत्तमम्।\nयज्ज्ञात्वा मुनयः सर्वे परां सिद्धिमितो गताः।।14.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : I shall expound once more the supreme knowledge, the best of all knowledge, acquiring which all sages have attained highest perfection, being liberated from this mundane existence."
                )
            ),
            total_verses = 27
        ),
        Chapter(
            chapter_id = "XV",
            chapter_name = "Purushottama Yoga",
            description = "The Yoga of the Supreme Person.\n\nThe fifteenth chapter of the Bhagavad Gita is \"Purushottama Yoga\". In Sanskrit, Purusha means the \"All-pervading God\", and Purushottam means the timeless & transcendental aspect of God. Shri Krishna reveals that the purpose of this Transcendental knowledge of the God is to detach ourselves from the bondage of the material world and to understand Krishna as the Supreme Divine Personality, who is the eternal controller and sustainer of the world. One who understands this Ultimate Truth surrenders to Him and engages in His devotional service.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "श्री भगवानुवाच\n\nऊर्ध्वमूलमधःशाखमश्वत्थं प्राहुरव्ययम्\n।छन्दांसि यस्य पर्णानि यस्तं वेद स वेदवित्।।15.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Shri Bhagavan said : He who knows the Pipala tree (in the form of creation); which is said to be imperishable with its roots in the Primeval Being (God), whose stem is represented by Brahma (the Creator), and whose leaves are the Vedas, is a knower of the purport of the Vedas."
                )
            ),
            total_verses = 20
        ),
        Chapter(
            chapter_id = "XVI",
            chapter_name = "Daivasura Sampad Vibhaga Yoga",
            description = "The Yoga of Division between the Divine and the Demoniacal Properties.\n\nThe sixteenth chapter of the Bhagavad Gita is \"Daivasura Sampad Vibhaga Yoga\". In this chapter, Krishna describes explicitly the two kinds of natures among human beings - divine and demoniac. Those who possess demonaic qualities associate themselves with the modes of passion and ignorance do not follow the regulations of the scriptures and embrace materialistic views. These people attain lower births and further material bondage. But people who possess divine qualities, follow the instructions of the scriptures, associate themselves with the mode of goodness and purify the mind through spiritual practices. This leads to the enhancement of divine qualities and they eventually attain spiritual realization.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "श्री भगवानुवाच\n\nअभयं सत्त्वसंशुद्धिः ज्ञानयोगव्यवस्थितिः।\nदानं दमश्च यज्ञश्च स्वाध्यायस्तप आर्जवम्।।16.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Absolute fearlessness, perfect purity of mind, constant fixity in the Yoga of meditation for the sake of Self-realization, and even so, charity in its Sattvika form, control of the senses, worship of God and other deities as well as of one's elders including the performance of Agnihotra (pouring oblations into the sacred fire) and other sacred duties, study and teaching of the Vedas and other sacred books as well as the chanting of God's names and glories, suffering hardships for the discharge of one's sacred obligations and uprightness of mind as well as of the body and senses."
                )
            ),
            total_verses = 24
        ),
        Chapter(
            chapter_id = "XVII",
            chapter_name = "Shraddhatraya Vibhaga Yoga",
            description = "The Yoga of the Division of the Threefold Faith.\n\nThe seventeenth chapter of the Bhagavad Gita is \"Shraddhatraya Vibhaga Yoga\". In this chapter, Krishna describes the three types of faith corresponding to the three modes of the material nature. Lord Krishna further reveals that it is the nature of faith that determines the quality of life and the character of living entities. Those who have faith in passion and ignorance perform actions that yield temporary, material results while those who have faith in goodness perform actions in accordance with scriptural instructions and hence their hearts get further purified.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "अर्जुन उवाच\n\nये शास्त्रविधिमुत्सृज्य यजन्ते श्रद्धयाऽन्विताः।\nतेषां निष्ठा तु का कृष्ण सत्त्वमाहो रजस्तमः।।17.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Arjuna said: Those, endowed with faith, who worship gods and others, disregarding the injunctions of the scriptures, where do they stand, Krishna - in Sattva, Rajas or Tamas ?"
                )
            ),
            total_verses = 28
        ),
        Chapter(
            chapter_id = "XVIII",
            chapter_name = "Moksha Sanyas Yoga",
            description = "The Yoga of Liberation through the Path of Knowledge and Self-Surrender.\n\nThe eighteenth chapter of the Bhagavad Gita is \"Moksha Sanyas Yoga\". Arjuna requests the Lord to explain the difference between the two types of renunciations - sanyaas(renunciation of actions) and tyaag(renunciation of desires). Krishna explains that a sanyaasi is one who abandons family and society in order to practise spiritual discipline whereas a tyaagi is one who performs their duties without attachment to the rewards of their actions and dedicating them to the God. Krishna recommends the second kind of renunciation - tyaag. Krishna then gives a detailed analysis of the effects of the three modes of material nature. He declares that the highest path of spirituality is pure, unconditional loving service unto the Supreme Divine Personality, Krishna. If we always remember Him, keep chanting His name and dedicate all our actions unto Him, take refuge in Him and make Him our Supreme goal, then by His grace, we will surely overcome all obstacles and difficulties and be freed from this cycle of birth and death.",
            chapter_content = listOf(
                Verse(
                    verse_id = 1,
                    verse_name = "Verse 1",
                    verse = "अर्जुन उवाच\n\nसंन्यासस्य महाबाहो तत्त्वमिच्छामि वेदितुम्।\nत्यागस्य च हृषीकेश पृथक्केशिनिषूदन।।18.1।।\n",
                    verse_language = "English",
                    verse_meaning = "Arjuna said: O mighty-armed Shri Krishna, O inner controller of all, O Slayer of Kesi, I wish to know severally the truth of Sannyasa as also of Tyaga."
                )
            ),
            total_verses = 78
        )
    )
}
