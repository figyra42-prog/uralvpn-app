package com.v2ray.ang.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.v2ray.ang.R
import com.v2ray.ang.ui.compose.colorFabActive

/**
 * Large central connect/disconnect button, styled after the UralVPN brand.
 */
@Composable
fun ConnectButton(
    isRunning: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundBrush = if (isRunning) {
        Brush.linearGradient(listOf(Color(0xFFE6FF7A), colorFabActive))
    } else {
        Brush.linearGradient(
            listOf(Color(0xFF2E2D33), MaterialTheme.colorScheme.surfaceContainerHigh)
        )
    }
    val description = stringResource(if (isRunning) R.string.acc_stop else R.string.acc_start)

    Box(
        modifier = modifier
            .size(180.dp)
            .shadow(
                elevation = if (isRunning) 30.dp else 16.dp,
                shape = CircleShape,
                ambientColor = if (isRunning) colorFabActive else Color.Black,
                spotColor = if (isRunning) colorFabActive else Color.Black,
            )
            .clip(CircleShape)
            .background(backgroundBrush)
            .then(
                if (isRunning) {
                    Modifier
                } else {
                    Modifier.border(2.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape)
                }
            )
            .semantics { contentDescription = description }
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        if (isRunning) {
            Text(
                text = "🏔",
                fontSize = 64.sp,
            )
        } else {
            Icon(
                painter = painterResource(R.drawable.ic_play_24dp),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(64.dp),
            )
        }
    }
}
