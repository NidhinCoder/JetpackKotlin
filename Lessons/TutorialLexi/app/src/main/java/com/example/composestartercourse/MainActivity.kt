package com.example.composestartercourse

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestartercourse.ui.theme.ComposeStarterCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard("Tom","Jerry")
        }
    }
}

@Composable
fun MessageCard(text: String)
{
    Text("Hello$text")
}


//Layouts
@Composable
fun MessageCard(text1:String, text2:String)
{
    Row()
    {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Contact profile picture",
            modifier = Modifier.size(40.dp)
        )
        Column()
        {
            Text(text1)
            Text(text2)
        }
    }
}



@Preview
@Composable
fun PreviewMessageCard()
{
    MessageCard("Tom","Jerry")
}