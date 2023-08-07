package eu.tutorial.thingtheapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBackground()
        ListOfUser(modifier = Modifier.weight(1f))
        BottomBackground(modifier = Modifier.offset(0.dp,25.dp))
    }
}


@Composable
fun ListOfUser(modifier: Modifier) {
    val apiRepo = ApiRepository()
    val user = produceState<List<User>>(initialValue = emptyList(), producer = {
        value = apiRepo.getAllUser()
    } )
        Box(modifier = modifier
            .height(300.dp)
            .fillMaxWidth(), contentAlignment = Alignment.Center) {
            LazyColumn(modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .graphicsLayer {
                    clip = true
                }) {
                items(user.value) { item ->
                    Surface(
                        modifier = modifier
                            .fillMaxSize(),
                        color = Color(0xFFFFA500), shape = RoundedCornerShape(9.dp)
                    ) {
                        Text(
                            item.login, modifier = modifier
                                .padding(15.dp),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp, // Kích thước chữ (24sp)
                                color = Color.White, // Màu chữ
                                fontWeight = FontWeight.SemiBold // Trọng lượng chữ (in đậm)
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }

            }
        }
}

@Preview
@Composable
fun TopBackground() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .offset((-75).dp, -40.dp)
                    .graphicsLayer(
                        scaleX = 1.7f,
                        scaleY = 1.4f,
                        rotationY = 180f
                    ),
                colorFilter = ColorFilter.tint(Color(0xFFFFA500)) // Mã màu cho màu cam (orange)
            )
            Text(
                text = "THINGS \nThe App",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.SemiBold),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp)
            )
        }

    }
}
@Composable
fun BottomBackground(modifier: Modifier) {
    Surface(modifier = modifier
        .padding(bottom = 10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .offset((20).dp, 40.dp)
                .graphicsLayer(
                    scaleX = 1.7f,
                    scaleY = 1.5f,
                    rotationX = 180f
                ),
            colorFilter = ColorFilter.tint(Color(0xFFFFA500)) // Mã màu cho màu cam (orange)
        )
    }
}
