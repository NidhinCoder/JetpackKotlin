package com.example.composestartercourse

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestartercourse.ui.theme.ComposeStarterCourseTheme

data class MyMessage(val author:String, val body:String)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(MyMessage("Tom","Jerry"))
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
fun MessageCard(msg: MyMessage)
{
    Row()
    {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column()
        {
            Text(msg.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(msg.body)
        }
    }
}



@Preview
@Composable
fun PreviewMessageCard()
{
    MessageCard(MyMessage("Tom","Jerry"))
}