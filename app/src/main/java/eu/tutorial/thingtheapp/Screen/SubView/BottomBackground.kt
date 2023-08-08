package eu.tutorial.thingtheapp.Screen.SubView

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import eu.tutorial.thingtheapp.R

@Composable
fun BottomBackground(modifier: Modifier) {
    Surface(modifier = modifier
        .padding(bottom = 10.dp)
        .background(Color.White)) {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .offset((20).dp, 40.dp)
                    .graphicsLayer(
                        scaleX = 1.7f,
                        scaleY = 1.7f,
                        rotationX = 180f
                    ),
                colorFilter = ColorFilter.tint(Color(0xFFFFA500))
            )
            Button(modifier = Modifier
                .padding(10.dp)
                .offset(230.dp, y = 60.dp)
                .height(50.dp)
                .width(140.dp),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors( Color(0xFFB87333))

                ,onClick = { /*TODO*/ }) {
                Text(text = "Next", color = Color.Black)
            }
        }
    }
}
