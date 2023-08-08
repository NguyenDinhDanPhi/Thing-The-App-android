package eu.tutorial.thingtheapp.Screen.SubView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorial.thingtheapp.R

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
                colorFilter = ColorFilter.tint(Color(0xFFFFA500))
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
