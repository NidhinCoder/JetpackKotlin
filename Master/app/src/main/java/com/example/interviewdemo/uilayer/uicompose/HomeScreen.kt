package com.example.interviewdemo.uilayer.uicompose

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
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

@OptIn(ExperimentalFoundationApi::class)
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

                    //In Illustrator it is 120 pixel.
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
                //For demo purpose, 2 pages with a common template Listbox holders
                //using LazyVertical Grid

                //Decide business logic
                //number of pages = array.size()/6
                //

                val numberOfPages = uiState.value.homePageContentMap?.size?:0

                val pagerState = rememberPagerState(pageCount = { numberOfPages })
                HorizontalPager(state = pagerState) { page ->
                    val featuresOfCurrentPage = uiState.value.homePageContentMap?.get(page)
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
                            items(featuresOfCurrentPage?.size ?: 0) { index ->

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {
                                    Button(onClick = {

                                    }) {
                                        Column()
                                        {
                                            Image(
                                                //painter = painterResource(id = uiState.value.homeData?.getOrNull(index)?.image?:R.drawable.seats),
                                                painter = painterResource(id = featuresOfCurrentPage?.getOrNull(index)?.image?:R.drawable.seats),//getDrawable(uiState)),
                                                contentDescription = "",
                                                contentScale = ContentScale.FillBounds,//To set the width and height stretch,
                                            )
                                            Text(
                                                //Study
                                                text = featuresOfCurrentPage?.getOrNull(index)?.title
                                                    ?: "",
                                                fontWeight = FontWeight.Normal,
                                                fontSize = 12.sp,
                                                color = Color(0xFFFFFFFF),
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.padding(16.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    )
                }
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



