package com.example.interviewdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interviewdemo.uilayer.theme.InterviewDemoTheme
import com.example.interviewdemo.uilayer.uicompose.HomeScreen
import com.example.interviewdemo.uilayer.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

//After adding hilt dependencies

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Here "by" is a delegate initializer
        //concept of get and set
        //https://kotlinlang.org/docs/delegation.html#overriding-a-member-of-an-interface-implemented-by-delegation
        val viewModel:MainViewModel by viewModels()
        viewModel.getHomeData()

        setContent {
            val uiState = viewModel._uiState.collectAsState()

            InterviewDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    HorizontalPagerScreen(uiState)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerScreen(uiState: State<MainViewModel.InterviewState>) {

    HomeScreen(uiState = uiState)

}

@Composable
fun ViewPagerItem(page: Int, preferredBackground: Color? = null) {
    val backgroundColor = preferredBackground ?: getBackgroundColorForItem(page)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page: $page")
    }
}

fun getBackgroundColorForItem(page: Int): Color {
    return when (page % 2 == 0) {
        true -> Color.LightGray
        false -> Color.Gray
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InterviewDemoTheme {
        Greeting("Android")
    }
}