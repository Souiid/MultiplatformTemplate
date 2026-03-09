package com.idrisssouissi.multiplatformtemplate.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TTextStyle
import com.idrisssouissi.multiplatformtemplate.ui.theme.Black
import com.idrisssouissi.multiplatformtemplate.ui.theme.Blue
import com.idrisssouissi.multiplatformtemplate.ui.theme.LightGray
import com.idrisssouissi.multiplatformtemplate.ui.theme.White

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
            title = { TText(title, style = TTextStyle.TITLE) },
            navigationIcon = if (isBackVisible) {
                {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = AppIcon.Back,
                            contentDescription = "Back",
                            tint = iconTint
                        )
                    }
                }
            } else {
                {}
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