package com.company.genderize.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.company.genderize.R
import com.company.genderize.model.Genderize
import com.company.genderize.model.GenderizeRepository
import com.company.genderize.ui.theme.GenderizeTheme
import kotlinx.coroutines.runBlocking

@Composable
fun ScreenMain (){
    var result by remember { mutableStateOf(Genderize("","",0.0,0))}
    var text by remember { mutableStateOf("") }
    GenderizeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painterResource(
                    id = R.drawable.male_and_female_icon),
                    contentDescription = "Male & Female Gender Icons"
                )
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Label") }
                )
                Button(
                    onClick = {
                        if (text != "") {
                            runBlocking {
                                result = GenderizeRepository().getName(text)
                            }
                            Log.d("TAG", result.toString())
                        }
                    },
                    contentPadding = PaddingValues(5.dp)
                ) {
                    Text("Check Gender")
                }
                Row {
                    Column(Modifier.padding(5.dp)) {
                        Text("Name")
                        Text("Gender")
                        Text("Probability")
                        Text("Count")
                    }
                    Column(Modifier.padding(5.dp)) {
                        Text(result.name)
                        Text(result.gender)
                        Text(result.probability.toString())
                        Text(result.count.toString())
                    }
                }
            }
        }
    }
}
