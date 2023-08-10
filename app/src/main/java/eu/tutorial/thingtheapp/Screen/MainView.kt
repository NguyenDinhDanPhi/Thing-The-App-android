package eu.tutorial.thingtheapp.Screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import eu.tutorial.thingtheapp.Model.User
import eu.tutorial.thingtheapp.Network.ApiRepository
import eu.tutorial.thingtheapp.Screen.SubView.BottomBackground
import eu.tutorial.thingtheapp.Screen.SubView.TopBackground

@Composable
fun MainContent(
    navController: NavController
) {
    var userChosen: Set<User> = emptySet()
    val apiRepo = ApiRepository()
    val user = produceState<List<User>>(initialValue = emptyList(), producer = {
        value = apiRepo.getAllUser()
    } )
    val selectedItemsState = remember { mutableSetOf<User>() }
    val showTicked = remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBackground()
        Box(modifier = Modifier.weight(1f)) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .height(400.dp)
                    .padding(horizontal = 10.dp)) {
                items(user.value) { user ->
                    Log.d("test113","a ${showTicked.value}")
                    ListOfUser(title = user.login,modifier = Modifier,
                        isSelected = selectedItemsState.contains(user),
                        onClick = {
                            showTicked.value = selectedItemsState.contains(user)
                            if (selectedItemsState.contains(user)) {
                                selectedItemsState.remove(user)
                            } else {
                                selectedItemsState.add(user)

                            }
                            showTicked.value = selectedItemsState.contains(user)
                            userChosen = selectedItemsState
                            Log.d("test","user ${userChosen}")
                        })
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
                    navController.navigate(route = "${ScreenManager.DisplayUserChosen.route}/${userChosen}")
                }) {
                Text(text = "Next", color = Color.Black)
            }
        }

    }
}


