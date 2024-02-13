package com.jlrinterview.icim.cleanarchitecture.ui.reusableuicomponents
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jlrinterview.icim.cleanarchitecture.ui.constants.ColourCodes
import com.jlrinterview.icim.cleanarchitecture.ui.utilties.HexToJetpackColor

@Composable
fun ImageButton(imageId:Int) {
    Box() {
            val interactionSource = remember { MutableInteractionSource() }
            val isPressed by interactionSource.collectIsPressedAsState()
            TextButton(
                onClick = {},
                interactionSource = interactionSource
            ) {
                ImageComponent(isPressed, imageId)
            }
        }
}
@Composable
fun ImageComponent(isPressed: Boolean,imageId: Int) {

    val colorFilter = if (isPressed)
                            ColorFilter.tint(HexToJetpackColor.getColor(ColourCodes.reactionColor))
                      else  ColorFilter.tint(Color.White)
    Image(

        painter = painterResource(imageId),
        contentDescription = null,
        colorFilter = colorFilter
    )
}