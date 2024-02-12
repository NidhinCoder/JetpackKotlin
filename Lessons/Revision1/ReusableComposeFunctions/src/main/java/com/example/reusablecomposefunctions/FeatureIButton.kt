package com.example.reusablecomposefunctions

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource



@Composable
fun FeatureContent(imageResourceID:Int, featureName:String, textColor: Color){

    Column(modifier = Modifier.background(Color.Transparent)) {
        Image(
            modifier = Modifier
                .width(Constants.featureItemWidth)
                .height(Constants.featureItemHeight)
                .align(Alignment.CenterHorizontally),
                painter = painterResource(id = imageResourceID),
                contentDescription = "",
        )
        Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = featureName, fontSize = Constants.featureFontSize, color = textColor)
    }

}

@Composable
fun FeatureIButton(onClick: () -> Unit,
                   imageResourceId:Int,
                   featureName:String) {

    val initialColor  =  Color.White
    val textColorState = remember { mutableStateOf(initialColor) }

    TextButton(
        onClick = onClick) {
        FeatureContent(featureName = featureName,
                       imageResourceID = imageResourceId,
                       textColor = textColorState.value
                      )
    }
}