package com.example.revisionproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.revisionproject.ui.navigation.Navigation
import com.example.revisionproject.ui.reusablecomponents.FeatureIButton


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Image(modifier = Modifier.fillMaxSize(), painter = painterResource(id = R.drawable.background) , contentDescription = "")
            Navigation()
        }
    }
}








