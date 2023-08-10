package eu.tutorial.thingtheapp.Screen

import android.os.Parcelable
import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import eu.tutorial.thingtheapp.Model.User
import eu.tutorial.thingtheapp.Screen.SubView.BottomBackground
import eu.tutorial.thingtheapp.Screen.SubView.TopBackground
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun DisplayUserChosenContent(navController: NavController, userSet: Set<User>?){
    val userLogin = handleString(userSet)
    val random = Random.nextInt(0,userLogin.size)
    val userSelected = userLogin[random]

    var count = remember {
        mutableStateOf(3)
    }
    val color by animateColorAsState(if (count.value > 0) Color.Red else Color.Green)
    val textSize by animateDpAsState(targetValue = if (count.value > 0) 64.dp else 96.dp)
    LaunchedEffect(count.value) {
        if (count.value > 0) {
            delay(1000)
            count.value--
        }
    }
    Surface(modifier = Modifier.fillMaxSize()) {

        Column {
            TopBackground()
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .weight(1f)
                .padding(horizontal = 15.dp)) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.height(400.dp)) {
                    items(userLogin.size) {item  ->
                        val name = userLogin[item]
                       ListOfUser(title = name, modifier = Modifier
                           .width(180.dp)
                           .height(50.dp), isSelected = false ) {

                       }
                    }

                }
                Spacer(modifier = Modifier.width(20.dp))
                Box(modifier = Modifier
                    .height(150.dp)
                    .width(160.dp)
                    .clip(RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center) {
                    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFFFA500)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Chosen Thing",
                                modifier = Modifier.padding(vertical = 15.dp),
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp
                            )
                            if (count.value > 0) {
                                Text(text = "${count.value}",
                                    color = Color.White,
                                    textAlign = TextAlign.Center, fontSize = 18.sp)
                            } else {
                                Text(text = userSelected,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp ,
                                    fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 20.dp))
                            }
                        }

                    }
                }
            }
            Box {
                BottomBackground(modifier = Modifier.offset(0.dp,15.dp))
                Button(modifier = Modifier
                    .padding(10.dp)
                    .offset(220.dp, y = 70.dp)
                    .height(50.dp)
                    .width(140.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors( Color(0xFFB87333))

                    ,onClick = {
                        navController.popBackStack()
                    }) {
                    Text(text = "Back", color = Color.Black)
                }
            }

        }
    }
}

@Composable
fun DisplayStringArray(stringArray: Array<String>) {
    LazyColumn {
        items(stringArray.size) { index ->
            val item = stringArray[index]
            Text(text = item, fontWeight = FontWeight.Bold)
        }
    }
}
fun handleString(userSet: Set<User>?) : List<String> {
    val test = userSet?.first()?.login
    val charSequence: CharSequence = StringBuilder(test)

    val regex = Regex("User\\(login=([^\\)]+)\\)")
    val matches = regex.findAll(charSequence)
    val usernames = matches.map { it.groupValues[1] }.toList()

    return  usernames
}
@Preview
@Composable
fun PreviewDisplayStringArray() {
    val stringArray = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10")
    DisplayStringArray(stringArray)
}