package eu.tutorial.thingtheapp.Screen

import android.os.Parcelable
import android.util.Log
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorial.thingtheapp.Model.User
import eu.tutorial.thingtheapp.Screen.SubView.BottomBackground
import eu.tutorial.thingtheapp.Screen.SubView.TopBackground

@Composable
fun DisplayUserChosenContent(){
    Surface(modifier = Modifier.fillMaxSize()) {

        Column {
            TopBackground()
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .weight(1f)
                .padding(horizontal = 15.dp)) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.height(400.dp)) {
                    items(10) {item  ->
                       ListOfUser(title = "haha", modifier = Modifier
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
                        }

                    }
                }
            }
            BottomBackground(modifier = Modifier.offset(y = 20.dp))

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

@Preview
@Composable
fun PreviewDisplayStringArray() {
    val stringArray = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10")
    DisplayStringArray(stringArray)
}