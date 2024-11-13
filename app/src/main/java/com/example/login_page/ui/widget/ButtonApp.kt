package com.example.login_page.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_page.ui.theme.ColorApp

@Composable
fun ButtonApp(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = ColorApp.transparent,
    textColor: Color = ColorApp.black,
    textSize: TextUnit = 30.sp,
    isFullWidth: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(all = 4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = if (isFullWidth) Modifier.fillMaxSize() else Modifier,
            contentAlignment = Alignment.Center
        ) {
            Text(text = label, style = TextStyle(fontSize = textSize, color = textColor))
        }
    }
}