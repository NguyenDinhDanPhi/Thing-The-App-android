package eu.tutorial.thingtheapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.log


@Composable
fun ListOfUser(title: String,modifier: Modifier, isSelected: Boolean, onClick: () -> Unit) {

        Surface(modifier = modifier
            .height(65.dp)
            .fillMaxWidth()
            ,
            color = Color(0xFFFFA500), shape = RoundedCornerShape(9.dp)
        ) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                .clickable {
                    onClick()
                }) {
                Box(modifier = Modifier.width(120.dp), contentAlignment = Alignment.Center) {

                    Text(
                        title, modifier = modifier
                            .clickable {
                                onClick()
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
                    Box(
                        modifier = Modifier
                            .padding(20.dp)
                            .height(25.dp)
                            .width(25.dp)
                            .offset(150.dp)

                    ) {
                        if (isSelected) {
                            Image(
                                painter = painterResource(id = R.drawable.checked),
                                colorFilter = ColorFilter.tint(
                                    Color.Gray
                                ),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier

                            )
                        } else {
                            Box() {}
                        }

                    }
                }

            }
        }

}

@Preview(showBackground = true)
@Composable
fun PreviewList() {

     ListOfUser(title = "hahahahaha",modifier = Modifier, isSelected = true, onClick = {})


}