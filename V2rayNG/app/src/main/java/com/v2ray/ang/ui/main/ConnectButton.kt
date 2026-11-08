package com.v2ray.ang.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
        Brush.radialGradient(
            colors = listOf(Color(0xFFFDFFCC), colorFabActive, Color(0xFF77A824)),
            center = Offset(0.30f, 0.22f),
            radius = 1.9f,
        )
    } else {
        Brush.radialGradient(
            colors = listOf(Color(0xFF56555F), Color(0xFF2A292F), Color(0xFF0A0A0D)),
            center = Offset(0.30f, 0.22f),
            radius = 1.9f,
        )
    }
    val description = stringResource(if (isRunning) R.string.acc_stop else R.string.acc_start)

    Box(
        modifier = modifier
            .size(180.dp)
            .shadow(
                elevation = if (isRunning) 24.dp else 16.dp,
                shape = CircleShape,
                ambientColor = if (isRunning) {
                    colorFabActive.copy(alpha = 0.15f)
                } else {
                    Color.Black.copy(alpha = 0.55f)
                },
                spotColor = if (isRunning) {
                    colorFabActive.copy(alpha = 0.15f)
                } else {
                    Color.Black.copy(alpha = 0.55f)
                },
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
        Text(
            text = "⏻",
            fontSize = 72.sp,
            color = if (isRunning) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
        )
    }
}
