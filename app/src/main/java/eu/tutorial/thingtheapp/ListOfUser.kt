package eu.tutorial.thingtheapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorial.thingtheapp.Model.User
import eu.tutorial.thingtheapp.Network.ApiRepository

@Composable
fun ListOfUser(modifier: Modifier, isSelected: Boolean, onClick: () -> Unit) {
    val apiRepo = ApiRepository()
    val user = produceState<List<User>>(initialValue = emptyList(), producer = {
        value = apiRepo.getAllUser()
    } )
    val selectedItemsState = remember { mutableStateOf<Set<User>>(emptySet()) }

    Box(modifier = modifier
        .height(300.dp)
        .fillMaxWidth(), contentAlignment = Alignment.Center) {
        LazyColumn(modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .graphicsLayer {
                clip = true
            }) {
            items(5) { item ->

                Surface(
                    modifier = modifier
                        .fillMaxSize(),
                    color = Color(0xFFFFA500), shape = RoundedCornerShape(9.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.Center) {
                        Text(
                            item.toString(), modifier = modifier
                                .clickable {
                                }
                                .padding(19.dp)
                            ,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Box(contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(20.dp)) {
                            if (isSelected) {
                                Image(
                                    painter = painterResource(id = R.drawable.checked),
                                    colorFilter = ColorFilter.tint(
                                        Color.Gray
                                    ),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .height(25.dp)
                                        .width(25.dp)
                                        .padding()
                                )
                            } else {
                                Box() {}
                            }

                        }
                    }


                }
                Spacer(modifier = Modifier.height(15.dp))
            }

        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Transparent,
                        Color.White
                    )
                )
            ))
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewList() {

     ListOfUser(modifier = Modifier, isSelected = false, onClick = {})


}