package com.idrisssouissi.multiplatformtemplate.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.idrisssouissi.multiplatformtemplate.ui.components.TTopBar

@Composable
fun TScaffold(
    isBackVisible: Boolean = false,
    title: String = "",
    progression: Float = 0f,
    onBackClick: () -> Unit = {},
    onFriendClick: () -> Unit = {},
    onMessageClick: () -> Unit = {},
    isActionVisible: Boolean = false,
    content: @Composable (PaddingValues) -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TTopBar(
                isBackVisible = isBackVisible,
                title = title,
                progression = progression,
                onBackClick = onBackClick,
                onFriendClick = onFriendClick,
                onMessageClick = onMessageClick,
                isActionVisible = isActionVisible
            )
        }
    ) { innerPadding ->

        content(innerPadding)

    }
}