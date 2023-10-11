package com.example.gitagyan.screens.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ListItemDefaults.containerColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitagyan.R
import com.example.gitagyan.data.content.Language
import com.example.gitagyan.screens.components.topbar.TopBottomBar

@Composable
fun ProfileScreen(navController: NavController){
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        Profile()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFD950E)
    ) {
        Surface(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 15.dp)
                .width(1000.dp)
                .height(500.dp),
            shape = RoundedCornerShape(corner = CornerSize(40.dp)),
            color = Color.White,
            contentColor = Color.Black
        ) {
            Row(
                Modifier.padding(top = 45.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Box {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.krishna_arjuna),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )

                        val context = LocalContext.current
                        val languages = arrayOf("English", "Hindi")
                        var expanded by remember { mutableStateOf(false) }
                        val selectionLanguage = if (Language.selectedLanguage == "English") "Select a language" else "भाषा चुनें"

                        Text(
                            text = selectionLanguage,
                            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.Serif,
                            style = MaterialTheme.typography.titleMedium
                        )

                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = {
                                expanded = !expanded
                            }
                        ) {
                            OutlinedTextField(
                                value = Language.selectedLanguage,
                                onValueChange = {
                                                Language.selectedLanguage = it
                                },
                                modifier = Modifier.menuAnchor(),
                                readOnly = true,
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = containerColor,
                                    unfocusedContainerColor = containerColor,
                                    disabledContainerColor = containerColor,
                                )
                            )

                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                languages.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(text = item) },
                                        onClick = {
                                            Language.selectedLanguage = item
                                            expanded = false
                                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                        }
                                    )
                                }
                            }
                        }

                        Divider(modifier = Modifier.padding(15.dp),
                            color = Color.LightGray)

                        Column(modifier = Modifier
                            .padding(5.dp)
                            .verticalScroll(state = ScrollState(0)),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = if(Language.selectedLanguage == "English") "About Gita Gyan" else "गीता ज्ञान के बारे में",
                                modifier = Modifier.padding(5.dp),
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center)
                            Text(
                                text = if (Language.selectedLanguage == "English"){"The Shrimad Bhagavad Gita, often referred to as the Gita, is a 700-verse scripture. It encapsulates the essence of the Vedas. Its language is so sweet and simple that humans can easily understand it with a little practice. However, the thoughts within it are so profound that one cannot grasp their depths even after constant study throughout a lifetime.\n"+
                                        "As the creator of this application, I am thankful that I had the opportunity to read the Bhagavad Gita at the age of 18, a time when life seemed to be full of chaos. The Gita guided me through these challenging paths, providing me with an attitude and perspective that have since become the foundation of my life's thoughts.\n"+
                                        "I would also like to express my heartfelt gratitude to all my friends who, in some way or another, were a part of building this application. Happy reading!"}
                                        else{
                                    "श्रीमद्भगवद्गीता, जिसे अक्सर गीता भी कहा जाता है, 700 श्लोकों वाला ग्रंथ है। इसमें वेदों का सार समाहित है। इसकी भाषा इतनी मधुर और सरल है कि थोड़े से अभ्यास से मनुष्य इसे आसानी से समझ सकता है। हालांकि, विचार इसके भीतर इतनी गहराई है कि जीवन भर निरंतर अध्ययन के बाद भी कोई उनकी गहराई को समझ नहीं सकता है।\n"+
                                            "इस एप्लिकेशन के निर्माता के रूप में, मैं आभारी हूं कि मुझे 18 साल की उम्र में भगवद गीता पढ़ने का अवसर मिला, जब जीवन अराजकता से भरा हुआ लग रहा था। गीता ने मुझे इन चुनौतीपूर्ण रास्तों के माध्यम से मार्गदर्शन किया, मुझे प्रदान किया एक दृष्टिकोण और परिप्रेक्ष्य जो तब से मेरे जीवन के विचारों की नींव बन गया है।\n"+
                                            "मैं अपने सभी दोस्तों के प्रति भी हार्दिक आभार व्यक्त करना चाहता हूं, जो किसी न किसी तरह से इस एप्लिकेशन के निर्माण का हिस्सा थे। आपको शुभकामनाएं!"
                                            },
                                modifier = Modifier.padding(5.dp),
                                fontSize = 15.sp,
                                style = androidx.compose.material.MaterialTheme.typography.caption,
                                textAlign = TextAlign.Justify
                            )
                        }
                    }
                }
            }
        }
    }
}