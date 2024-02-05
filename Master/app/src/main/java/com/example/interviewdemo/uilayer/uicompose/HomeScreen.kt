package com.example.interviewdemo.uilayer.uicompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interviewdemo.R
import com.example.interviewdemo.uilayer.viewmodel.MainViewModel


@Composable
fun HomeScreen(uiState: State<MainViewModel.InterviewState>) {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "",
            Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds//To set the width and height stretch
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,

            )
        {

            //Left sidebar
            Box(
                modifier = Modifier
                    .fillMaxHeight()

                    .width(60.dp)
            )
            {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(10.dp)
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = ""
                    )
                }
            }

            //Middle area
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(520.dp)
            )
            {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),

                    // content padding
                    contentPadding = PaddingValues(
                        start = 12.dp,
                        top = 16.dp,
                        end = 12.dp,
                        bottom = 16.dp
                    ),
                    content = {
                        items(uiState.value.homeData?.size?:0) { index ->
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(4.dp),
                                    verticalArrangement = Arrangement.Center,


                            ) {
                                Image(
                                    //painter = painterResource(id = uiState.value.homeData?.getOrNull(index)?.image?:R.drawable.seats),
                                    painter = painterResource(id = getDrawable(uiState)),
                                    contentDescription = "",
                                    contentScale = ContentScale.FillBounds//To set the width and height stretch
                                )

                                Text(
                                    //Study
                                    text = uiState.value.homeData?.getOrNull(index)?.title?:"",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp,
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                    }
                )
            }

            //Right sidebar
            Box(
                modifier = Modifier
                    .fillMaxHeight()

                    .width(60.dp)
            )
            {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(10.dp)
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = ""
                    )
                }
            }

        }
    }
}

fun getDrawable(uiState: State<MainViewModel.InterviewState>): Int {

    return R.drawable.seats

    //uiState.value.homeData?.getOrNull(index)?.image?:R.drawable.seats
}
