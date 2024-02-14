package com.jlrinterview.icim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.jlrinterview.icim.cleanarchitecture.ui.navigation.ApplicationGUI
import com.jlrinterview.icim.cleanarchitecture.ui.theme.MyApplicationTheme
import com.jlrinterview.icim.cleanarchitecture.ui.viewmodel.HomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                //val viewModel:HomeScreenViewModel by viewModels()
                //val uiState = viewModel.uiHomeScreenState.collectAsState()

                //ApplicationGUI(uiState)
                test()
            }
        }
    }
}
@Composable
fun test()
{
    Text("Hi Nidhin")
}































//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Greeting("Android")
//    }
//}