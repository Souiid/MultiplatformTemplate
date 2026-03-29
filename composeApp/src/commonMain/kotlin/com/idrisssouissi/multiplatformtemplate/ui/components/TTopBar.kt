package com.idrisssouissi.multiplatformtemplate.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTopBar(
    isBackVisible: Boolean = false,
    isActionVisible: Boolean = false,
    title: String,
    progression: Float = 0f,
    onBackClick: () -> Unit = {},
    onFriendClick: () -> Unit = {},
    onMessageClick: () -> Unit = {},

) {

    val iconTint = MaterialTheme.colorScheme.onSecondary
    val progressColor = MaterialTheme.colorScheme.onSecondary
    val progressTrackColor = MaterialTheme.colorScheme.onSurfaceVariant

    Column {
        TopAppBar(
            windowInsets = WindowInsets(0, 0, 0, 0),
            title = { TText(title, style = TTextStyle.TITLE) },
            navigationIcon = {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clickable(
                            enabled = isBackVisible,
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            onBackClick()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = AppIcon.Back,
                        contentDescription = "Back",
                        tint = iconTint,
                        modifier = Modifier.alpha(if (isBackVisible) 1f else 0f)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier.statusBarsPadding(),
            actions = {
                if (isActionVisible) {
                    IconButton(onClick = { onFriendClick() }) {
                        Icon(
                            imageVector = AppIcon.Message,
                            contentDescription = "Message",
                            tint = iconTint
                        )
                    }

                    IconButton(onClick = { onMessageClick() }) {
                        Icon(
                            imageVector = AppIcon.Friend,
                            contentDescription = "Friend",
                            tint = iconTint
                        )
                    }
                }
            }
        )

        if (progression > 0f) {
            val animatedProgress by animateFloatAsState(
                targetValue = progression,
                animationSpec = tween(durationMillis = 500),
                label = "progression"
            )

            LinearProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier.fillMaxWidth(),
                color = progressColor,
                trackColor = progressTrackColor,
                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
            )
        }
    }
}