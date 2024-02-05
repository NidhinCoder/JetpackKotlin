package com.example.composestartercourse

import SampleData
import android.content.res.Configuration
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


data class MyMessage(val author:String, val body:String)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStarterCourseTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    //MessageCard(MyMessage("Tom", "Jerry"))
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}

@Composable
fun MessageCard(text: String)
{
    Text("Hello$text")
}

//Layouts
/*
Material Design is built around three pillars: Color, Typography, and Shape.
* */
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
                .border(1.5.dp, MaterialTheme.colorScheme.primary)
        )
        Spacer(modifier = Modifier.width(8.dp))


        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if(isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            label = "",
        )

        //Make this column as clickable
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }){

            Text(
                text  = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall

            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium,
                    shadowElevation = 0.4.dp,
                    color = surfaceColor,
                    //use the animateContentSize modifier to animate the
                    // message container size smoothly:
                    modifier = Modifier.animateContentSize().padding(1.dp)
                    ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if(isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

//Lazy Columns and Lazy rows render items only when visible on screen
@Composable
fun Conversation(messages:List<MyMessage>)
{
    //Lazy column expects a items list, it will internally parse the list,
    //message is a lambda that will iterate on each items in the list and that
    //item can be processed as per business logic. Here it is used for MessageCard
    //It will be worked as a loop..

    LazyColumn{
        items(messages){message ->
            MessageCard(message)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Preview
@Composable
fun PreviewMessageCard()
{
    ComposeStarterCourseTheme {
        Surface {
            //MessageCard(MyMessage("Tom", "Jerry"))
            Conversation(messages = SampleData.conversationSample)
        }
    }
}