package com.example.gitagyan.data.content.hindi

import com.example.gitagyan.data.content.Chapter
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter1
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter10
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter11
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter12
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter13
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter14
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter15
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter16
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter17
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter18
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter2
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter3
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter4
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter5
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter6
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter7
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter8
import com.example.gitagyan.data.content.hindi.chapters.getHindiChapter9

fun getHindiChapters(): List<Chapter>{
    return listOf(
        Chapter(
            chapterId = "1",
            chapter = "अध्याय १",
            chapterName = "अर्जुनविषादयोग",
            description = "श्लोक १-११: दोनों सेनाओं के प्रधान शूरवीरों और अन्य महान वीरों का वर्णन\n" +
                    "श्लोक १२-१९: दोनों सेनाओं की शंख-ध्वनि का वर्णन\n" +
                    "श्लोक २०-२७: अर्जुन का सैन्य परिक्षण, गाण्डीव की विशेषता\n" +
                    "श्लोक २८-४७: अर्जुनका विषाद,भगवान के नामों की व्याख्या",
            chapterContent = getHindiChapter1(),
            totalVerses = "कुल श्लोक: ४७"
        ),
        Chapter(
            chapterId = "2",
            chapter = "अध्याय २",
            chapterName = "सांख्ययोग",
            description = "श्लोक १-१०: अर्जुन की कायरता के विषय में श्री कृष्णार्जुन-संवाद\n" +
                    "श्लोक ११-३०: गीताशास्त्रका अवतरण\n" +
                    "श्लोक ३१-३८: क्षत्रिय धर्म और युद्ध करने की आवश्यकता का वर्णन\n" +
                    "श्लोक ३९-५३: कर्मयोग विषय का उपदेश\n" +
                    "श्लोक ५४-७२: स्थिरबुद्धि पुरुष के लक्षण और उसकी महिमा",
            chapterContent = getHindiChapter2(),
            totalVerses = "कुल श्लोक: ७२"
        ),
        Chapter(
            chapterId = "3",
            chapter = "अध्याय ३",
            chapterName = "कर्मयोग",
            description = "श्लोक १-८: ज्ञानयोग और कर्मयोग के अनुसार अनासक्त भाव से नियत कर्म करने की आवश्यकता\n" +
                    "श्लोक ९-१६ यज्ञादि कर्मों की आवश्यकता तथा यज्ञ की महिमा का वर्णन\n" +
                    "श्लोक १७-२४: ज्ञानवान और भगवान के लिए भी लोकसंग्रहार्थ कर्मों की आवश्यकता\n" +
                    "श्लोक २५-३५: अज्ञानी और ज्ञानवान के लक्षण तथा राग-द्वेष से रहित होकर कर्म करने के लिएप्रेरणा\n" +
                    "श्लोक ३६-४३: पापके कारणभूत कामरूपी शत्रु को नष्ट करने का उपदेश ",
            chapterContent = getHindiChapter3(),
            totalVerses = "कुल श्लोक: ४३"
        ),
        Chapter(
            chapterId = "4",
            chapter = "अध्याय ४",
            chapterName = "ज्ञानकर्मसंन्यासयोग",
            description = "श्लोक १-५: योग परंपरा, भगवान के जन्म कर्म की दिव्यता, भक्त लक्षणभगवत्स्वरूप\n" +
                    "श्लोक ६-१८: कर्म-विकर्म एवं अकर्म की व्याख्या\n" +
                    "श्लोक १९-२३: कर्म में अकर्मता-भाव, नैराश्य-सुख, यज्ञ की व्याख्या\n" +
                    "श्लोक २४-३३: फलसहित विभिन्न यज्ञों का वर्णन\n" +
                    "श्लोक ३४-४२: ज्ञान की महिमा तथा अर्जुन को कर्म करने की प्रेरणा ",
            chapterContent = getHindiChapter4(),
            totalVerses = "कुल श्लोक: ४२"
        ),
        Chapter(
            chapterId = "5",
            chapter = "अध्याय ५",
            chapterName = "कर्मसंन्यासयोग",
            description = "श्लोक १-६: ज्ञानयोग और कर्मयोग की एकता, सांख्य पर का विवरण और कर्मयोगकी वरीयता\n" +
                    "श्लोक ७-१२: सांख्ययोगी और कर्मयोगी के लक्षण और उनकी महिमा\n" +
                    "श्लोक १३-२६: ज्ञानयोग का विषय\n" +
                    "श्लोक २७-२९: भक्ति सहित ध्यानयोग तथा भय, क्रोध, यज्ञ आदि का वर्णन",
            chapterContent = getHindiChapter5(),
            totalVerses = "कुल श्लोक: २९"
        ),
        Chapter(
            chapterId = "6",
            chapter = "अध्याय ६",
            chapterName = "आत्मसंयमयोग",
            description = "श्लोक १-४: कर्मयोग का विषय और योगारूढ़ के लक्षण, काम-संकल्प-त्याग कामहत्व\n" +
                    "श्लोक ५-१०: आत्म-उद्धार की प्रेरणा और भगवत्प्राप्त पुरुष के लक्षण एवं एकांतसाधना का महत्व\n" +
                    "श्लोक ११-१५: आसन विधि, परमात्मा का ध्यान, योगी के चार प्रकार\n" +
                    "श्लोक १६-३२: विस्तार से ध्यान योग का विषय\n" +
                    "श्लोक ३३-३६: मन के निग्रह का विषय\n" +
                    "श्लोक ३७-४७: योगभ्रष्ट पुरुष की गति का विषय और ध्यानयोगी की महिमा",
            chapterContent = getHindiChapter6(),
            totalVerses = "कुल श्लोक: ४७"
        ),
        Chapter(
            chapterId = "7",
            chapter = "अध्याय ७",
            chapterName = "ज्ञानविज्ञानयोग",
            description = "श्लोक १-७: विज्ञान सहित ज्ञान का विषय,इश्वर की व्यापकता\n" +
                    "श्लोक ८-१२: संपूर्ण पदार्थों में कारण रूप से भगवान की व्यापकता का कथन\n" +
                    "श्लोक १३-१९: आसुरी स्वभाव वालों की निंदा और भगवद्भक्तों की प्रशंसा\n" +
                    "श्लोक २०-२३: अन्य देवताओं की उपासना और उसका फल\n" +
                    "श्लोक २४-३०: भगवान के प्रभाव और स्वरूप को न जानने वालों की निंदा और जाननेवालों की महिमा",
            chapterContent = getHindiChapter7(),
            totalVerses = "कुल श्लोक: ३०"
        ),
        Chapter(
            chapterId = "8",
            chapter = "अध्याय ८",
            chapterName = "अक्षरब्रह्मयोग",
            description = "श्लोक १-७: ब्रह्म, अध्यात्म औरकर्मादि के विषय में अर्जुन के सात प्रश्न और उनका उत्तर\n" +
                    "श्लोक ८-२२: भगवानका परम धाम और भक्ति के सोलह प्रकार\n" +
                    "श्लोक २३-२८: शुक्लऔर कृष्ण मार्ग का वर्णन",
            chapterContent = getHindiChapter8(),
            totalVerses = "कुल श्लोक: २८"
        ),
        Chapter(
            chapterId = "9",
            chapter = "अध्याय ९",
            chapterName = "राजविद्याराजगुह्ययोग",
            description = "श्लोक १-६: परम गोपनीय ज्ञानोपदेश, उपासनात्मक ज्ञान, ईश्वर का विस्तार\n" +
                    "श्लोक ७-१०: जगत की उत्पत्ति का विषय\n" +
                    "श्लोक ११-१५: भगवान का तिरस्कार करने वाले आसुरी प्रकृति वालों की निंदा औरदेवी प्रकृति वालों के भगवद् भजन का प्रकार\n" +
                    "श्लोक १६-१९: सर्वात्म रूप से प्रभाव सहित भगवान के स्वरूप का वर्णन\n" +
                    "श्लोक २०-२५: सकाम और निष्काम उपासना का फल\n" +
                    "श्लोक २६-३४: निष्काम भगवद् भक्ति की महिमा",
            chapterContent = getHindiChapter9(),
            totalVerses = "कुल श्लोक: ३४"
        ),
        Chapter(
            chapterId = "10",
            chapter = "अध्याय १०",
            chapterName = "विभूतियोग",
            description = "श्लोक १-७: भगवान की विभूति और योगशक्ति का कथन तथा उनके जानने का फल\n" +
                    "श्लोक ८-११: फल और प्रभाव सहित भक्तियोग का वर्णन\n" +
                    "श्लोक १२-१८: अर्जुन द्वारा भगवान की स्तुति तथा विभूति और योगशक्ति को कहनेके लिए प्रार्थना\n" +
                    "श्लोक १९-४२: भगवान द्वारा अपनी विभूतियों और योगशक्ति का वर्णन",
            chapterContent = getHindiChapter10(),
            totalVerses = "कुल श्लोक: ४२"
        ),
        Chapter(
            chapterId = "11",
            chapter = "अध्याय ११",
            chapterName = "विश्वरूपदर्शनयोग",
            description = "श्लोक १-४: विश्वरूप के दर्शन हेतु अर्जुन की प्रार्थना\n" +
                    "श्लोक ५-८: भगवान द्वारा अपने विश्व रूप का वर्णन\n" +
                    "श्लोक ९-१४: संजय द्वारा धृतराष्ट्र के प्रति विश्वरूप का वर्णन\n" +
                    "श्लोक १५-३१: अर्जुन द्वारा भगवान के विश्वरूप का देखा जाना और उनकी स्तुतिकरना\n" +
                    "श्लोक ३२-३४: भगवान द्वारा अपने प्रभाव का वर्णन और अर्जुन को युद्ध के लिएउत्साहित करना\n" +
                    "श्लोक ३५-४६: भयभीत हुए अर्जुन द्वारा भगवान की स्तुति और चतुर्भुज रूप कादर्शन कराने के लिए प्रार्थना\n" +
                    "श्लोक ४७-५०: भगवान द्वारा अपने विश्वरूप के दर्शन की महिमा का वर्णन तथाचतुर्भुज और सौम्य रूप का दिखाया जाना\n" +
                    "श्लोक ५१-५५: बिना अनन्य भक्तिके चतुर्भुज रूप के दर्शन की दुर्लभता का और फलसहित अनन्य भक्ति का कथन।",
            chapterContent = getHindiChapter11(),
            totalVerses = "कुल श्लोक: ५५"
        ),
        Chapter(
            chapterId = "12",
            chapter = "अध्याय १२",
            chapterName = "भक्तियोग",
            description = "श्लोक १-१२: साकार और निराकार के उपासकों की उत्तमता का निर्णय औरभगवत्प्राप्ति के उपाय का वर्णन\n" +
                    "श्लोक १३-२०: भगवत्-प्राप्त पुरुषों के लक्षण",
            chapterContent = getHindiChapter12(),
            totalVerses = "कुल श्लोक: २०"
        ),
        Chapter(
            chapterId = "13",
            chapter = "अध्याय १३",
            chapterName = "क्षेत्र-क्षेत्रज्ञविभागयोग",
            description = "श्लोक १-१८: ज्ञानसहित क्षेत्र-क्षेत्रज्ञ का वर्णन\n" +
                    "श्लोक १९-३४: ज्ञानसहितप्रकृति-पुरुष का वर्णन",
            chapterContent = getHindiChapter13(),
            totalVerses = "कुल श्लोक: ३४"
        ),
        Chapter(
            chapterId = "14",
            chapter = "अध्याय १४",
            chapterName = "गुणत्रयविभागयोग",
            description = "श्लोक १-४: ज्ञान की महिमा और प्रकृति-पुरुष से जगत् की उत्पत्ति\n" +
                    "श्लोक ५-१८: सत्, रज, तम- तीनों गुणों का वर्णन\n" +
                    "श्लोक १९-२७: भगवत्प्राप्ति का उपाय और गुणातीत पुरुष के लक्षण",
            chapterContent = getHindiChapter14(),
            totalVerses = "कुल श्लोक: २७"
        ),
        Chapter(
            chapterId = "15",
            chapter = "अध्याय १५",
            chapterName = "पुरुषोत्तमयोग",
            description = "श्लोक १-६: संसाररूपी अश्वत्वृक्ष का स्वरूप और भगवत्प्राप्ति का उपाय\n" +
                    "श्लोक ७-११: इश्वरांश जीव, जीव तत्व के ज्ञाता और अज्ञाता\n" +
                    "श्लोक १२-१५: प्रभाव सहित परमेश्वर के स्वरूप का वर्णन\n" +
                    "श्लोक १६-२०: क्षर, अक्षर, पुरुषोत्तम का विश्लेषण",
            chapterContent = getHindiChapter15(),
            totalVerses = "कुल श्लोक: २०"
        ),
        Chapter(
            chapterId = "16",
            chapter = "अध्याय १६",
            chapterName = "दैवासुरसम्पद्विभागयोग",
            description = "श्लोक १-५: फलसहित दैवी और आसुरी संपदा का कथन\n" +
                    "श्लोक ६-२०: आसुरी संपदा वालों के लक्षण और उनकी अधोगति का कथन\n" +
                    "श्लोक २१-२४: शास्त्रविपरीत आचरणों को त्यागने और शास्त्रानुकूल आचरणों केलिए प्रेरणा",
            chapterContent = getHindiChapter16(),
            totalVerses = "कुल श्लोक: २४"
        ),
        Chapter(
            chapterId = "17",
            chapter = "अध्याय १७",
            chapterName = "श्रद्धात्रयविभागयोग",
            description = "श्लोक १-६: श्रद्धा और शास्त्रविपरीत घोर तप करने वालों का विषय\n" +
                    "श्लोक ७-२२: आहार, यज्ञ, तप और दान केपृथक-पृथक भेद\n" +
                    "श्लोक २३-२८: ॐतत्सत् के प्रयोग की व्याख्या",
            chapterContent = getHindiChapter17(),
            totalVerses = "कुल श्लोक: २८"
        ),
        Chapter(
            chapterId = "18",
            chapter = "अध्याय १८",
            chapterName = "मोक्षसंन्यासयोग",
            description = "श्लोक १-१२: त्याग का विषय\n" +
                    "श्लोक १३-१८: कर्मों के होने में सांख्यसिद्धांत का कथन\n" +
                    "श्लोक १९-४०: तीनों गुणों के अनुसार ज्ञान, कर्म, कर्ता,बुद्धि,धृतिऔर सुख के पृथक-पृथक भेद\n" +
                    "श्लोक ४१-४८: फल सहित वर्ण धर्म का विषय\n" +
                    "श्लोक ४९-५५: ज्ञाननिष्ठा का विषय\n" +
                    "श्लोक ५६-६६: भक्ति सहित कर्मयोग का विषय\n" +
                    "श्लोक ६७-७८: श्री गीताजी का माहात्म्य",
            chapterContent = getHindiChapter18(),
            totalVerses = "कुल श्लोक: ७८"
        )
    )
}