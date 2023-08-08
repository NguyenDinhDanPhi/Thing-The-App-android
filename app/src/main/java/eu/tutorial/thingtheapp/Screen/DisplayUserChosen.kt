package eu.tutorial.thingtheapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorial.thingtheapp.R
import java.util.ArrayList

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DisplayUserChosenContent(){

    Surface(modifier = Modifier.fillMaxSize()) {
        Row() {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.height(400.dp)) {
                items(10) {it ->
                   ListOfUser(title = "haha", modifier = Modifier
                       .width(200.dp)
                       .height(50.dp), isSelected = false ) {
                       
                   }
                }
            }
        }
    }
}

