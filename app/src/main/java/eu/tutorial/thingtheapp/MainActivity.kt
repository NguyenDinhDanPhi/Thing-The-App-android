package eu.tutorial.thingtheapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorial.thingtheapp.Model.User
import eu.tutorial.thingtheapp.Network.ApiRepository

import eu.tutorial.thingtheapp.ui.theme.ThingTheAppTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThingTheAppTheme {
                MainContent()
            }
        }
    }
}
@Composable
fun MainContent() {
    val apiRepo = ApiRepository()
    val user = produceState<List<User>>(initialValue = emptyList(), producer = {
        value = apiRepo.getAllUser()
    } )
   Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
       LazyColumn(modifier = Modifier
           .height(400.dp)
           .width(250.dp)) {
           items(user.value) {item ->
               Surface(modifier = Modifier
                   .fillMaxSize(),
                   color = Color(0xFFFFA500), shape = RoundedCornerShape(10.dp)
               ) {
                   Text(item.login, modifier = Modifier.padding(10.dp), textAlign = TextAlign.Center)
               }
               Spacer(modifier = Modifier.height(10.dp))
           }
       }
   }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThingTheAppTheme {
    }
}