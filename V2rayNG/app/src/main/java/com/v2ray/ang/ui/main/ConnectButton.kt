package com.v2ray.ang.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
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
    val backgroundColor = if (isRunning) {
        colorFabActive
    } else {
        MaterialTheme.colorScheme.surfaceContainerHigh
    }
    val iconTint = if (isRunning) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.primary
    }
    val description = stringResource(if (isRunning) R.string.acc_stop else R.string.acc_start)

    Box(
        modifier = modifier
            .size(160.dp)
            .clip(CircleShape)
            .background(backgroundColor)
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
        Icon(
            painter = painterResource(
                if (isRunning) R.drawable.ic_stop_24dp else R.drawable.ic_play_24dp
            ),
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(72.dp),
        )
    }
}
